package com.app.cko.cko_app.Model;

import java.io.Serializable;

public class Lesson implements Serializable {
    private int lessonNumber;
    private int classMark;
    private int homeMark;
    private String homeWork;
    private String theme;

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public int getClassMark() {
        return classMark;
    }

    public void setClassMark(int classMark) {
        this.classMark = classMark;
    }

    public int getHomeMark() {
        return homeMark;
    }

    public void setHomeMark(int homeMark) {
        this.homeMark = homeMark;
    }

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homwWork) {
        this.homeWork = homwWork;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}