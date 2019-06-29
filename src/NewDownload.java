import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewDownload {
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
    static DownloadTask task;

    public NewDownload() {
        myPanel = new JPanel();
        layout = new GridLayout(3, 3, 2, 12);
        myPanel.setLayout(layout);

        name = new JTextField();
        address = new JTextField();
      //  address.setText("http://file.all-free-download.com/downloadfiles/graphic/graphic_1/red_business_icons_vector_286626.zip");


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
                "Please Enter Name and Adress", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {

            try {
                File file = new File("filter.jdm");
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String data;
                checkFilter = false;
                while ((data = bufferedReader.readLine()) != null) {
                    if (data.length() != 0)
                        if (address.getText().matches(data + ".*")) {
                            //  System.out.println(data);
                            //  System.out.println(address.getText());
                            //   System.out.println("is filter");
                            JOptionPane.showConfirmDialog(null, "this download is impossible because this URL is filter",
                                    "Is Filter", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
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
                information.setDate(date);
                // System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
                //information.setTime(dateFormat.format(date));
                // Download download = new Download(address.getText());
/**
 * Download and update GUI
 */
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        DownloadsPanel downloadsPanel = new DownloadsPanel(information.getName(), information.getAdress(), information.getDate());


                        if (Categories.categoriesSelect == Categories.getProcessingText() && !queueDownloadButton.isSelected()) {
                            // System.out.println("Processing");
                            task = new DownloadTask(downloadsPanel, address.getText(), Setting.getSaveFileAdress());
                            // downloadsPanel.setProgressing(true);
                            //take the action here;
                            // downloadsPanel.addPropertyChangeListener(downloadsPanel);
//                        System.out.println(Setting.getLimit());
//                        Setting.setI();
//                        System.out.println(Setting.getI());
//                        if(Setting.getI() <= Setting.getLimit())
//                        {
//                            System.out.println("Execute");
//                        }
                            task.execute();
                            // System.out.println(Main.arrayListDownloadBoxes.progressing());
                            if (Main.arrayListDownloadBoxes.progressing() >= Setting.getLimit()) {
                                downloadsPanel.setPaused(true);
                                downloadsPanel.setWaiting(true);
                            }
                            limitDownload();
                        }
                        if (Categories.categoriesSelect == Categories.getQueuesText() || queueDownloadButton.isSelected()) {
                            System.out.println("Queue");
                            task = new DownloadTask(downloadsPanel, address.getText(), Setting.getSaveFileAdress());
                            // downloadsPanel.setProgressing(true);
                            //take the action here;
                            // downloadsPanel.addPropertyChangeListener(downloadsPanel);
//                        System.out.println(Setting.getLimit());
//                        Setting.setI();
//                        System.out.println(Setting.getI());
//                        if(Setting.getI() <= Setting.getLimit())
//                        {
//                            System.out.println("Execute");
//                        }
                            task.execute();
                            // System.out.println(Main.arrayListDownloadBoxes.progressing());
                            if (Main.arrayListDownloadBoxes.progressing() >= 1) {
                                downloadsPanel.setPaused(true);
                                downloadsPanel.setWaiting(true);
                            }
                            //   limitDownload();
                        }

                        //System.out.println(e.getSource());
                        downloadsPanel.addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                // downloadsPanel.

                                if (e.isMetaDown()) {
                                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                    String about = "URL : " + fileAdress + "\n" +
                                            "Save File Adress : " + Setting.getSaveFileAdress() + "\n" +
                                            "Size : " + downloadsPanel.getSize1() / 1000 + "\n" +
                                            "Start Time : " + dateFormat.format(downloadsPanel.getTime());
                                    //  System.out.println("salam");
                                    JOptionPane.showConfirmDialog(null, about,
                                            "File Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                                } else {
                                    if (e.getClickCount() == 2 && downloadsPanel.isCompelete()) {                // write here your event handling code

                                      //  System.out.println("You clicked two times on the button");
                                        try {
                                            // Process p = new ProcessBuilder("explorer.exe", "/select,F:\\java-project\\JDM backup\\DOWNLOADS").start();
                                            File file = new File(downloadsPanel.getOpenFile());
                                            Desktop desktop = Desktop.getDesktop();
                                            desktop.open(file);
                                        } catch (IOException e1) {
                                            e1.printStackTrace();
                                        }
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
                                }

                            }
                        });

                        Main.arrayListDownloadBoxes.getDownloadBoxes().add(downloadsPanel);
                        Main.arrayListDownloadBoxes.addBoxes();
                        // SaveInformation.writeDownloadPanels(downloadsPanel);

                        if (queueDownloadButton.isSelected()) {
                            // Main.arrayListDownloadBoxes.getDownloadBoxesQueue().add(downloadsPanel);
                            downloadsPanel.setSelect(true);
                            downloadsPanel.setQueue(true);
                            Main.arrayListDownloadBoxes.addBoxesToArrayQueue();
                            Main.arrayListDownloadBoxes.addBoxesToQueue();
                        }
                    }
                });


              /*  try {

                    task.addPropertyChangeListener(downloadsPanel);
                    task.execute();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(downloadsPanel,
                            "Error executing upload task: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }*/
                //   downloadsPanel.setDownload(download);
                //add ActionListener for all Downloadspanel when click on thats

//                       Main.mainPanel.addBoxes();

                Main.arrayListDownloadBoxes.getDownloadInformation().add(information);

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

    /**
     * start downloads that are waiting for limit download
     */
    public static void limitDownload() {
        //   System.out.println("LIMIIIIIIIIIIT");
        for (DownloadsPanel dP : Main.arrayListDownloadBoxes.getDownloadBoxes()) {
            //   System.out.println(dP.isSelect());
            if (!dP.isCompelete() && dP.isWaiting()) {
                //  System.out.println("PAUSEEEEEEEEEEEEEEE");
                // System.out.println("progressing = " + Main.arrayListDownloadBoxes.progressing());
                if (dP.isQueue()) {
                    if (Main.arrayListDownloadBoxes.progressing() < 1) {
                        //    System.out.println("RESUMEEEEEEEEEEEEEEEEEEEE");

                        dP.setPaused(false);
                        dP.setWaiting(false);
                        dP.setProgressing(true);
                    }
                } else if (Main.arrayListDownloadBoxes.progressing() < Setting.getLimit()) {
                    //    System.out.println("RESUMEEEEEEEEEEEEEEEEEEEE");

                    dP.setPaused(false);
                    dP.setWaiting(false);
                    dP.setProgressing(true);
                }
            }
        }
    }


}
