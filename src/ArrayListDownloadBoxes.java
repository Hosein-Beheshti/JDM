import com.sun.deploy.panel.ITreeNode;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListDownloadBoxes {
    private ArrayList<DownloadsPanel> downloadBoxes;
    private ArrayList<DownloadsPanel> downloadBoxesQueue;
    private ArrayList<DownloadsPanel> downloadBoxesCompleted;
    private ArrayList<Information> downloadInformation;
    private ArrayList<Information> downloadInformationQueue;


    private MainDownloadPanel mainDownloadPanel;
    private Categories categories;

    public ArrayListDownloadBoxes(MainDownloadPanel mainDownloadPanel, Categories categories) {
        downloadBoxes = new ArrayList<>();
        downloadBoxesQueue = new ArrayList<>();
        downloadBoxesCompleted = new ArrayList<>();
        downloadInformation = new ArrayList<>();
        downloadInformationQueue = new ArrayList<>();

        this.mainDownloadPanel = mainDownloadPanel;
        this.categories = categories;
    }

    public void addBoxes() {
        //  System.out.println(downloadBoxes.size());
        mainDownloadPanel.removeAll();
        for (DownloadsPanel dP : downloadBoxes) {

            if (downloadBoxes.size() > 4) {
                mainDownloadPanel.increasRowa(downloadBoxes.size());
            }
            mainDownloadPanel.add(dP);
            //  System.out.println(dP.isSelect());
        }
        mainDownloadPanel.revalidate();
        mainDownloadPanel.repaint();
    }

    public void addBoxesToArrayQueue() {

        Iterator<Information> informationIterator = downloadInformation.iterator();
        for (DownloadsPanel dP : downloadBoxes) {
            Information information = informationIterator.next();
            //   System.out.println(dP.isSelect());
            if (dP.isSelect()) {
                downloadInformationQueue.add(information);
                downloadBoxesQueue.add(dP);
                dP.setQueue(true);
                dP.setSelect(false);
                dP.setBackground(null);
            }

            mainDownloadPanel.revalidate();
            mainDownloadPanel.repaint();

        }
    }

    public void addBoxesToQueue() {
        mainDownloadPanel.removeAll();
        for (DownloadsPanel dP : downloadBoxesQueue) {
            if (downloadBoxesQueue.size() > 4) {
                mainDownloadPanel.increasRowa(downloadBoxes.size());
            }
            mainDownloadPanel.add(dP);
        }
        mainDownloadPanel.revalidate();
        mainDownloadPanel.repaint();
    }

    public void remove() {
        if (Categories.categoriesSelect.equals(categories.getProcessingText())) {
            Iterator<DownloadsPanel> itr = downloadBoxes.iterator();
            Iterator<Information> informationIterator = downloadInformation.iterator();

            while (itr.hasNext()) {
                DownloadsPanel dp = itr.next();
                Information information = informationIterator.next();
                //System.out.println(dp.getName());/
                if (dp.isSelect() == true) {
                    mainDownloadPanel.remove(dp);
                    //write name and adress file that removed
                    File file = new File("removed.jdm");
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true))) {
                        bw.write(information.getName());
                        bw.newLine();
                        bw.write(information.getAdress());
                        bw.newLine();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    itr.remove();
                    informationIterator.remove();
                }
            }
            Iterator<DownloadsPanel> itr1 = downloadBoxesQueue.iterator();
            Iterator<Information> informationIterator1 = downloadInformationQueue.iterator();


            while (itr1.hasNext()) {
                DownloadsPanel dp = itr1.next();
                Information information1 = informationIterator1.next();
                //System.out.println(dp.getName());
                if (dp.isSelect() == true) {
                    mainDownloadPanel.remove(dp);
                    informationIterator1.remove();
                    itr1.remove();
                }
            }
            Iterator<DownloadsPanel> itr2 = downloadBoxesCompleted.iterator();

            while (itr2.hasNext()) {
                DownloadsPanel dp = itr1.next();
                if (dp.isSelect() == true) {
                    mainDownloadPanel.remove(dp);
                    itr1.remove();
                }
            }
            mainDownloadPanel.revalidate();
            mainDownloadPanel.repaint();
        }
        if (Categories.categoriesSelect.equals(categories.getQueuesText())) {
            Iterator<DownloadsPanel> itr1 = downloadBoxesQueue.iterator();
            Iterator<Information> informationIterator1 = downloadInformationQueue.iterator();

            while (itr1.hasNext()) {
                DownloadsPanel dp = itr1.next();
                Information information1 = informationIterator1.next();

                if (dp.isSelect() == true) {
                    dp.setQueue(false);
                    mainDownloadPanel.remove(dp);
                    informationIterator1.remove();
                    dp.setSelect(false);
                    dp.setBackground(null);
                    itr1.remove();
                }
            }
            mainDownloadPanel.revalidate();
            mainDownloadPanel.repaint();
        }
        if (Categories.categoriesSelect.equals(categories.getCompletedText())) {
            Iterator<DownloadsPanel> itr2 = downloadBoxesCompleted.iterator();

            while (itr2.hasNext()) {
                DownloadsPanel dp = itr2.next();
                //System.out.println(dp.getName());
                if (dp.isSelect() == true) {
                    mainDownloadPanel.remove(dp);
                    dp.setSelect(false);
                    dp.setBackground(null);
                    itr2.remove();
                }
            }
            // System.out.println(downloadBoxes.size());
            mainDownloadPanel.revalidate();
            mainDownloadPanel.repaint();
        }
    }

    public void swap(String task) {
//            Iterator<DownloadsPanel> itr1 = downloadBoxesQueue.iterator();
//            int i = 0;
//            while (itr1.hasNext()) {
//                DownloadsPanel dp = itr1.next();
//                if (dp.isSelect() == true) {
//                    System.out.println("boom");
//                    if(i>0)
//                    Collections.swap(downloadBoxesQueue,i,(i-1));
//                }
//                i++;
//            }
//        }
        int i = 0;
        for (DownloadsPanel dp : downloadBoxesQueue) {
            if (dp.isSelect() == true) {
                if (i > 0) {
                    if (task.equals("UP"))
                        Collections.swap(downloadBoxesQueue, i, (i - 1));
                }
                if (task.equals("DOWN")) {
                    i++;
                    Collections.swap(downloadBoxesQueue, i, (i - 1));
                    i--;
                }
            }
            i++;
        }
        addBoxesToQueue();
    }

    public void pause() {
        for (DownloadsPanel dP : downloadBoxes) {
            //   System.out.println(dP.isSelect());
            if (dP.isSelect()) {
                dP.setPaused(true);
            }
        }
    }

    public void resume() {
        for (DownloadsPanel dP : downloadBoxes) {
            //   System.out.println(dP.isSelect());
            if (dP.isSelect()) {
                dP.setPaused(false);
             /*   if (dP.isCancel()) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("xXxXx");
                            DownloadTask task = new DownloadTask(dP, dP.getFileAddress(), Setting.getSaveFileAdress());
                            task.execute();
                        }
                    });
                }*/
            }
        }
    }

    public void cancel() {
        for (DownloadsPanel dP : downloadBoxes) {
            //   System.out.println(dP.isSelect());
            if (dP.isSelect()) {
                dP.setCancel(true);
            }
        }
    }

    public int progressing() {
        int progressing = 0;
        for (DownloadsPanel dP : downloadBoxes) {
            //   System.out.println(dP.isSelect());
            if (dP.isProgressing() == true) {
                progressing++;
            }
        }
        return progressing;
    }

    public ArrayList<DownloadsPanel> getDownloadBoxes() {
        return downloadBoxes;
    }

    public ArrayList<DownloadsPanel> getDownloadBoxesQueue() {
        return downloadBoxesQueue;
    }

    public ArrayList<DownloadsPanel> getDownloadBoxesCompleted() {
        return downloadBoxesCompleted;
    }

    public ArrayList<Information> getDownloadInformation() {
        return downloadInformation;
    }

    public ArrayList<Information> getDownloadInformationQueue() {
        return downloadInformationQueue;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
