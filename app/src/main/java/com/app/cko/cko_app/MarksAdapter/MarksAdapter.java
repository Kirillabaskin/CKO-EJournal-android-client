package com.app.cko.cko_app.MarksAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.cko.cko_app.Model.Lesson;
import com.app.cko.cko_app.R;

import java.util.ArrayList;

public class MarksAdapter extends BaseAdapter {
    //TODO:переделать. Marks и Lesson одно и тоже
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Lesson> marksArrayList;

    public MarksAdapter(Context context,ArrayList<Lesson> marks){
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

        Lesson m=(Lesson) getItem(position);

        ((TextView)view.findViewById(R.id.list_title)).setText(m.getTheme());
        ((TextView)view.findViewById(R.id.list_mark)).setText(String.valueOf(m.getClassMark()));
        ((TextView)view.findViewById(R.id.list_homework)).setText(String.valueOf(m.getHomeMark()));
        return view;
    }
}
