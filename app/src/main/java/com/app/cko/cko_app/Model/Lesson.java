package com.app.cko.cko_app.Model;

import java.io.Serializable;

public class Lesson implements Serializable {
    private int lessonNumber;
    private String classMark;
    private String homeMark;
    private String homeWork;
    private String theme;

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getClassMark() {
        return classMark;
    }

    public void setClassMark(String classMark) {
        this.classMark = classMark;
    }

    public String getHomeMark() {
        return homeMark;
    }

    public void setHomeMark(String homeMark) {
        this.homeMark = homeMark;
    }

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}