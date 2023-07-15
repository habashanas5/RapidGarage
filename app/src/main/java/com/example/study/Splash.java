package com.example.study;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    public static int SPLASH_TIMER = 3000;

    public void sendToActivity() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("");
        bar.hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sendToActivity();
                finish();
            }
        }, SPLASH_TIMER);
    }
}