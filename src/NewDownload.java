import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/*public class NewDownload extends JFrame {

    NewDownloadPanels nWPanels;
    GridLayout layout;
    JButton ok;
    public NewDownload()
    {
        layout = new GridLayout(3,3);
        this.setLayout(layout);

        nWPanels = new NewDownloadPanels();
        this.add(nWPanels);
        ok = new JButton("OK");
        this.add(ok);
    }
    public class NewDownloadPanels extends JPanel
    {
        GridLayout layout;
        JTextField name;
        JTextField url;
        public NewDownloadPanels()
        {
            layout = new GridLayout(2,1);
            this.setLayout(layout);
            name = new JTextField("Enter here");
            name.setPreferredSize(new Dimension(1000,20));
            this.add(name);
        }
    }
}*/

public class NewDownload{
    MainPanel mainPanel;
    JTextField name = new JTextField();
    JTextField address = new JTextField();
   private String fileName;
   private String fileAdress;
    JPanel myPanel;
    GridLayout layout;
        public NewDownload(){
         myPanel = new JPanel();
         layout = new GridLayout(2,2,2,12);
         myPanel.setLayout(layout);

            myPanel.add(new JLabel("Name :"));
            myPanel.add(name);
           // myPanel.add(Box.createHorizontalStrut(150)); // a spacer
            myPanel.add(new JLabel("Adress :"));
            myPanel.add(address);
            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter Name and Adress", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                        fileName = name.getText();
                        fileAdress = address.getText();
                        DownloadsPanel downloadsPanel = new DownloadsPanel(fileName);
                        MainPanel.arrayListDownloadBoxes.add(downloadsPanel);
//                        Main.mainPanel.addBoxes();
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
