import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;

public class FilterAdress {

    private JFrame filter;
    private JPanel buttonsPanel;
    private JTextArea filterText;
    private JButton addToFilter;
    private JButton editFilter;
    private JButton okEditButton;
    private File file;

    public FilterAdress() {
        filter = new JFrame();
        BorderLayout layout = new BorderLayout();
        filter.setLayout(layout);
        filter.setSize(400, 200);
        filter.setLocation(600, 600);


        filterText = new JTextArea();
        // filterText.setLayout(new GridLayout(2,1));
        //  filterText.setSize(new Dimension(200,50));
        JScrollPane scrollPane = new JScrollPane(filterText);
        filter.add(scrollPane,BorderLayout.CENTER);
        addToFilter = new JButton("add");
        addToFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                File file = new File("filter.jdm");
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true))) {
                    bw.write(filterText.getText());
                    bw.newLine();
                    filterText.setText("");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        editFilter = new JButton("Edit");
        editFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("filter.jdm");
                FileReader reader = null;
                try {
                    reader = new FileReader(file);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                BufferedReader bufferedReader = new BufferedReader(reader);
                bufferedReader.lines().forEach(data -> filterText.setText(filterText.getText() + data + "\n"));
            }
        });
        okEditButton = new JButton("Ok");
        okEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("filter.jdm");
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    bw.write(filterText.getText());
                    bw.newLine();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
       buttonsPanel = new JPanel();
       buttonsPanel.add(addToFilter);
       buttonsPanel.add(editFilter);
       buttonsPanel.add(okEditButton);
       filter.add(buttonsPanel,BorderLayout.SOUTH);
        filter.setVisible(true);
    }
}