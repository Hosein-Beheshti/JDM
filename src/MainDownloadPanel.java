import javax.swing.*;
import java.awt.*;

public class MainDownloadPanel extends JPanel {
    GridLayout layout;

    public MainDownloadPanel() {
        layout = new GridLayout(4, 1);
        this.setLayout(layout);
    }

    public void increasRowa(int size) {
        layout.setRows(size);
    }
}

