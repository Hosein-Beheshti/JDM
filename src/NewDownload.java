import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Information information;
    private boolean checkFilter = false;

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

                try {
                    File file = new File("filter.jdm");
                    FileReader reader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String data;
                    checkFilter = false;
                    while ((data = bufferedReader.readLine()) != null) {
                        if(data.length()!=0)
                        if (address.getText().matches(data + ".*")) {
                //  System.out.println(data);
                //  System.out.println(address.getText());
                         //   System.out.println("is filter");
                            JOptionPane.showConfirmDialog(null, "this download is impossible because this URL is filter",
                                    "Is Filter", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                            checkFilter = true;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (checkFilter == false) {
                    information = new Information();
                    fileName = name.getText();
                    information.setName(name.getText());
                    fileAdress = address.getText();
                    information.setAdress(address.getText());
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                   // System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
                    //information.setTime(dateFormat.format(date));
                    information.setDate(date);
                    Main.arrayListDownloadBoxes.getDownloadInformation().add(information);
                    Download download = new Download(address.getText());

                    DownloadsPanel downloadsPanel = new DownloadsPanel(information.getName(),information.getAdress(), information.getDate());
                    downloadsPanel.setDownload(download);
                    //add ActionListener for all Downloadspanel when click on thats

                    downloadsPanel.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            // downloadsPanel.

                            if (e.isMetaDown()) {
                                String about = "URL : " + fileAdress + "\n" +
                                        "Save File Adress : " + Setting.getSaveFileAdress() + "\n" +
                                        "Size : " + "xxx" + "\n" +
                                        "Start Time : " + "xxx";
                                //  System.out.println("salam");
                                JOptionPane.showConfirmDialog(null, about,
                                        "File Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                            } else {
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
                    // SaveInformation.writeDownloadPanels(downloadsPanel);

                    if (queueDownloadButton.isSelected()) {
                        Main.arrayListDownloadBoxes.getDownloadBoxesQueue().add(downloadsPanel);
                        Main.arrayListDownloadBoxes.addBoxesToQueue();
                    }
//                       Main.mainPanel.addBoxes();
                }
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
