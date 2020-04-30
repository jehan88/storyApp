package com.app.story;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    openHomeActivity();
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }

    public void openHomeActivity(){
        startActivity(new Intent(SplashActivity.this, ListActivity.class));
    }
}