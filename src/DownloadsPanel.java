import javax.swing.*;
import java.awt.*;

public class DownloadsPanel extends JPanel {

    FlowLayout layout;
    JProgressBar progress;
    ImageIcon downloadIcon;
    JLabel downloadPersent;
    ImageIcon downloadingIcon;
    JLabel downloading;
    String fileName;

    public DownloadsPanel(String fileName) {
        this.fileName = fileName;
        layout = new FlowLayout();
        this.setLayout(layout);

        downloadIcon = new ImageIcon("downloadIcon.png");
        JLabel downloadLabel = new JLabel(downloadIcon);
        this.add(downloadLabel);

        CenterDownloadsBox dP = new CenterDownloadsBox();
        this.add(dP);

        downloadPersent = new JLabel("27");
        this.add(downloadPersent);

        downloadingIcon = new ImageIcon("downloading.png");
        downloading = new JLabel(downloadingIcon);
        this.add(downloading);
    }

    public class CenterDownloadsBox extends JPanel {

        JLabel lable;
        GridLayout layout;
        SouthCenterDownloadsBox southCenterDownloadsBox;

        public CenterDownloadsBox() {

            layout = new GridLayout(3, 1);
            this.setLayout(layout);

            lable = new JLabel(fileName);
            this.add(lable);


            progress = new JProgressBar(0, 100);
            progress.setPreferredSize(new Dimension(650, 30));
            progress.setValue(20);

            this.add(progress);

            southCenterDownloadsBox = new SouthCenterDownloadsBox();
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
            public SouthCenterDownloadsBox()
            {
                SouthCenterDownloadsBoxPanels = new JPanel();

                resumeIcon = new ImageIcon("resume.png");
                openFolderIcon = new ImageIcon("openfolder.png");
                removeIcon = new ImageIcon("remove.png");

                resumeButton = new JButton(resumeIcon);
                openFolderButton = new JButton(openFolderIcon);
                removeButton = new JButton(removeIcon);

                SouthCenterDownloadsBoxPanels.add(resumeButton);
                SouthCenterDownloadsBoxPanels.add(openFolderButton);
                SouthCenterDownloadsBoxPanels.add(removeButton);

                this.add(SouthCenterDownloadsBoxPanels);
            }
        }
    }
}

