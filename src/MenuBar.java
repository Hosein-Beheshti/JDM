import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {
    private JMenu downloads;
    private JMenu help;

    private JMenuItem newDownload;
    private JMenuItem pause;
    private JMenuItem resume;
    private JMenuItem cancel;
    private JMenuItem remove;
    private JMenuItem setting;
    private JMenuItem exit;

    private JMenuItem about;

    public MenuBar() {
        //new "downloads" that is a object of JMenu class
        downloads = new JMenu("Download");
        //set a suitable Mnemonic for downloads JMenu
        downloads.setMnemonic(KeyEvent.VK_D);
        //new "help" that is a object of JMenu class
        help = new JMenu("Help");
        //set a suitable Mnemonic for downloads JMenu
        help.setMnemonic(KeyEvent.VK_H);

        this.add(downloads);
        this.add(help);
        //creat JMenu Items
        newDownload = new JMenuItem("New Download");
        newDownload.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        newDownload.addActionListener(new toolbarHandler());


        pause = new JMenuItem("Pause");
        pause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));

        resume = new JMenuItem("Resume");
        resume.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));

        cancel = new JMenuItem("Cancel");
        cancel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));

        remove = new JMenuItem("Remove");
        remove.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
        remove.addActionListener(new toolbarHandler());

        setting = new JMenuItem("Setting");
        setting.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        setting.addActionListener(new toolbarHandler());

        exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
        exit.addActionListener(new toolbarHandler());


        //add Items to downloads JMenu
        downloads.add(newDownload);
        downloads.add(pause);
        downloads.add(resume);
        downloads.add(cancel);
        downloads.add(remove);
        downloads.add(setting);
        downloads.add(exit);

        about = new JMenuItem("About");
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
        about.addActionListener(new toolbarHandler());

        help.add(about);

    }

    public class toolbarHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Exit"))
                System.exit(0);
            if (e.getActionCommand().equals("New Download")) {
                NewDownload newDownload = new NewDownload();
                //  ArrayListDownloadBoxes arrayListDownloadBoxes = new ArrayListDownloadBoxes(downloadsPanel);
            }
            if (e.getActionCommand().equals("About")) {
                String about = "programmer : Hosein Beheshti \n " +
                        "Student Number : 9631011";
                System.out.println("salam");
                JOptionPane.showConfirmDialog(null, about,
                        "About", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
            if (e.getActionCommand().equals("Setting")) {
                Setting setting = new Setting();
            }
            if(e.getActionCommand().equals("Remove"))
            {
                Main.arrayListDownloadBoxes.remove();
            }
        }
    }

}
