package com.app.cko.cko_app.JSON;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.app.cko.cko_app.Model.Course;
import com.app.cko.cko_app.Model.GroupEvent;
import com.app.cko.cko_app.Model.Lesson;
import com.app.cko.cko_app.Model.Profile;
import com.app.cko.cko_app.R;

public class ReadJSON {
    public static Profile readCourseJSONFile(String msg) throws IOException,JSONException {
        Profile profile = new Profile();
        Log.i("CKO_APP ",msg);
        JSONObject dirObject = new JSONObject(msg);
        profile.setProfileName(dirObject.getString("RealName"));
        JSONArray jsonArray = dirObject.getJSONArray("GroupsInfo");
        ArrayList<Course> courses=new ArrayList<Course>();
        profile.setEvents(new ArrayList<String[]>());
        Course temp;
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);

            JSONArray eventsArray= jsonObject.getJSONArray("Events");
            String[] mas = new String[eventsArray.length()*2];
            for(int j=0;j<2*eventsArray.length();j+=2){
                mas[j]=((JSONObject)eventsArray.get(j/2)).getString("Event");
                mas[j+1]=((JSONObject)eventsArray.get(j/2)).getString("Date");
            }
            profile.getEvents().add(mas);
            temp=new Course();
            temp.setDate(jsonObject.getString("Info"));
            temp.setGroupName(jsonObject.getString("GroupName"));
            temp.setCourseName(jsonObject.getString("CourseName"));
            temp.setTeacher(jsonObject.getString("Teacher"));
            temp.setAmount(jsonObject.getInt("Amount"));
            JSONArray jsLessons=jsonObject.getJSONArray("Lessons");
            Lesson[] lessons=new Lesson[jsLessons.length()];
            for(int j=0;j<jsLessons.length();j++){
                JSONObject jsLesson=jsLessons.getJSONObject(j);
                //int index=jsLesson.getInt("LessonNumber");
                lessons[j]=new Lesson();
                lessons[j].setClassMark(jsLesson.getString("ClassMark"));
                lessons[j].setHomeMark(jsLesson.getString("HomeMark"));
                lessons[j].setHomeWork(jsLesson.getString("Homework"));
                lessons[j].setTheme(jsLesson.getString("Theme"));
            }
            temp.setLessons(new ArrayList<Lesson>(Arrays.asList(lessons)));
            courses.add(temp);
        }
        profile.setCourses(courses);
        return profile;
    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}

