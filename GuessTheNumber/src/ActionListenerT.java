import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ActionListenerT implements ActionListener{
    private TGame t;
    public ActionListenerT(TGame t) {
        this.t = t;
    }

    public void actionPerformed(ActionEvent e) {
        ToeButton source = (ToeButton) e.getSource();
        if (t.getCurrentPlayer() % 2 == 0) {
            source.setText("X");
            source.setStatus(-1);
            t.setIndicator("x");
        }
        else {
            source.setText("O");
            source.setStatus(1);
            t.setIndicator("o");
        }
        if (t.checkWinX()) {
            JOptionPane.showMessageDialog(t.getFrame(), "X Won!");
            t.resetGame();
        }
        else if (t.checkWinO()) {
            JOptionPane.showMessageDialog(t.getFrame(), "O Won!");
            t.resetGame();
        }
        else if (t.getCurrentPlayer() >= 8) {
            JOptionPane.showMessageDialog(t.getFrame(), "No one won. whomp... whomp... whomp!");
            t.resetGame();
        }

        else
            t.setCurrentPlayer(t.getCurrentPlayer() + 1);
    }
}
