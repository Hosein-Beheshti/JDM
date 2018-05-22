import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListDownloadBoxes {
    private ArrayList<DownloadsPanel> downloadBoxes;
    private ArrayList<DownloadsPanel> downloadBoxesQueue;
    private ArrayList<DownloadsPanel> downloadBoxesCompleted;


    private MainDownloadPanel mainDownloadPanel;

    public ArrayListDownloadBoxes(MainDownloadPanel mainDownloadPanel) {
        downloadBoxes = new ArrayList<>();
        downloadBoxesQueue = new ArrayList<>();
        downloadBoxesCompleted = new ArrayList<>();

        this.mainDownloadPanel = mainDownloadPanel;
    }

    public void addBoxes() {
        //  System.out.println(downloadBoxes.size());

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

        for (DownloadsPanel dP : downloadBoxes) {
            //   System.out.println(dP.isSelect());
            if (dP.isSelect()) {
                downloadBoxesQueue.add(dP);
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
        if (Categories.categoriesSelect.equals("Processing")) {
            Iterator<DownloadsPanel> itr = downloadBoxes.iterator();

            while (itr.hasNext()) {
                DownloadsPanel dp = itr.next();
                //System.out.println(dp.getName());
                if (dp.isSelect() == true) {
                    mainDownloadPanel.remove(dp);
                    itr.remove();
                }
            }

            Iterator<DownloadsPanel> itr1 = downloadBoxesQueue.iterator();

            while (itr1.hasNext()) {
                DownloadsPanel dp = itr1.next();
                //System.out.println(dp.getName());
                if (dp.isSelect() == true) {
                    mainDownloadPanel.remove(dp);
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
        if (Categories.categoriesSelect.equals("Queues")) {
            Iterator<DownloadsPanel> itr1 = downloadBoxesQueue.iterator();

            while (itr1.hasNext()) {
                DownloadsPanel dp = itr1.next();
                if (dp.isSelect() == true) {
                    mainDownloadPanel.remove(dp);
                    dp.setSelect(false);
                    dp.setBackground(null);
                    itr1.remove();
                }
            }
            mainDownloadPanel.revalidate();
            mainDownloadPanel.repaint();
        }
        if (Categories.categoriesSelect.equals("Completed")) {
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
    public void swap(String task)
    {
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
           for(DownloadsPanel dp : downloadBoxesQueue)
           {
               if(dp.isSelect() == true) {
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
    public ArrayList<DownloadsPanel> getDownloadBoxes() {
        return downloadBoxes;
    }

    public ArrayList<DownloadsPanel> getDownloadBoxesQueue() {
        return downloadBoxesQueue;
    }

    public ArrayList<DownloadsPanel> getDownloadBoxesCompleted() {
        return downloadBoxesCompleted;
    }
}
