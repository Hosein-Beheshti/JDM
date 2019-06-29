import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MainPanel extends JPanel {
    MainDownloadPanel mainDownloadPanel;

    public MainPanel(JPanel mainDownloadPanel) {
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);

        this.add(mainDownloadPanel, BorderLayout.NORTH);
    }
}
