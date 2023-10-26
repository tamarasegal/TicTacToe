import javax.swing.*;
import java.awt.*;
public class TGame {
    private ToeButton [] squares; //in
    //-1 is X, 0 is empty, and 1 is O
    private JFrame frame; //out

    private JPanel[] layers; //out
    private JLabel indicator; //says x go or o go n shit like that
    private int currentPlayer; //even is x, odd is o

    public TGame () {
        squares = new ToeButton[9];
        for (int i = 0; i < 9; i++) {
            squares[i] = new ToeButton();
            squares[i].addActionListener(new ActionListenerT(this));
        }
        frame = new JFrame();
        frame.setLayout(new GridLayout(4, 1));
        layers = new JPanel [3];
        for (int i = 0; i < 3; i++)
            layers[i] = new JPanel();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                layers[i].add(squares[i*3+j]);
        currentPlayer = 0;
        indicator = new JLabel("Click any square to start. X goes first");
        frame.add(indicator);
        for (int i = 0; i < 3; i++)
            frame.add(layers[i]);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    public void setCurrentPlayer(int x) {
        currentPlayer = x;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean checkWinX() {
        //if there are three X's in a row
        for (int i = 0; i < 7; i+=3)
            if (squares[i].getStatus() + squares[i+1].getStatus() + squares[i+2].getStatus() == -3)
                return true;

        //if there are three X's in a column
        for (int i = 0; i < 3; i++)
            if (squares[i].getStatus() + squares[i+3].getStatus() + squares[i+6].getStatus() == -3)
                return true;

        //3 diagonally from left to right
        if (squares[0].getStatus() + squares[4].getStatus() + squares[8].getStatus() == -3)
            return true;

        //3 diagonally from right to left
        if (squares[2].getStatus() + squares[4].getStatus() + squares[6].getStatus() == -3)
            return true;

        return false;
        }

    public boolean checkWinO() {
        //if there are three X's in a row
        for (int i = 0; i < 7; i+=3)
            if (squares[i].getStatus() + squares[i+1].getStatus() + squares[i+2].getStatus() == 3)
                return true;

        //if there are three X's in a column
        for (int i = 0; i < 3; i++)
            if (squares[i].getStatus() + squares[i+3].getStatus() + squares[i+6].getStatus() == 3)
                return true;

        //3 diagonally from left to right
        if (squares[0].getStatus() + squares[4].getStatus() + squares[8].getStatus() == 3)
            return true;

        //3 diagonally from right to left
        if (squares[2].getStatus() + squares[4].getStatus() + squares[6].getStatus() == 3)
        return true;

        return false;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            squares[i].setStatus(0);
            squares[i].setText("");
        }
        currentPlayer = 0;
        indicator.setText("Click any square to begin. X goes first.");
    }

    public void setIndicator(String player) {
        if (player.equals("x")) {
            indicator.setText("O's turn");
        }
        if (player.equals("o")) {
            indicator.setText("X's turn");
        }
    }
}
