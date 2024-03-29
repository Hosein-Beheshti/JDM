import javax.swing.*;
import java.io.Serializable;
import java.util.Date;

public class Information implements Serializable {
    private String name;
    private String adress;
    private int size;
    private int speed;
    private int percent;
    private Date time;

    public Information() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Date getDate() {
        return time;
    }

    public void setDate(Date time) {
        this.time = time;
    }
}
