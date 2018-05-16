import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDownloadBoxes extends ArrayList{

    public ArrayListDownloadBoxes()
    {


    }
    public void addBoxes ()
    {
        System.out.println(this.size());
        Iterator it = this.iterator();
        while (it.hasNext())
        {
            Main.mainPanel.add((JPanel)it.next());
        }
    }
}
