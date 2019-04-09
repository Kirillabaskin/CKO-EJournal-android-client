package com.app.cko.cko_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.app.cko.cko_app.MarksAdapter.Marks;
import com.app.cko.cko_app.MarksAdapter.MarksAdapter;
import com.app.cko.cko_app.Model.Lesson;

import java.util.ArrayList;
import java.util.Date;

public class EducationActivity extends AppCompatActivity {

    ArrayList<Marks> marksArrayList=new ArrayList<Marks>();
    MarksAdapter marksAdapter;
    ArrayList<Lesson> lessons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.education_layout);
        Intent intent=getIntent();
        ((TextView)findViewById(R.id.marks_title)).setText(intent.getStringExtra("Title"));
        lessons=(ArrayList<Lesson>)intent.getSerializableExtra("Lessons");
        marksAdapter = new MarksAdapter(this,lessons);

        ListView lw=findViewById(R.id.lv_marks);
        lw.setAdapter(marksAdapter);
    }

    public void onMenuClick(View view){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
}
