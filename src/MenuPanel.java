/**
 * this is a panel that add in
 * North of main panel that contain
 * menubar and toolbar panel
 */

import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuPanel extends JPanel {

    private MenuBar menuPanel;
    private ToolBar toolBar;
    private JTextField search;
    private JPanel panel;
    private JPanel panel1;
    private JPanel panel2;
    private JButton searchButton;
    private JButton sortButton;
    private JComboBox sort;

    /**
     * Constructor for menupanel class
     */
    public MenuPanel() {
        menuPanel = new MenuBar();
        toolBar = new ToolBar();
        search = new JTextField();
        search.setPreferredSize(new Dimension(120, 3));

        sort = new JComboBox();
        sort.setEditable(false);
        sort.addItem("By Time");
        sort.addItem("By Name");
        sort.addItem("By Size");

        //action listener for sort
        sort.addActionListener(new MyActionListener());
        // sort.add(name);

        searchButton = new JButton(new ImageIcon("./Icons/search.png"));
        sortButton = new JButton(new ImageIcon("./Icons/sort.png"));
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.manager.changeSortTrend();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.manager.search(search.getText());
            }
        });
        panel = new JPanel(new GridLayout(2, 0, 0, 2));
        //  panel.setLayout(new GridLayout(2,0));
        // panel.add(searchButton);
        panel.add(search);
        panel.add(sort);

        panel1 = new JPanel(new GridLayout(2, 0, 0, 3));
        panel1.add(searchButton);
        panel1.add(sortButton);

        panel2 = new JPanel(new BorderLayout());
        panel2.add(panel1, BorderLayout.WEST);
        panel2.add(panel);

        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        // toolBar.setBackground(Color.black);

        this.add(menuPanel, BorderLayout.NORTH);
        this.add(toolBar);
        this.add(panel2, BorderLayout.EAST);
//        JButton button = new JButton("hosein");
//        this.add(button);
    }

    class MyActionListener implements ActionListener {
        Object oldItem;

        public void actionPerformed(ActionEvent evt) {

            if (sort.getSelectedItem().toString().equals("By Time")) {
                //  System.out.println("Time");
                Main.manager.sort("By Time");
            }
            if (sort.getSelectedItem().toString().equals("By Name")) {
                //   System.out.println("Name");
                Main.manager.sort("By Name");
            }
            if (sort.getSelectedItem().toString().equals("By Size")) {
                //  System.out.println("Size");
                Main.manager.sort("By Size");

            }
        }
    }

    public MenuBar getMenuPanel() {
        return menuPanel;
    }
}
