import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MainPanel extends JPanel{
    public static ArrayListDownloadBoxes arrayListDownloadBoxes;
    public MainPanel()
    {
        arrayListDownloadBoxes = new ArrayListDownloadBoxes();
        GridLayout layout = new GridLayout(4,1);
        this.setLayout(layout);


    }
}
