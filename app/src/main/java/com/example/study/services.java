package com.example.study;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class services extends AppCompatActivity implements DialogInterface.OnClickListener {
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("All Services");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Settings:
                        Intent intent = getIntent();
                        String userID = intent.getStringExtra("ID");
                        String pass = intent.getStringExtra("pass");
                        onNavigationItemSelectedSetting(pass);
                        return true;

                    case R.id.About:
                        onNavigationItemSelectedAbout();
                        return true;

                    case R.id.callUs:
                        onNavigationItemSelectedCallUs();
                        return true;

                    case R.id.MailUs:
                        onNavigationItemSelectedMailUs();
                        return true;

                    case R.id.rate:
                        onNavigationItemSelectedRate();
                        return true;

                    case R.id.feedBack:
                        onNavigationItemSelectedFeedBack();
                        return true;

                    case R.id.logOut:
                        onNavigationItemSelectedLogOut();
                        return true;

                    case R.id.myProfile1:
                        onNavigationItemSelectedProfile();
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            super.finish();
        }
    }

    public void onNavigationItemSelectedSetting(String pass) {
        if (isConnected()) {
            Intent intent = getIntent();
            String userID = intent.getStringExtra("ID");
            String userFirstName = intent.getStringExtra("FirstName");
            String userLastName = intent.getStringExtra("LastName");
            String userphone = intent.getStringExtra("phone");
            String userEmail = intent.getStringExtra("Email");

            sendToSetting(userID, userFirstName, userLastName, pass, userphone, userEmail);
        } else {
            NoInternet();
        }
    }

    public void sendToSetting(String userID , String FName , String LName , String pass , String phone , String emails) {
        Intent intent = new Intent(this, setting.class);
        intent.putExtra("ID", userID);
        intent.putExtra("Email", emails);
        intent.putExtra("FirstName", FName);
        intent.putExtra("LastName", LName);
        intent.putExtra("phone", phone);
        intent.putExtra("password", pass);
        startActivity(intent);
    }

    public void sendFeedBack(String ID) {
        Intent feed = new Intent(this, feedBack.class);
        feed.putExtra("ID", ID);
        startActivity(feed);
    }

    public void sendHome() {
        Intent Home = new Intent(this, MainActivity.class);
        startActivity(Home);
    }

    public void onNavigationItemSelectedLogOut() {
        if (isConnected()) {
            Intent log = new Intent(this, login.class);
            startActivity(log);
            finishAffinity();
        } else {
            NoInternet();
        }
    }

    public void onNavigationItemSelectedAbout() {
        if (isConnected()) {
            Intent about = new Intent(this, about.class);
            startActivity(about);
        } else {
            NoInternet();
        }
    }

    public void onNavigationItemSelectedFeedBack() {
        if (isConnected()) {
            Intent intent = getIntent();
            String userID = intent.getStringExtra("ID");
            sendFeedBack(userID);
        } else {
            NoInternet();
        }
    }

    public void onNavigationItemSelectedRate() {
        if (isConnected()) {
            Intent intent = getIntent();
            String userID = intent.getStringExtra("ID");
            sendRate(userID);
        } else {
            NoInternet();
        }
    }

    public void onNavigationItemSelectedMailUs() {
        Intent email = new Intent(Intent.ACTION_SEND);
        String[] Recepion = {"habashanas716@gmail.com"};
        email.setData(Uri.parse("mailto: habashanas716@gmail.com"));
        email.putExtra(email.EXTRA_EMAIL, Recepion);
        email.putExtra(Intent.EXTRA_SUBJECT, "Urgent email");
        email.putExtra(email.EXTRA_BCC, "habashanas716@gmail.com");
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Send Email"));
    }

    public void onNavigationItemSelectedCallUs() {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:0595497329"));
        startActivity(call);
    }

    public void onNavigationItemSelectedProfile() {
        if (isConnected()) {
            Intent intent = getIntent();
            String userID = intent.getStringExtra("ID");
            String userFirstName = intent.getStringExtra("FirstName");
            String userLastName = intent.getStringExtra("LastName");
            String userType = intent.getStringExtra("type");
            String userphone = intent.getStringExtra("phone");
            String userEmail = intent.getStringExtra("Email");
            SendToActivityProfile(userID, userEmail, userFirstName, userLastName, userphone, userType);
        } else {
            NoInternet();
        }
    }

    public void sendRate(String ID) {
        Intent rate = new Intent(this, rating.class);
        rate.putExtra("ID", ID);
        startActivity(rate);
    }

    public void NoInternet() {
        AlertDialog x1 = new AlertDialog.Builder(this)
                .setTitle("\t\t\t\t Connection Failed")
                .setMessage("\n\t\t please check your internet connection")
                .setIcon(R.drawable.baseline_wifi_off_24).setCancelable(true).create();
        x1.show();
    }

    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null) {
            if (networkInfo.isConnected())
                return true;
            else
                return false;
        } else
            return false;
    }

    public void SendToActivityProfile(String ID, String Email, String FirstName, String LastName, String phone, String myChoices) {
        Intent intent = new Intent(this, profile.class);
        intent.putExtra("ID", ID);
        intent.putExtra("Email", Email);
        intent.putExtra("FirstName", FirstName);
        intent.putExtra("LastName", LastName);
        intent.putExtra("phone", phone);
        intent.putExtra("type", myChoices);
        startActivity(intent);
    }
}