package net.ssp.listtest;

/**
 * Created by user on 8/15/14.
 */
public class DataList {
    int StuffId;
    String StuffName;
    String title;
    int imgResId;
    String StuffStatus;
    boolean connection;

    public boolean isConnection() {
        return connection;
    }

    @Override
    public String toString() {
        return String.valueOf(StuffId);
    }

    public void setConnection(boolean connection) {
        this.connection = connection;
    }

    public String getStuffStatus() {
        return StuffStatus;
    }

    public void setStuffStatus(String stuffStatus) {
        StuffStatus = stuffStatus;
    }

    public int getStuffId() {
        return StuffId;
    }

    public void setStuffId(int stuffId) {
        StuffId = stuffId;
    }

    public String getStuffName() {
        return StuffName;
    }

    public void setStuffName(String stuffName) {
        StuffName = stuffName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

}
