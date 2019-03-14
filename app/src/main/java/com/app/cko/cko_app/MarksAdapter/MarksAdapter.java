package com.app.cko.cko_app.MarksAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.cko.cko_app.R;

import java.util.ArrayList;

public class MarksAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Marks> marksArrayList;

    public MarksAdapter(Context context,ArrayList<Marks> marks){
        this.context=context;
        marksArrayList=marks;
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return marksArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return marksArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if(view== null){
            view=layoutInflater.inflate(R.layout.marks_item_list,parent,false);
        }

        Marks m=(Marks) getItem(position);


        ((TextView)view.findViewById(R.id.list_date)).setText(m.getDate());
        ((TextView)view.findViewById(R.id.list_title)).setText(m.getTitle());
        ((TextView)view.findViewById(R.id.list_mark)).setText(m.getMark());
        ((TextView)view.findViewById(R.id.list_homework)).setText(m.getHomeWork());
        return view;
    }
}
