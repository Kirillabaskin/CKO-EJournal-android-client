package com.app.cko.cko_app.Model;

import java.util.ArrayList;

public class Profile {
    private ArrayList<Course> courses;
    private ArrayList<String[]> events;
    private String profileName;

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public ArrayList<String[]> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<String[]> events) {
        this.events = events;
    }
}
