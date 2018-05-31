import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;


public class SaveInformation {
    public SaveInformation() {

    }

    public void writeDownloadPanels(ArrayList<Information> mainArray, ArrayList<Information> queueArray) {
        ObjectOutputStream out = null;
        ObjectOutputStream out1 = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("list.jdm");
            FileOutputStream fileOutputStream1 = new FileOutputStream("queue.jdm");
            out = new ObjectOutputStream(fileOutputStream);
            out1 = new ObjectOutputStream(fileOutputStream1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (Information information : mainArray) {
                out.writeObject(information);
            }
            out.close();
            for (Information information : queueArray) {
                out1.writeObject(information);
            }
            out1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDownloadPanels() {
        ObjectInputStream in = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("list.jdm");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            in = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (fileInputStream.available() > 0) {
                Information information = new Information();
                information = (Information) in.readObject();

                //                Information information1 = new Information();
                //                information1 = (Information) in1.readObject();

                DownloadsPanel downloadsPanel = new DownloadsPanel(information.getName(),information.getAdress(),information.getDate());

                Information finalInformation = information;

                downloadsPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // downloadsPanel.
                        if (e.isMetaDown()) {
                            String about = "URL : " + finalInformation.getAdress() + "\n" +
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
                //add download boxes to main panel
                Main.arrayListDownloadBoxes.getDownloadBoxes().add(downloadsPanel);
                Main.arrayListDownloadBoxes.addBoxes();
                Main.arrayListDownloadBoxes.getDownloadInformation().add(information);

                ObjectInputStream in1 = null;
                FileInputStream fileInputStream1 = new FileInputStream("queue.jdm");
                in1 = new ObjectInputStream(fileInputStream1);
                Information information1 = new Information();
                while (fileInputStream1.available() > 0) {
                    information1 = (Information) in1.readObject();
                    if(information.getName().equals(information1.getName()))
                    {
                        Main.arrayListDownloadBoxes.getDownloadBoxesQueue().add(downloadsPanel);
                        Main.arrayListDownloadBoxes.getDownloadInformationQueue().add(information);
                    }

                }

            }
        }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Phone class not found");
                c.printStackTrace();
                return;
            }
            }

            public void writeSetting(Setting setting)
            {
                File file = new File("setting.jdm");
                FileWriter writer = null;
                try {
                    writer = new FileWriter(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (BufferedWriter bw = new BufferedWriter(writer)) {
                //    System.out.println(setting.getLimit());
                    writer.write(String.valueOf(setting.getLimit()));
                    bw.newLine();
                    bw.write(setting.getSaveFileAdress());
                    bw.newLine();
                    bw.write(setting.getLookAndFeelName());
                    bw.newLine();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            public void readSetting()
            {
                try {
           File file = new File("setting.jdm");
           FileReader reader = new FileReader(file);
           BufferedReader bufferedReader = new BufferedReader(reader);
           String data;
            Setting.setLimit(Integer.parseInt(bufferedReader.readLine()));
            Setting.setSaveFileAdress(bufferedReader.readLine());
            String lookAndFeelName = bufferedReader.readLine();
            Setting.setLookAndFeelName(lookAndFeelName);
            Main.lookAndFeel(lookAndFeelName);
       }catch (IOException e)
       {
           e.printStackTrace();
       }
            }


  /*  public void readQueueDownloadPanels() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("queue.jdm"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            while (true) {
                Information information = new Information();
                information = (Information) in.readObject();

                DownloadsPanel downloadsPanel = new DownloadsPanel(information.getName());

                Information finalInformation = information;

                downloadsPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked (MouseEvent e){
                        // downloadsPanel.

                        if (e.isMetaDown()) {
                            String about = "URL : " + finalInformation.getAdress() + "\n" +
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

                //add queue download boxes to main panels
                Main.arrayListDownloadBoxes.getDownloadBoxesQueue().add(downloadsPanel);
             //   Main.arrayListDownloadBoxes.addBoxesToQueue();
                Main.arrayListDownloadBoxes.getDownloadInformationQueue().add(information);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Phone class not found");
            c.printStackTrace();
            return;
        }
    }*/

}