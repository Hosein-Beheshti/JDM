import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    MenuBar menuPanel = new MenuBar();
    ToolBar toolBar = new ToolBar();

    public MenuPanel()
    {
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        this.add(menuPanel,BorderLayout.NORTH);
        this.add(toolBar);
//        JButton button = new JButton("hosein");
//        this.add(button);
    }


}
