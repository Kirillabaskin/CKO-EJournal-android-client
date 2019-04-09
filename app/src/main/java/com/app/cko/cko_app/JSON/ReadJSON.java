package com.app.cko.cko_app.JSON;

import android.content.Context;

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
import com.app.cko.cko_app.Model.Lesson;
import com.app.cko.cko_app.R;

public class ReadJSON {
    public static ArrayList<Course> readCourseJSONFile(Context context) throws IOException,JSONException {
        String jsonText = readText(context, R.raw.json_example);

        JSONArray jsonArray = new JSONArray(jsonText);
        ArrayList<Course> courses=new ArrayList<Course>();
        Course temp;
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            temp=new Course();
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
                lessons[j].setClassMark(jsLesson.getInt("ClassMark"));
                lessons[j].setHomeMark(jsLesson.getInt("HomeMark"));
                lessons[j].setHomeWork(jsLesson.getString("Homework"));
                lessons[j].setTheme(jsLesson.getString("Theme"));
            }
            temp.setLessons(new ArrayList<Lesson>(Arrays.asList(lessons)));
            courses.add(temp);
        }
        return courses;
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

