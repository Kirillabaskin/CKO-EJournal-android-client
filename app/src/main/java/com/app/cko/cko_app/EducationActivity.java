package com.app.cko.cko_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.app.cko.cko_app.Model.LessonAdapter;
import com.app.cko.cko_app.Model.Lesson;

import java.util.ArrayList;

public class EducationActivity extends AppCompatActivity {

    LessonAdapter marksAdapter;
    ArrayList<Lesson> lessons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.education_layout);
        Intent intent=getIntent();
        ((TextView)findViewById(R.id.marks_title)).setText(intent.getStringExtra("Title"));
        lessons=(ArrayList<Lesson>)intent.getSerializableExtra("Lessons");
        marksAdapter = new LessonAdapter(this,lessons);

        ListView lw=findViewById(R.id.lv_marks);
        lw.setAdapter(marksAdapter);
    }

    public void onMenuClick(View view){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
}
