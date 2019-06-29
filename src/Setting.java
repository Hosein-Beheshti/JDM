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

public class  Setting {

    //private JTabbedPane tabbedPane;
    private JPanel limitDownloadPanel;
    private JPanel choosFile;
    private JPanel lookAndFeel;
    private JPanel filter;
    private JPanel language;
    private static int i;

    private JFileChooser fileChooser;
    private JFrame frame;
    private JComboBox languageComboBox;


    private static String saveFileAdress = "C:\\Users\\asus\\Desktop";
    private static int limit = 100;
    private static String lookAndFeelName;

    private JTabbedPane tabbedPane;
    private FlowLayout layout;
    private JButton saveButton;
    private JButton filterButton;
    private JButton addToLimit;
    private JButton lookAndFeel1;
    private JButton lookAndFeel2;
    private JButton lookAndFeel3;
    private JButton lookAndFeel4;

    private static String lookAndFeelText;
    private static String limitDownloadText;
    private static String filterAddressText;
    private static String saveAddressText;
    private static String languageText;


    public Setting() {
        limitDownloadPanel = new JPanel();
        choosFile = new JPanel();
        lookAndFeel = new JPanel();
        filter = new JPanel();
        language = new JPanel();

        //save
        saveButton = new JButton("save Adress");
        //add action listener for save adress
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser(saveFileAdress);
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (fileChooser.showSaveDialog(choosFile) == JFileChooser.APPROVE_OPTION) {
                    saveFileAdress = String.valueOf(fileChooser.getSelectedFile());
                    // System.out.println(saveFileAdress);
                }
            }
        });
        //filter
        filterButton = new JButton("open filter");
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilterAdress filterAdress = new FilterAdress();
            }
        });
        filter.add(filterButton);
        // frame.add(saveButton);
        choosFile.add(saveButton);

        //limit download
        SpinnerModel model1 = new SpinnerNumberModel();
        JSpinner spinner1 = new JSpinner(model1);
        model1.setValue(limit);
        addToLimit = new JButton("set Limit");

        limitDownloadPanel.add(addToLimit);
        addToLimit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               limit = (int) spinner1.getValue();

            }
        });
        limitDownloadPanel.add(spinner1);
        //language
        languageComboBox = new JComboBox();
        languageComboBox.addItem("English");
        languageComboBox.addItem("Persian");
        language.add(languageComboBox);
        languageComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(languageComboBox.getSelectedItem().toString().equals("Persian"))
                {
                Main.manager.setLanguage("Persian");
                    Main.frame.validate();

                }
                if(languageComboBox.getSelectedItem().toString().equals("English"))
                {
                    System.out.println();
                    Main.manager.setLanguage("English");
                    //Main.mainDownloadPanel.revalidate();;
                    Main.frame.revalidate();
                }
            }
        });


        lookAndFeel1 = new JButton("Default");
        lookAndFeel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        /*UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
*/
                Main.lookAndFeel("Default");
                lookAndFeelName = "Default";
            }
        });
        lookAndFeel2 = new JButton("Nimbus");
        lookAndFeel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.lookAndFeel("Nimbus");
                lookAndFeelName = "Nimbus";
            }
        });
        lookAndFeel3 = new JButton("Windows Classic");
        lookAndFeel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.lookAndFeel("Windows Classic");
                lookAndFeelName = "Windows Classic";
            }
        });
        lookAndFeel4 = new JButton("");

        lookAndFeel.add(lookAndFeel1);
        lookAndFeel.add(lookAndFeel2);
        lookAndFeel.add(lookAndFeel3);

        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(500,200));
        tabbedPane.add(limitDownloadText, limitDownloadPanel);
        tabbedPane.add(saveAddressText, choosFile);
        tabbedPane.add(lookAndFeelText, lookAndFeel);
        tabbedPane.add(filterAddressText, filter);
        tabbedPane.add(languageText, language);


        // tabbedPane.add("filterAdress", filter);

        JOptionPane.showConfirmDialog(null, tabbedPane,
                "Setting", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    public class ActionHandler {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("add to filter link")) {
                //System.out.println("salam_");

            }
        }
    }

    public static String getSaveFileAdress() {
        return saveFileAdress;
    }

    public static void setSaveFileAdress(String saveFileAdress) {
        Setting.saveFileAdress = saveFileAdress;
    }

    public static int getLimit() {
        return limit;
    }

    public static void setLimit(int limit) {
        Setting.limit = limit;
    }

    public static String getLookAndFeelName() {
        return lookAndFeelName;
    }

    public static void setLookAndFeelName(String lookAndFeelName) {
        Setting.lookAndFeelName = lookAndFeelName;
    }

    public static void setLookAndFeelText(String lookAndFeelText) {
        Setting.lookAndFeelText = lookAndFeelText;
    }

    public static void setLimitDownloadText(String limitDownloadText) {
        Setting.limitDownloadText = limitDownloadText;
    }

    public static void setFilterAddressText(String filterAddressText) {
        Setting.filterAddressText = filterAddressText;
    }

    public static void setSaveAddressText(String saveAddressText) {
        Setting.saveAddressText = saveAddressText;
    }

    public static void setLanguageText(String languageText) {
        Setting.languageText = languageText;
    }

    public static int getI() {
        return i;
    }

    public static void setI() {
        Setting.i++;
    }
}

