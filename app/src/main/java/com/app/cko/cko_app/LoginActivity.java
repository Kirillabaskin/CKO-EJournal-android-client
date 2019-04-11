package com.app.cko.cko_app;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class LoginActivity extends AppCompatActivity{

    private final OkHttpClient client = new OkHttpClient();

    public String url= "http://projectcko.ru/androidlogin";

    public static final MediaType FORM = MediaType.parse("multipart/form-data");

    private String profileString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
    }

    public class OkHttpHandler extends AsyncTask<String, Void, Void> {

        private Context context;

        public OkHttpHandler(Context context){
            this.context=context;
        }

        @Override
        protected Void doInBackground(String...params) {

            RequestBody formBody = new FormBody.Builder().add("login", "abcde")
                    .add("password","12345")
                    .build();
            Request request = new Request.Builder().url(url).post(formBody).build();
            try {
                Response response = client.newCall(request).execute();
                if (!response.isSuccessful())
                    throw new IOException("Unexpected code " + response);
                profileString= response.body().string();
                Intent intent = new Intent(context,ProfileActivity.class);
                Log.i("CKO_APP_REQUEST",profileString);
                intent.putExtra("JSON",profileString);
                startActivity(intent);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public void onLogginButtonClick(View view){
        OkHttpHandler okHttpHandler= new OkHttpHandler(this);
        okHttpHandler.execute(((EditText)findViewById(R.id.login)).getText().toString(),
                ((EditText)findViewById(R.id.password)).getText().toString());
    }




}

