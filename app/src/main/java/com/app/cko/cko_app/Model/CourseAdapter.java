package com.app.cko.cko_app.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.cko.cko_app.R;

import java.util.ArrayList;

public class CourseAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Course> coursesArrayList;

    public CourseAdapter(Context context,ArrayList<Course> courses){
        this.context=context;
        coursesArrayList=courses;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return coursesArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return coursesArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=convertView;
        if(view==null){
            view=layoutInflater.inflate(R.layout.courses_item_list,parent,false);
        }

        Course course= (Course) getItem(position);

        ((TextView)view.findViewById(R.id.teacher_txt)).setText(course.getTeacher());
        ((TextView)view.findViewById(R.id.course_txt)).setText(course.getCourseName());

        return view;
    }
}
