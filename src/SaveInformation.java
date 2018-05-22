import java.io.*;


public class SaveInformation {
    DownloadsPanel downloadsPanel;
    FileOutputStream fileOut = null;
    private FileInputStream fileIn = null;

            ;
    public SaveInformation() {
        try {
            fileOut = new FileOutputStream("list.jdm");
            fileIn = new FileInputStream("list.jdm");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void writeDownloadPanels(DownloadsPanel dP) {
        ObjectOutputStream out = null;
        try {
           /* FileInputStream fileIn = new FileInputStream("list.jdm");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (fileIn.available() > 0) {
            }*/
            out = new ObjectOutputStream(fileOut);
            out.writeObject(dP);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDownloadPanels() {
        downloadsPanel = new DownloadsPanel("");
        try {
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (fileIn.available() > 0) {
                downloadsPanel = (DownloadsPanel) in.readObject();
                Main.arrayListDownloadBoxes.getDownloadBoxes().add(downloadsPanel);
                Main.arrayListDownloadBoxes.addBoxes();
            }


        } catch (java.io.IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Phone class not found");
            c.printStackTrace();
            return;
        }
    }
}
