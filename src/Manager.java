import javax.swing.*;
import java.io.*;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * this is a class that contain
 * some methods that we need for this project
 *
 * @author hosein beheshti
 */
public class Manager {


    private MainDownloadPanel mainDownloadPanel;
    private MenuPanel menuPanel;
    private Categories categories;

    /**
     * Constructor for this class
     *
     * @param mainDownloadPanel
     * @param menuPanel
     * @param categories
     */
    public Manager(MainDownloadPanel mainDownloadPanel, MenuPanel menuPanel, Categories categories) {
        this.mainDownloadPanel = mainDownloadPanel;
        this.menuPanel = menuPanel;
        this.categories = categories;

    }

    /**
     * this is a method for serch by name or adress
     * between downloads
     *
     * @param name
     */
    public void search(String name) {
        mainDownloadPanel.removeAll();
        for (DownloadsPanel dP : Main.arrayListDownloadBoxes.getDownloadBoxes()) {
            if (dP.getFileName().matches(".*" + name + ".*") || dP.getFileAddress().matches(".*" + name + ".*")) {
                mainDownloadPanel.add(dP);
            }

        }
        mainDownloadPanel.revalidate();
        mainDownloadPanel.repaint();
    }

    /**
     * this is a method for sort downloads
     * by name or by time or by size
     *
     * @param name
     */
    public void sort(String name) {
        if (name.equals("By Time")) {
            Collections.sort(Main.arrayListDownloadBoxes.getDownloadBoxes(), (o1, o2) -> {
                return o2.getTime().compareTo(o1.getTime());
            });
            Main.arrayListDownloadBoxes.addBoxes();
            mainDownloadPanel.revalidate();
            mainDownloadPanel.repaint();
        }
        if (name.equals("By Name")) {
            Collections.sort(Main.arrayListDownloadBoxes.getDownloadBoxes(), (o1, o2) -> {
                return o2.getFileName().compareTo(o1.getFileName());
            });
            Main.arrayListDownloadBoxes.addBoxes();
            mainDownloadPanel.revalidate();
            mainDownloadPanel.repaint();
        }
        if (name.equals("By Size")) {
            //  Collections.sort(Main.arrayListDownloadBoxes.getDownloadBoxes(), (o1, o2) -> {return o2.getFileName() - ( o1.getFileName()) ;});
            Main.arrayListDownloadBoxes.addBoxes();
            mainDownloadPanel.revalidate();
            mainDownloadPanel.repaint();
        }
    }

    /**
     * change trend sort
     */
    public void changeSortTrend() {
        Collections.reverse(Main.arrayListDownloadBoxes.getDownloadBoxes());
        Main.arrayListDownloadBoxes.addBoxes();
        mainDownloadPanel.revalidate();
        mainDownloadPanel.repaint();
    }

    /**
     * this method read from file our JDM field name
     * from English Language file or persian
     *
     * @param name
     */
    public void setLanguage(String name) {
        try {
            if (name.equals("Persian")) {
                FileReader reader = new FileReader("PersianLanguage.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
                menuPanel.getMenuPanel().setDownloadsText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setHelpText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setNewDownloadText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setPauseText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setResumeText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setCancelText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setRemoveText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setSettingText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setExitText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setAboutText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setExportText(bufferedReader.readLine());
                categories.setProcessingText(bufferedReader.readLine());
                categories.setCompletedText(bufferedReader.readLine());
                categories.setQueuesText(bufferedReader.readLine());
                Setting.setLimitDownloadText(bufferedReader.readLine());
                Setting.setLookAndFeelText(bufferedReader.readLine());
                Setting.setSaveAddressText(bufferedReader.readLine());
                Setting.setFilterAddressText(bufferedReader.readLine());
                Setting.setLanguageText(bufferedReader.readLine());
            }
            if (name.equals("English")) {
                FileReader reader = new FileReader("EnglishLanguage.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
                menuPanel.getMenuPanel().setDownloadsText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setHelpText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setNewDownloadText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setPauseText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setResumeText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setCancelText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setRemoveText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setSettingText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setExitText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setAboutText(bufferedReader.readLine());
                menuPanel.getMenuPanel().setExportText(bufferedReader.readLine());
                categories.setProcessingText(bufferedReader.readLine());
                categories.setCompletedText(bufferedReader.readLine());
                categories.setQueuesText(bufferedReader.readLine());
                Setting.setLimitDownloadText(bufferedReader.readLine());
                Setting.setLookAndFeelText(bufferedReader.readLine());
                Setting.setSaveAddressText(bufferedReader.readLine());
                Setting.setFilterAddressText(bufferedReader.readLine());
                Setting.setLanguageText(bufferedReader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * this method export .JDM files to a zip file
     */
    public void export() {
        try {
            FileOutputStream fos = new FileOutputStream("information.zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            byte[] buffer = new byte[128];

            File files[] = new File[5];
            files[0] = new File("list.jdm");
            files[1] = new File("queue.jdm");
            files[2] = new File("setting.jdm");
            files[3] = new File("filter.jdm");
            files[4] = new File("removed.jdm");

            for (int i = 0; i < files.length; i++) {
                File currentFile = files[i];

                ZipEntry entry = new ZipEntry(currentFile.getName());
                FileInputStream fis = new FileInputStream(currentFile);
                zos.putNextEntry(entry);
                int read = 0;
                while ((read = fis.read(buffer)) != -1) {
                    zos.write(buffer, 0, read);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
