import javax.swing.*;
import java.awt.*;

public class Main {

    static MainPanel mainPanel;
    public static void main(String[] args) {
        JFrame frame = new JFrame("JDM");
        frame.setLocation(800,400);
        frame.setSize(800,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);
        frame.setMinimumSize(new Dimension(1000,500));

        //  frame.add(new JPanel(),BorderLayout.NORTH);

        Categories categories = new Categories();
        categories.setBackground(Color.gray);
        //menuPanel.setSize(100,100);
        frame.add(categories,BorderLayout.WEST);

        MenuPanel menuPanel = new MenuPanel();
       // menuPanel.setBackground(Color.black);
        frame.add(menuPanel,BorderLayout.NORTH);

         mainPanel = new MainPanel();
       // mainPanel.setBackground(Color.blue);
        frame.add(mainPanel);

       // frame.setBackground(Color.red);
        frame.setVisible(true);




    }

}
