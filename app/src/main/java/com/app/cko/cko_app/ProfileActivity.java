package com.app.cko.cko_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.app.cko.cko_app.JSON.ReadJSON;
import com.app.cko.cko_app.Model.Course;
import com.app.cko.cko_app.Model.CourseAdapter;
import com.app.cko.cko_app.Model.Profile;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Profile profile;
    ArrayList<Course> coursesArrayList=new ArrayList<Course>();
    CourseAdapter courseAdapter;
    String Name;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        context = this;
        try {
                profile = ReadJSON.readCourseJSONFile(getIntent().getStringExtra("JSON"));
                ((TextView)findViewById(R.id.first_name)).setText(profile.getProfileName());
                coursesArrayList= profile.getCourses();
                courseAdapter=new CourseAdapter(this,coursesArrayList);
                ListView lv=findViewById(R.id.courses_lv);
                lv.setAdapter(courseAdapter);
                lv.setOnItemClickListener(new GroupsItemClickListener());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private class GroupsItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(context,NotificationActivity.class);
            intent.putExtra("EventStrings",profile.getEvents().get(position));
            startActivity(intent);
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
        Intent intent;
        Log.i("CKO_APP_MENU",String.valueOf(menuItem.getItemId()));
        switch(id){
            case R.id.menu_news:
                intent=new Intent(this,NewsActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_profile:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START))
                    drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.menu_notifications:
                intent=new Intent(this,NotificationActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onClickExample(View view) {
        int position = (int) view.getTag();
        Intent intent = new Intent(this, EducationActivity.class);
        intent.putExtra("Lessons",coursesArrayList.get(position).getLessons());
        intent.putExtra("Title",coursesArrayList.get(position).getCourseName());
        startActivity(intent);
        //////
    }
}
