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
    private JButton addToQueue;


    public ToolBar() {

        this.setFloatable(false);
     //   this.setBackground(Color.getColor("",12878));

        GridLayout layout = new GridLayout();
        this.setLayout(new FlowLayout(0));
        ImageIcon addicon = new ImageIcon("add.png");
        newDownload = new JButton(addicon);
        newDownload.setBackground(null);
        newDownload.setToolTipText("Add a new task");
        newDownload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewDownload newDownload = new NewDownload();
            }
        });

        ImageIcon pauseIcon = new ImageIcon("pause.png");
        pause = new JButton(pauseIcon);
        pause.setToolTipText("Pause");

        ImageIcon resumeIcon = new ImageIcon("resume.png");
        resume = new JButton(resumeIcon);
        resume.setToolTipText("Resume");

        ImageIcon removeIcon = new ImageIcon("remove.png");
        remove = new JButton(removeIcon);
        remove.setToolTipText("Remove");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.arrayListDownloadBoxes.remove();
            }
        });

        ImageIcon cancelIcon = new ImageIcon("cancel.png");
        cancel = new JButton(cancelIcon);
        cancel.setToolTipText("Cancel");

        ImageIcon settingIcon = new ImageIcon("setting.png");
        setting = new JButton(settingIcon);
        setting.setToolTipText("Setting");
        setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Setting setting = new Setting();
            }
        });
        ImageIcon addToQueueIcon = new ImageIcon("queue.png");
        addToQueue = new JButton(addToQueueIcon);
        addToQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.arrayListDownloadBoxes.addBoxesToArrayQueue();
            }
        });

        this.setSize(10,10);
        this.add(newDownload);
        this.add(pause);
        this.add(resume);
        this.add(remove);
        this.add(cancel);
        this.add(setting);
        this.add(addToQueue);
    }



}
