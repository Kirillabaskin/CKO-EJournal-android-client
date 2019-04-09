package com.app.cko.cko_app.MarksAdapter;


public class Marks {
    private String title;
    private String mark;
    private String homeWork;

    public Marks(String date,String title,String mark,String homeWork){
        this.title=title;
        this.mark=mark;
        this.homeWork=homeWork;
    }

    public String getTitle() {
        return title;
    }

    public String getMark() {
        return mark;
    }

    public String getHomeWork(){
        return homeWork;
    }
}
