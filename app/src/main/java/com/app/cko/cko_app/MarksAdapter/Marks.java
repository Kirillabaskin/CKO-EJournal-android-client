package com.app.cko.cko_app.MarksAdapter;

import java.util.Date;

public class Marks {
    private Date date;
    private String title;
    private byte mark;
    private String homeWork;

    public Marks(Date date,String title,byte mark,String homeWork){
        this.date=date;
        this.title=title;
        this.mark=mark;
        this.homeWork=homeWork;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public byte getMark() {
        return mark;
    }

    public String getHomeWork(){
        return homeWork;
    }
}
