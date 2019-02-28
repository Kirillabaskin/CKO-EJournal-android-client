package com.app.cko.cko_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EducationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.education_layout);
    }

    public void onMenuClick(View view){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
}
