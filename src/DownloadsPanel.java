import javax.swing.*;
import java.awt.*;

public class DownloadsPanel extends JPanel {

    private FlowLayout layout;
    private JProgressBar progress;
    private ImageIcon downloadIcon;
    private JLabel downloadPersent;
    private ImageIcon downloadingIcon;
    private JLabel downloading;
    private String fileName;
    private boolean select = false;
    private int speed;
    private int persent = 50;
    private static CenterDownloadsBox dP;
    public static CenterDownloadsBox.SouthCenterDownloadsBox southCenterDownloadsBox;


    public DownloadsPanel(String fileName) {
        this.fileName = fileName;
        layout = new FlowLayout();
        this.setLayout(layout);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        // this.setBackground(new Color(100,100,100));

        downloadIcon = new ImageIcon("downloadIcon.png");
        JLabel downloadLabel = new JLabel(downloadIcon);
        this.add(downloadLabel);

        dP = new CenterDownloadsBox();
        //  dP.setBackground(new Color(100,100,100));

        this.add(dP);

        downloadPersent = new JLabel(String.valueOf(persent));
        this.add(downloadPersent);

        downloadingIcon = new ImageIcon("downloading.png");
        downloading = new JLabel(downloadingIcon);
        this.add(downloading);
    }

    public class CenterDownloadsBox extends JPanel {

        private JLabel fileNameLabel;
        private JLabel speedLabel;
        private JLabel sizeLabel;
        private GridLayout layout;

        public CenterDownloadsBox() {

            layout = new GridLayout(3, 1);
            this.setLayout(layout);

            fileNameLabel = new JLabel(fileName);
            this.add(fileNameLabel);


            progress = new JProgressBar(0, 100);
            progress.setPreferredSize(new Dimension(650, 30));
            progress.setValue(persent);
            // progress.getUI();

            this.add(progress);

            southCenterDownloadsBox = new SouthCenterDownloadsBox();
            //  southCenterDownloadsBox.setBackground(new Color(100,100,100));
            this.add(southCenterDownloadsBox);


        }

        public class SouthCenterDownloadsBox extends JPanel

        {
            JPanel SouthCenterDownloadsBoxPanels;

            ImageIcon resumeIcon;
            ImageIcon openFolderIcon;
            ImageIcon removeIcon;

            JButton resumeButton;
            JButton openFolderButton;
            JButton removeButton;

            public SouthCenterDownloadsBox() {


                SouthCenterDownloadsBoxPanels = new JPanel();

                BorderLayout layout = new BorderLayout();
                SouthCenterDownloadsBoxPanels.setLayout(layout);

                //   SouthCenterDownloadsBoxPanels.setBackground(new Color(100,100,100));


                resumeIcon = new ImageIcon("resume.png");
                openFolderIcon = new ImageIcon("openfolder.png");
                removeIcon = new ImageIcon("remove.png");

                resumeButton = new JButton(resumeIcon);
                openFolderButton = new JButton(openFolderIcon);
                removeButton = new JButton(removeIcon);


                speedLabel = new JLabel("speed");
                // SouthCenterDownloadsBoxPanels.add(speedLabel,BorderLayout.EAST);

                // JPanel sizePanel = new JPanel();
                //  sizePanel.add(sizeLabel);
                sizeLabel = new JLabel("size");

                SouthCenterDownloadsBoxPanels.add(sizeLabel, BorderLayout.WEST);
                SouthCenterDownloadsBoxPanels.add(speedLabel, BorderLayout.EAST);

                //  SouthCenterDownloadsBoxPanels.add(resumeButton);
                //  SouthCenterDownloadsBoxPanels.add(openFolderButton);
                // SouthCenterDownloadsBoxPanels.add(removeButton);

                this.add(SouthCenterDownloadsBoxPanels);
            }
        }
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isSelect() {
        return select;
    }
}

