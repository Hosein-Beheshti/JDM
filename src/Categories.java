import javax.swing.*;
import java.awt.*;

public class Categories extends JPanel {

    Categoriesx c = new Categoriesx();
    BorderLayout layout = new BorderLayout();

    public Categories(){
        c.setBackground(Color.gray);
        this.setLayout(layout);
        this.add(c,BorderLayout.NORTH);
    }


        // setLayout(new GridLayout(1,1));


    public class Categoriesx extends JPanel{
        private JButton processing;
        private JButton completed;
        private JButton queues;
        private JButton def;

        public Categoriesx()
        {
            GridLayout layout = new GridLayout(0,1,0,10);
            this.setLayout(layout);
            processing = new JButton("Processing");
            completed = new JButton("Comp;eted");
            queues = new JButton("Queues");
            def = new JButton("Default");

            this.add(processing);
            this.add(completed);
            this.add(queues);
            this.add(def);
    }
}
}
