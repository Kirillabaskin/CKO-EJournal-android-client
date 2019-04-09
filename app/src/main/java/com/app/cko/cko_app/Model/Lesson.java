package com.app.cko.cko_app.Model;

public class Lesson {
    private int lessonNumber;
    private int classMark;
    private int homeMark;
    private String homwWork;
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

    public String getHomwWork() {
        return homwWork;
    }

    public void setHomwWork(String homwWork) {
        this.homwWork = homwWork;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}