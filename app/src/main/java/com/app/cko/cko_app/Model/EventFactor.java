package com.app.cko.cko_app.Model;

import java.util.ArrayList;

public class EventFactor {
    public static ArrayList<GroupEvent> makeEventArray(String[] strings){
        ArrayList<GroupEvent> events = new ArrayList<>();
        for(int i=0;i<strings.length;i++){
            GroupEvent event = new GroupEvent();
            event.setEventName(strings[i++]);
            event.setEventDate(strings[i]);
            events.add(event);
        }
        return events;
    }
}
