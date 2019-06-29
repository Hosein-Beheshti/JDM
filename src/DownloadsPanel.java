import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.net.URL;
import java.util.Date;

public class DownloadsPanel extends JPanel {

    private FlowLayout layout;
    private JProgressBar progress;
    private ImageIcon downloadIcon;
    private JLabel downloadPersent;
    private ImageIcon downloadingIcon;
    private JLabel downloading;
    private String fileName;
    private String fileAddress;
    private Date time;
    private boolean select = false;
    private int speed;
    private int percent;
    private int size;
    private boolean queue = false;
    private boolean paused = false;
    private boolean cancel = false;
    private boolean compelete = false;
    private boolean progressing = false;
    private boolean waiting = false;
    private static CenterDownloadsBox dP;
    public static CenterDownloadsBox.SouthCenterDownloadsBox southCenterDownloadsBox;
    public DownloadTask task;
    private JLabel speedLabel;
    private JLabel sizeLabel;
    private String openFile;
    //   private Download download;


    public DownloadsPanel(String fileName, String fileAddress, Date time) {
        this.fileName = fileName;
        this.fileAddress = fileAddress;
        this.time = time;
        //      this.download = download;

        layout = new FlowLayout();
        this.setLayout(layout);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        // this.setBackground(new Color(100,100,100));

        downloadIcon = new ImageIcon("./Icons/resumeLable.png");
        JLabel downloadLabel = new JLabel(downloadIcon);
        this.add(downloadLabel);

        dP = new CenterDownloadsBox();
        //  dP.setBackground(new Color(100,100,100));

        this.add(dP);

        downloadPersent = new JLabel(String.valueOf(percent));
        this.add(downloadPersent);

        downloadingIcon = new ImageIcon("./Icons/downloading.png");
        downloading = new JLabel(downloadingIcon);
        this.add(downloading);
    }


    public class CenterDownloadsBox extends JPanel {

        private JLabel fileNameLabel;

        private GridLayout layout;

        public CenterDownloadsBox() {

            layout = new GridLayout(3, 1);
            this.setLayout(layout);

            fileNameLabel = new JLabel(fileName);
            this.add(fileNameLabel);


            progress = new JProgressBar(0, 100);
            progress.setPreferredSize(new Dimension(650, 30));
            progress.setValue(percent);
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
                this.setLayout(layout);

                //    SouthCenterDownloadsBoxPanels.setBackground(new Color(100,100,100));


                resumeIcon = new ImageIcon("./Icons/resume.png");
                openFolderIcon = new ImageIcon("./Icons/openfolder.png");
                removeIcon = new ImageIcon("./Icons/remove.png");

                resumeButton = new JButton(resumeIcon);
                openFolderButton = new JButton(openFolderIcon);
                removeButton = new JButton(removeIcon);


                speedLabel = new JLabel();
                // SouthCenterDownloadsBoxPanels.add(speedLabel,BorderLayout.EAST);

                // JPanel sizePanel = new JPanel();
                //  sizePanel.add(sizeLabel);
                sizeLabel = new JLabel();

                this.add(sizeLabel, BorderLayout.EAST);
                this.add(speedLabel, BorderLayout.WEST);

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

    public String getFileName() {
        return fileName;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public Date getTime() {
        return time;
    }

//    public void setDownload(Download download) {
//        this.download = download;
//    }

    public void setSize(int size, int readSize) {
        //   System.out.println("SIZEEEEEEEEEEE");
        this.size = size;
        sizeLabel.setText(readSize / 1000 + "KB" + " / " + String.valueOf(size / 1000) + "KB");
    }

    public void setPercent(int percent) {
        this.percent = percent;
        progress.setValue(percent);
        downloadPersent.setText(String.valueOf(percent));
    }

    public void setTask(DownloadTask task) {
        this.task = task;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        speedLabel.setText(String.valueOf(speed) + "KB/s");
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isCompelete() {
        return compelete;
    }

    public void setCompelete(boolean compelete) {
        this.compelete = compelete;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public int getSize1() {
        return size;
    }

    public boolean isProgressing() {
        return progressing;
    }

    public void setProgressing(boolean progressing) {
        this.progressing = progressing;
    }

    public String getOpenFile() {
        return openFile;
    }

    public void setOpenFile(String openFile) {
        this.openFile = openFile;
    }

   /* public void setPauseIcon()
    {
        downloadIcon.setImage(new ImageIcon("./Icons/pauseLable.png"));
    }
    public void setResumeIcon()
    {
        downloadIcon.setImage(new ImageIcon("./Icons/resumeLable.png"));
    }*/

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public boolean isQueue() {
        return queue;
    }

    public void setQueue(boolean queue) {
        this.queue = queue;
    }
}

