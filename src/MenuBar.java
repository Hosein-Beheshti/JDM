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
    private JMenuItem export;

    private JMenuItem about;

    public MenuBar() {
        //new "downloads" that is a object of JMenu class
        downloads = new JMenu();
        //set a suitable Mnemonic for downloads JMenu
        downloads.setMnemonic(KeyEvent.VK_D);
        //new "help" that is a object of JMenu class
        help = new JMenu();
        //set a suitable Mnemonic for downloads JMenu
        help.setMnemonic(KeyEvent.VK_H);

        this.add(downloads);
        this.add(help);
        //creat JMenu Items
        newDownload = new JMenuItem();
        newDownload.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        newDownload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewDownload newDownload = new NewDownload();
            }
        });


        pause = new JMenuItem();
        pause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));

        resume = new JMenuItem();
        resume.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));

        cancel = new JMenuItem();
        cancel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));

        remove = new JMenuItem();
        remove.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.arrayListDownloadBoxes.remove();
            }
        });

        setting = new JMenuItem();
        setting.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Setting setting = new Setting();
                SaveInformation saveInformation = new SaveInformation();
                saveInformation.writeSetting(setting);
            }
        });

        exit = new JMenuItem();
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveInformation saveInformation = new SaveInformation();
                saveInformation.writeDownloadPanels(Main.arrayListDownloadBoxes.getDownloadInformation(),Main.arrayListDownloadBoxes.getDownloadInformationQueue());
                System.exit(0);
            }
        });

        export = new JMenuItem();
        export.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.CTRL_MASK));
        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.manager.export();
            }
        });



        //add Items to downloads JMenu
        downloads.add(newDownload);
        downloads.add(pause);
        downloads.add(resume);
        downloads.add(cancel);
        downloads.add(remove);
        downloads.add(setting);
        downloads.add(export);
        downloads.add(exit);

        about = new JMenuItem();
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String about = "programmer : Hosein Beheshti \n " +
                        "Student Number : 9631011";
                //   System.out.println("salam");
                JOptionPane.showConfirmDialog(null, about,
                        "About", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        });

        help.add(about);

    }

  /*  public class toolbarHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Exit")) {
                SaveInformation saveInformation = new SaveInformation();
                saveInformation.writeDownloadPanels(Main.arrayListDownloadBoxes.getDownloadInformation(),Main.arrayListDownloadBoxes.getDownloadInformationQueue());
                System.exit(0);
            }
            if (e.getActionCommand().equals("New Download")) {
                NewDownload newDownload = new NewDownload();
                //  ArrayListDownloadBoxes arrayListDownloadBoxes = new ArrayListDownloadBoxes(downloadsPanel);
            }
            if (e.getActionCommand().equals("About")) {
                String about = "programmer : Hosein Beheshti \n " +
                        "Student Number : 9631011";
             //   System.out.println("salam");
                JOptionPane.showConfirmDialog(null, about,
                        "About", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
            if (e.getActionCommand().equals("Setting")) {
                Setting setting = new Setting();
                SaveInformation saveInformation = new SaveInformation();
                saveInformation.writeSetting(setting);
            }
            if(e.getActionCommand().equals("Remove"))
            {
                Main.arrayListDownloadBoxes.remove();
            }
        }
    }*/

    public void setDownloadsText(String name) {
        downloads.setText(name);
    }
    public void setHelpText(String name) {
        help.setText(name);
    }
    public void setNewDownloadText(String name) {
        newDownload.setText(name);
    }
    public void setPauseText(String name) {
        pause.setText(name);
    }
    public void setResumeText(String name) {
        resume.setText(name);
    }
    public void setCancelText(String name) {
        cancel.setText(name);
    }
    public void setRemoveText(String name) {
        remove.setText(name);
    }
    public void setSettingText(String name) {
        setting.setText(name);
    }
    public void setExitText(String name) {
        exit.setText(name);
    }
    public void setAboutText(String name) {
        about.setText(name);
    }
    public void setExportText (String name)
    {
        export.setText(name);
    }



}
