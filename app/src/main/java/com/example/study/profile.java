package com.example.study;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profile extends AppCompatActivity {

    private TextView TYPE , ID , FIRSTNAME , LASTNAME , EMAIL , PHONE;

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
        setContentView(R.layout.activity_profile);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("My profile");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        TYPE = findViewById(R.id.type);
        ID = findViewById(R.id.userId);
        FIRSTNAME = findViewById(R.id.firstName);
        LASTNAME = findViewById(R.id.lastName);
        EMAIL = findViewById(R.id.email);
        PHONE = findViewById(R.id.phone);
        showUserData();
    }

    public void showUserData(){

        Intent intent = getIntent();

        String userID = intent.getStringExtra("ID");
        String userFirstName = intent.getStringExtra("FirstName");
        String userLastName = intent.getStringExtra("LastName");
        String userType = intent.getStringExtra("type");
        String userphone = intent.getStringExtra("phone");
        String userEmail = intent.getStringExtra("Email");

        ID.setText(userID);
        PHONE.setText(userphone);
        EMAIL.setText(userEmail);
        TYPE.setText(userType);
        LASTNAME.setText(userLastName);
        FIRSTNAME.setText(userFirstName);

    }
}