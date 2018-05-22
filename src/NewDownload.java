import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class NewDownload{
    private MainPanel mainPanel;
    private JTextField name;
    private JTextField address;
    private String fileName;
    private String fileAdress;
    private JPanel myPanel;
    private GridLayout layout;
    private JRadioButton automaticallyDownloadButton;
    private JRadioButton queueDownloadButton;
    private SaveInformation saveInformation;

    public NewDownload(){
         myPanel = new JPanel();
         layout = new GridLayout(3,3,2,12);
         myPanel.setLayout(layout);

            name = new JTextField();
            address = new JTextField();

            myPanel.add(new JLabel("Name :"));
            myPanel.add(name);
           // myPanel.add(Box.createHorizontalStrut(150)); // a spacer
            myPanel.add(new JLabel("Adress :"));
            myPanel.add(address);

            automaticallyDownloadButton = new JRadioButton("Automatically");
            queueDownloadButton = new JRadioButton("Queue");

            automaticallyDownloadButton.setSelected(true);

            ButtonGroup group = new ButtonGroup();
            group.add(automaticallyDownloadButton);
            group.add(queueDownloadButton);

            myPanel.add(automaticallyDownloadButton);
            myPanel.add(queueDownloadButton);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter Name and Adress", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                        fileName = name.getText();
                        fileAdress = address.getText();
                        DownloadsPanel downloadsPanel = new DownloadsPanel(fileName);
                        //add ActionListener for all Downloadspanel when click on thats

                downloadsPanel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                       // downloadsPanel.

                        if(e.isMetaDown())
                        {
                            String about = "URL : " + fileAdress + "\n" +
                                            "Save File Adress : " + Setting.getSaveFileAdress() + "\n" +
                                            "Size : " + "xxx" + "\n" +
                                            "Start Time : " + "xxx";
                          //  System.out.println("salam");
                            JOptionPane.showConfirmDialog(null, about,
                                    "File Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                        }

                        else
                            {
                            if (downloadsPanel.isSelect() == false) {
                                downloadsPanel.setSelect(true);
                                downloadsPanel.setBackground(Color.lightGray);
                               // downloadsPanel..setBackground(Color.lightGray);

                            } else {
                                downloadsPanel.setSelect(false);
                                downloadsPanel.setBackground(null);

                            }
                        }
                        //System.out.println(e.getSource());
                    }
                });
                        Main.arrayListDownloadBoxes.getDownloadBoxes().add(downloadsPanel);
                        Main.arrayListDownloadBoxes.addBoxes();
                        saveInformation.writeDownloadPanels(downloadsPanel);

                if(queueDownloadButton.isSelected()) {
                            Main.arrayListDownloadBoxes.getDownloadBoxesQueue().add(downloadsPanel);
                            Main.arrayListDownloadBoxes.addBoxesToQueue();
                        }
                        Main.saveInformation.writeDownloadPanels(downloadsPanel);
//                       Main.mainPanel.addBoxes();
            }
        }
    public String getDownloadName() {
        return fileName;
    }

    public String getDownloadAdress() {
        return fileAdress;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
