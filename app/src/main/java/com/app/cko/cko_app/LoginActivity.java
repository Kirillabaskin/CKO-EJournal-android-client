package com.app.cko.cko_app;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class LoginActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
    }

    public void onLogginButtonClick(View view){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }

}

