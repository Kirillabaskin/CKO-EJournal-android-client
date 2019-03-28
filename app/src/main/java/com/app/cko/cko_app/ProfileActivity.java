package com.app.cko.cko_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    String Name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
    }

    public void onClickExample(View view){
        Intent intent = new Intent(this,EducationActivity.class);
        startActivity(intent);
        //////
    }
}
