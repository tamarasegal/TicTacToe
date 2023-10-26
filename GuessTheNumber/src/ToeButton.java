import javax.swing.*;
public class ToeButton extends JButton {
    private int status; //-1 is X, 0 is empty, and 1 is O
    public ToeButton() {
        status = 0;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }


}
