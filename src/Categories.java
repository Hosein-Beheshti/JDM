import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;

public class Categories extends JPanel {

    private MainDownloadPanel mainDownloadPanel;
    private BorderLayout layout;
    private JPanel myPanel;
    private JPanel move;
    private JButton processing;
    private JButton completed;
    private JButton queues;
    private JButton def;
    private JButton up;
    private JButton down;
    static String categoriesSelect = "Processing";


    public Categories(MainDownloadPanel mainDownloadPanel){
        this.mainDownloadPanel = mainDownloadPanel;
        layout = new BorderLayout();
        this.setLayout(layout);

        myPanel = new JPanel();
        myPanel.setBackground(new Color(78,0,0));

            GridLayout myPanelLayout = new GridLayout(0,1,0,10);
            myPanel.setLayout(myPanelLayout);
            processing = new JButton("Processing ");
            completed = new JButton("Completed");
            queues = new JButton("Queues");
           // def = new JButton("Default");

        ImageIcon buttonBackground = new ImageIcon("ButtonBackground.jpg");
        processing.setBackground(null);
        processing.setIcon(buttonBackground);
        processing.setHorizontalTextPosition(JButton.CENTER);
        processing.setVerticalTextPosition(JButton.CENTER);
        processing.setForeground(Color.white);

        completed.setBackground(null);
        completed.setIcon(buttonBackground);
        completed.setHorizontalTextPosition(JButton.CENTER);
        completed.setVerticalTextPosition(JButton.CENTER);
        completed.setForeground(Color.white);

        queues.setBackground(null);
        queues.setIcon(buttonBackground);
        queues.setHorizontalTextPosition(JButton.CENTER);
        queues.setVerticalTextPosition(JButton.CENTER);
        queues.setForeground(Color.white);

        myPanel.add(processing);
        myPanel.add(completed);
        myPanel.add(queues);

            queues.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    categoriesSelect = e.getActionCommand();
                    Main.arrayListDownloadBoxes.addBoxesToQueue();

                }
            });

            processing.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    categoriesSelect = e.getActionCommand();
                    Main.arrayListDownloadBoxes.addBoxes();
                }
            });


        this.add(myPanel,BorderLayout.NORTH);
        //Move panel

        move = new JPanel();
        up = new JButton("UP");
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.arrayListDownloadBoxes.swap("UP");
            }
        });
        down = new JButton("DOWN");
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.arrayListDownloadBoxes.swap("DOWN");
            }
        });
        GridLayout moveLayout = new GridLayout(2,1);
        move.setLayout(moveLayout);
        move.add(up);
        move.add(down);

      //  this.add(move,BorderLayout.SOUTH);
    }
}
