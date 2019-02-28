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
        ((TextView)findViewById(R.id.first_name)).setText("Иван");
        ((TextView)findViewById(R.id.second_name)).setText("Иванов");
        ((TextView)findViewById(R.id.last_name)).setText("Иванович");
    }

    public void onClickExample(View view){
        Intent intent = new Intent(this,EducationActivity.class);
        startActivity(intent);
    }
}
