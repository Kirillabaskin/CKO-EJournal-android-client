package com.app.cko.cko_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.app.cko.cko_app.Model.EventAdapter;
import com.app.cko.cko_app.Model.EventFactor;
import com.app.cko.cko_app.Model.GroupEvent;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    ArrayList<GroupEvent> events=new ArrayList<GroupEvent>();
    EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_layout);
        Intent intent = getIntent();
        String[] strings = intent.getStringArrayExtra("EventStrings");
        eventAdapter=new EventAdapter(this,EventFactor.makeEventArray(strings));
        ((ListView)findViewById(R.id.notification_lv)).setAdapter(eventAdapter);
    }
}
