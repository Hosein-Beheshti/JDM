/**
 * This class is a Download manager
 *
 * @author hosein beheshti
 * @version 0.2
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main {

    static ArrayListDownloadBoxes arrayListDownloadBoxes;

    static void lookAndFeel (String name)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            if(name.equals("Nimbus"))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            if (name.equals("Default"))
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            if(name.equals("Windows Classic"))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");

                for(Window window : JFrame.getWindows())
                {
                    SwingUtilities.updateComponentTreeUI(window);
                }
        } catch(Exception e){

        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("JDM");
        frame.setLocation(450,200);
        frame.setSize(800,700);

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("./Icons/frame.png");
        frame.setIconImage(imageIcon.getImage());

//look and feel
     /*   try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

        } catch(Exception e){

        }

*/


/*

        //System tray
        if(!SystemTray.isSupported()){
            System.out.println("System tray is not supported !!! ");
            return ;
        }
        //get the systemTray of the system
        SystemTray systemTray = SystemTray.getSystemTray();

        //get default toolkit
        //Toolkit toolkit = Toolkit.getDefaultToolkit();
        //get image
        //Toolkit.getDefaultToolkit().getImage("src/resources/busylogo.jpg");
        Image image = Toolkit.getDefaultToolkit().getImage("frame.png");

        //popupmenu
        PopupMenu trayPopupMenu = new PopupMenu();

        //1t menuitem for popupmenu
        MenuItem action = new MenuItem("Action");
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
            }
        });
        trayPopupMenu.add(action);

        //2nd menuitem of popupmenu
        MenuItem close = new MenuItem("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        trayPopupMenu.add(close);

        //setting tray icon
        TrayIcon trayIcon = new TrayIcon(image, "SystemTray Demo", trayPopupMenu);
        //adjust to default size as per system recommendation
        trayIcon.setImageAutoSize(true);

        try{
            systemTray.add(trayIcon);
        }catch(AWTException awtException){
            awtException.printStackTrace();
        }
        //***************end system tray
*/

        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);
        frame.setMinimumSize(new Dimension(1000,500));

        //  frame.add(new JPanel(),BorderLayout.NORTH);



        MenuPanel menuPanel = new MenuPanel();
       // menuPanel.setBackground(Color.black);
        frame.add(menuPanel,BorderLayout.NORTH);

        MainDownloadPanel mainDownloadPanel = new MainDownloadPanel();
        MainPanel mainPanel = new MainPanel(mainDownloadPanel);
        JScrollPane scroll = new JScrollPane(mainPanel);
        frame.add(scroll,BorderLayout.CENTER);

       // mainPanel.setBackground(new Color(50,50,50));
       // mainDownloadPanel.setBackground(new Color(50,50,50));

        Categories categories = new Categories(mainDownloadPanel);
        categories.setBackground(new Color(78,0,0));        //menuPanel.setSize(100,100);
        frame.add(categories,BorderLayout.WEST);
      //  mainPanel.add(b1);
       // mainPanel.setBackground(Color.blue);

        arrayListDownloadBoxes = new ArrayListDownloadBoxes(mainDownloadPanel);
        SaveInformation saveInformation = new SaveInformation();
        //File file = new File("list.jdm");
       saveInformation.readDownloadPanels();

       //print removed data
   /*   try {
           File file = new File("removed.jdm");
           FileReader reader = new FileReader(file);
           BufferedReader bufferedReader = new BufferedReader(reader);
           String data;
           while ((data = bufferedReader.readLine()) != null) {
               System.out.println(data);
           }
       }catch (IOException e)
       {
           e.printStackTrace();
       }
       */
       //saveInformation.readQueueDownloadPanels();

        // frame.setBackground(Color.red);
        frame.setVisible(true);
    }
}