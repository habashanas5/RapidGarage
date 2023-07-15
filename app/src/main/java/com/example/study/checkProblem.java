package com.example.study;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class checkProblem extends AppCompatActivity implements View.OnClickListener {
    private ImageButton IMAGE_SEE, IMAGE_HEAR, IMAGE_SMELL, IMAGE_FEEL, IMAGE_NOTSTART;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_problem);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        IMAGE_SEE = findViewById(R.id.image_Button_eye);
        IMAGE_HEAR = findViewById(R.id.image_Button_hear);
        IMAGE_SMELL = findViewById(R.id.image_Button_smell);
        IMAGE_FEEL = findViewById(R.id.image_Button_feel);
        IMAGE_NOTSTART = findViewById(R.id.image_Button_notStart);
        IMAGE_SEE.setOnClickListener(this);
        IMAGE_HEAR.setOnClickListener(this);
        IMAGE_SMELL.setOnClickListener(this);
        IMAGE_FEEL.setOnClickListener(this);
        IMAGE_NOTSTART.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == IMAGE_SEE) {
            Intent i = new Intent(this, checkProblemSee.class);
            startActivity(i);

        } else if (v == IMAGE_HEAR) {

        } else if (v == IMAGE_SMELL) {
            Intent i = new Intent(this, checkProblemSmeel.class);
            startActivity(i);

        } else if (v == IMAGE_NOTSTART) {

        } else if (v == IMAGE_FEEL) {
            Intent i = new Intent(this, checkProblemFeel.class);
            startActivity(i);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("home", "onCreateOptionsMenu is called");
        MenuInflater flat = getMenuInflater();
        flat.inflate(R.menu.menu3, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.i("home", "onPrepareOptionsMenu: ");

        if (menu != null) {
            if (menu instanceof MenuBuilder) {
                ((MenuBuilder) menu).setOptionalIconsVisible(true);
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Log.i("home", "onMenuOpened: ");
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        Log.i("home", "onOptionsMenuClosed: ");
        super.onOptionsMenuClosed(menu);
    }
}