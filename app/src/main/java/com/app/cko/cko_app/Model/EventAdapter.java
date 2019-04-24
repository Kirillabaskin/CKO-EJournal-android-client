package com.app.cko.cko_app.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.cko.cko_app.R;

import java.util.ArrayList;

public class EventAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GroupEvent> events;
    private LayoutInflater layoutInflater;


    public EventAdapter(Context context, ArrayList<GroupEvent> events){
        this.context=context;
        this.events=events;
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view== null){
            view=layoutInflater.inflate(R.layout.notification_item_list,parent,false);
        }

        GroupEvent ge=(GroupEvent) getItem(position);

        ((TextView)view.findViewById(R.id.event_name_txt)).setText(ge.getEventName());
        ((TextView)view.findViewById(R.id.event_date_txt)).setText(ge.getEventDate());
        return view;
    }
}
