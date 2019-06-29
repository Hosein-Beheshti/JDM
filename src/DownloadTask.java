import javafx.concurrent.Worker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 * Execute file download in a background thread and update the progress.
 */
public class DownloadTask extends SwingWorker<Void, Void> {
    private static final int BUFFER_SIZE = 4096;
    private String downloadURL;
    private String saveDirectory;
    private DownloadsPanel downloadsPanel;
    private static boolean pause;
    private String saveFilePath;

    public DownloadTask(DownloadsPanel downloadsPanel, String downloadURL, String saveDirectory) {
        // System.out.println("DOWNLOAD TAAAAAAAASk");
        this.downloadsPanel = downloadsPanel;
        this.downloadURL = downloadURL;
        this.saveDirectory = saveDirectory;
    }

    /**
     * Executed in background thread
     */
    @Override
    protected Void doInBackground() throws Exception {
        try {
            //    System.out.println("DOIBACHGROUND");
            HTTPDownloadUtil util = new HTTPDownloadUtil();
            util.downloadFile(downloadURL);
            //       System.out.println("SIZE " + util.getContentLength());

            // set file information on the GUI


            saveFilePath = saveDirectory + File.separator + util.getFileName();
            downloadsPanel.setOpenFile(saveFilePath);

            InputStream inputStream = util.getInputStream();

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            long totalBytesRead = 0;
            int percentCompleted = 0;
            long fileSize = util.getContentLength();
            long start = 0;
            long end;
            int speed;

            while (true) {
                if (downloadsPanel.isPaused() == true) {
                    //  System.out.println("is Pause");
                    //inputStream.skip(totalBytesRead);
//                    if(pause == false)
//                        this.run();
                    Thread.sleep(1);
                    downloadsPanel.setProgressing(false);
                    //downloadsPanel.setProgressing(false);
                } else {
                    downloadsPanel.setProgressing(true);
                    if ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                        totalBytesRead += bytesRead;
                        downloadsPanel.setSize(util.getContentLength(), (int) totalBytesRead);
                        percentCompleted = (int) (totalBytesRead * 100 / fileSize);
                        //  Long end = System.currentTimeMillis()*1000;
                        //  int speed= (int) (bytesRead / (startTime-end));
                        //  System.out.println(speed);
                        setProgress(percentCompleted);
                        downloadsPanel.setPercent(percentCompleted);

                        try {
                            //   long timeInSecs = (end - start);
                            speed = (int) (bytesRead / (System.currentTimeMillis() - start));
                            downloadsPanel.setSpeed(speed);

                            // System.out.println(speedInKBps);
                        } catch (ArithmeticException ae) {

                        }
                        start = System.currentTimeMillis();
                    } else {
                        downloadsPanel.setCompelete(true);
                        downloadsPanel.setProgressing(false);
                        NewDownload.limitDownload();
                        break;
                    }
                }
                if (downloadsPanel.isCancel() == true) {
                    //  System.out.println("is Pause");
                    //inputStream.skip(totalBytesRead);
//                    if(pause == false)
//                        this.run();
                    //  System.out.println("cancel");
                    cancel(true);
                    setProgress(0);
                    downloadsPanel.setPercent(0);
                    Main.mainDownloadPanel.validate();
                    return null;
                }
                //  System.out.println("hahahaah");

                //      System.out.println("PROGRESSSSSSS");
            }
            // System.out.println("finish ;(");

            outputStream.close();

            util.disconnect();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(downloadsPanel, "Error downloading file: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            setProgress(0);
            cancel(true);
        }
        return null;
    }

    /**
     * Executed in Swing's event dispatching thread
     */
    @Override
    protected void done() {
        if (!isCancelled()) {
            JOptionPane.showMessageDialog(downloadsPanel,
                    "File has been downloaded successfully!", "Message",
                    JOptionPane.INFORMATION_MESSAGE);

            //   Main.arrayListDownloadBoxes.remove();
        }
    }

    public static void setPause(boolean pause) {
        DownloadTask.pause = pause;
    }

    public static boolean isPause() {
        return pause;
    }

}