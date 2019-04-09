package com.app.cko.cko_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.app.cko.cko_app.JSON.ReadJSON;
import com.app.cko.cko_app.Model.Course;
import com.app.cko.cko_app.Model.CourseAdapter;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    ArrayList<Course> coursesArrayList=new ArrayList<Course>();
    CourseAdapter courseAdapter;

    String Name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        try {
                coursesArrayList= ReadJSON.readCourseJSONFile(this);
                courseAdapter=new CourseAdapter(this,coursesArrayList);
                ListView lv=findViewById(R.id.courses_lv);
                lv.setAdapter(courseAdapter);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void onClickExample(View view){
        Intent intent = new Intent(this,EducationActivity.class);
        startActivity(intent);
        //////
    }
}
