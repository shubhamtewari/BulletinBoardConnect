package core;

import java.sql.Time;
import java.util.Date;

/**
 * this class emulates a board that has notices in two layers
 *
 * @author shubhamtewari
 */
public class Board {
    private String name;//name of the board
    private Date date;//date displayed on the board
    private String day;//day displayed on the board
    private Time time;//time displayed on the board
    private String weatherArray[];//the weather
    private Notice backgroundNoticeList[];//the notices displayed on the base
    private Notice foregroundNoticeList[];//temporary notices displayed on the front

    //constructor
    public Board(String name) {
        this.name = name;
        backgroundNoticeList = new Notice[20];//no more than 20 notices will be displayed at a time
        foregroundNoticeList = new Notice[20];
    }

    //getter and setter
    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setWeatherArray(String[] weatherArray) {
        this.weatherArray = weatherArray;
    }

    public void setBackgroundNoticeList(Notice[] backgroundNoticeList) {
        this.backgroundNoticeList = backgroundNoticeList;
    }

    public void setForegroundNoticeList(Notice[] foregroundNoticeList) {
        this.foregroundNoticeList = foregroundNoticeList;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public Time getTime() {
        return time;
    }

    public String[] getWeatherArray() {
        return weatherArray;
    }

    public Notice[] getBackgroundNoticeList() {
        return backgroundNoticeList;
    }

    public Notice[] getForegroundNoticeList() {
        return foregroundNoticeList;
    }
}
