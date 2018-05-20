import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Setting {

 //   private JTabbedPane tabbedPane;
    private JPanel limitDownloadPanel;
    private JPanel choosFile;
    private JPanel lookAndFeel;
    private File file;
    private JFileChooser fileChooser;
    private JFrame frame;
    private static String saveFileAdress;

    private JTabbedPane tabbedPane;
    private FlowLayout layout;
    private JButton saveButton;

    private JButton lookAndFeel1;
    private JButton lookAndFeel2;
    private JButton lookAndFeel3;
    private JButton lookAndFeel4;

    public Setting() {


        limitDownloadPanel = new JPanel();
        choosFile = new JPanel();
        lookAndFeel = new JPanel();

        //make an objet of JFrame class for setting frame
//        frame = new JFrame();
//        layout = new FlowLayout();
//        frame.setLayout(layout);
//        frame.setSize(500,150);
//        frame.setVisible(true);
        saveButton = new JButton("save Adress");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser("C:\\Users\\asus\\Desktop");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (fileChooser.showSaveDialog(choosFile) == JFileChooser.APPROVE_OPTION) {
                    saveFileAdress = String.valueOf(fileChooser.getSelectedFile());
                   // System.out.println(saveFileAdress);
                }
            }
        });
       // frame.add(saveButton);
        choosFile.add(saveButton);

        lookAndFeel1 = new JButton("Default");
        lookAndFeel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        /*UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
*/
            }
        });
        lookAndFeel2 = new JButton("Nimbus");
        lookAndFeel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        /*UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
*/
                }
        });
        lookAndFeel3 = new JButton("");
        lookAndFeel4 = new JButton("");

        lookAndFeel.add(lookAndFeel1);
        lookAndFeel.add(lookAndFeel2);

            tabbedPane = new JTabbedPane();
            tabbedPane.add("Limit Download", limitDownloadPanel);
            tabbedPane.add("save Adress", choosFile);
           tabbedPane.add("Look and Feel", lookAndFeel);

            JOptionPane.showConfirmDialog(null, tabbedPane,
                    "Setting", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        }
        public class ActionHandler{

        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("save Adress"))
                System.out.println("salam_");
        }
        }

    public static String getSaveFileAdress() {
        return saveFileAdress;
    }
}

