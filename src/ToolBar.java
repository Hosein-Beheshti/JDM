import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar {

    private JButton newDownload;
    private JButton pause;
    private JButton resume;
    private JButton remove;
    private JButton cancel;
    private JButton setting;


    public ToolBar() {
     //   this.setBackground(Color.getColor("",12878));

        GridLayout layout = new GridLayout();
        this.setLayout(new FlowLayout(0));
        ImageIcon addicon = new ImageIcon("add.png");
        newDownload = new JButton(addicon);
        pause = new JButton("");
        resume = new JButton("");
        remove = new JButton("");
        cancel = new JButton("");
        setting = new JButton("");

        this.setSize(10,10);
        this.add(newDownload);
        this.add(pause);
        this.add(resume);
        this.add(remove);
        this.add(cancel);
        this.add(setting);
    }



}
