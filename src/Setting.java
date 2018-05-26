import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Setting {

 //   private JTabbedPane tabbedPane;
    private JPanel limitDownloadPanel;
    private JPanel choosFile;
    private JPanel lookAndFeel;
    private JFrame filter;
    private JTextArea filterText;
    private JButton addToFilter;
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
        filter = new JFrame();
        filter.setSize(400, 200);
        filter.setLayout(new GridLayout(2,1));
        filter.setLocation(600, 600);

        filterText = new JTextArea();
       // filterText.setLayout(new GridLayout(2,1));
      //  filterText.setSize(new Dimension(200,50));
        JScrollPane scrollPane = new JScrollPane(filterText);
        filter.add(scrollPane);
        addToFilter = new JButton("add to filter link");
        addToFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                File file = new File("filter.txt");
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(),true))) {
                    bw.write(filterText.getText());
                    bw.newLine();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        filter.add(addToFilter);
        filter.setVisible(true);

        //make an objet of JFrame class for setting frame
//        frame = new JFrame();
//        layout = new FlowLayout();
//        frame.setLayout(layout);
//        frame.setSize(500,150);
//        frame.setVisible(true);
        saveButton = new JButton("save Adress");
        //add action listener for save adress
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
                        Main.lookAndFeel("Default");
            }
        });
        lookAndFeel2 = new JButton("Nimbus");
        lookAndFeel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.lookAndFeel("Nimbus");
                }
        });
        lookAndFeel3 = new JButton("Windows Classic");
        lookAndFeel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.lookAndFeel("Windows Classic");
            }
        });
        lookAndFeel4 = new JButton("");

        lookAndFeel.add(lookAndFeel1);
        lookAndFeel.add(lookAndFeel2);
        lookAndFeel.add(lookAndFeel3);

            tabbedPane = new JTabbedPane();
            tabbedPane.add("Limit Download", limitDownloadPanel);
            tabbedPane.add("save Adress", choosFile);
            tabbedPane.add("Look and Feel", lookAndFeel);
           // tabbedPane.add("filterAdress", filter);

            JOptionPane.showConfirmDialog(null, tabbedPane,
                    "Setting", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        }
        public class ActionHandler{

        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("add to filter link"))
            {
                //System.out.println("salam_");

            }
        }
        }

    public static String getSaveFileAdress() {
        return saveFileAdress;
    }
}

