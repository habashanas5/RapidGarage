package com.example.study;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView Bottonn;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private Button CHECK_YOUR_PROBLEM, SHOW_ALL_SERVICES, SHOW_ALL_GARAGE, MAP, GAS_STATION, CAR_WASH;
    private ImageButton IMAGE_CHECK_YOUR_PROBLEM, IMAGE_SHOW_ALL_SERVICES, IMAGE_SHOW_ALL_GARAGE, IMAGE_MAP, IMAGE_GAS_STATION, IMAGE_CAR_WASH;
    NavigationView navigationView;
    private LocationRequest locationRequest;
    private static final int REQUEST_CHECK_SETTINGS = 10001;

    @Override
    public void onBackPressed() {

    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bottonn = findViewById(R.id.myBottom);
        Bottonn.showContextMenu();
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Rapid Garage");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        bar.setDisplayHomeAsUpEnabled(true);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        turnLocation();

        navigationView = findViewById(R.id.navigation_view);
        CHECK_YOUR_PROBLEM = findViewById(R.id.button_Check_your_problem);
        SHOW_ALL_SERVICES = findViewById(R.id.button_show_all_services);
        SHOW_ALL_GARAGE = findViewById(R.id.button_show_all_garage);
        MAP = findViewById(R.id.button_map);
        CAR_WASH = findViewById(R.id.button_wash);
        GAS_STATION = findViewById(R.id.button_gas);
        IMAGE_CAR_WASH = findViewById(R.id.image_wash);
        IMAGE_CHECK_YOUR_PROBLEM = findViewById(R.id.image_Check_your_problem);
        IMAGE_GAS_STATION = findViewById(R.id.image_gas);
        IMAGE_MAP = findViewById(R.id.image_map);
        IMAGE_SHOW_ALL_GARAGE = findViewById(R.id.image_show_all_garage);
        IMAGE_SHOW_ALL_SERVICES = findViewById(R.id.image_show_all_services);
        CHECK_YOUR_PROBLEM.setOnClickListener(this);
        SHOW_ALL_SERVICES.setOnClickListener(this);
        SHOW_ALL_GARAGE.setOnClickListener(this);
        MAP.setOnClickListener(this);
        CAR_WASH.setOnClickListener(this);
        GAS_STATION.setOnClickListener(this);
        IMAGE_CAR_WASH.setOnClickListener(this);
        IMAGE_CHECK_YOUR_PROBLEM.setOnClickListener(this);
        IMAGE_GAS_STATION.setOnClickListener(this);
        IMAGE_MAP.setOnClickListener(this);
        IMAGE_SHOW_ALL_GARAGE.setOnClickListener(this);
        IMAGE_SHOW_ALL_SERVICES.setOnClickListener(this);
        Bottonn.setOnNavigationItemSelectedListener(this);

        bar.addOnMenuVisibilityListener(new ActionBar.OnMenuVisibilityListener() {
            @Override
            public void onMenuVisibilityChanged(boolean isVisible) {
                System.out.println("the overflow menu becomes: " + isVisible);
            }
        });

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
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == DialogInterface.BUTTON_POSITIVE) {
            super.finish();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == CHECK_YOUR_PROBLEM) {
            CheckPromlem();

        } else if (v == IMAGE_CHECK_YOUR_PROBLEM) {
            CheckPromlem();

        } else if (v == SHOW_ALL_SERVICES) {
            Service();

        } else if (v == IMAGE_SHOW_ALL_SERVICES) {
            Service();

        } else if (v == MAP) {
            Map();

        } else if (v == IMAGE_MAP) {
            Map();

        } else if (v == GAS_STATION) {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=gas+stations&near=<latitude>,<longitude>&sort=distance"));
            startActivity(intent);

        } else if (v == IMAGE_GAS_STATION) {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=gas+stations&near=<latitude>,<longitude>&sort=distance"));
            startActivity(intent);

        } else if (v == SHOW_ALL_GARAGE) {

        } else if (v == IMAGE_SHOW_ALL_GARAGE) {


        } else if (v == CAR_WASH) {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=car+wash&near=<latitude>,<longitude>"));
            startActivity(intent);

        } else if (v == IMAGE_CAR_WASH) {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=car+wash&near=<latitude>,<longitude>"));
            startActivity(intent);

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        System.out.println("item is: " + item);
        if (item.getItemId() == R.id.Home) {
            sendHome();
        } else if (item.getItemId() == R.id.Notification) {
            Intent j = new Intent(this, gasStation.class);
            startActivity(j);
        } else if (item.getItemId() == R.id.myProfile) {
            Intent intent = getIntent();
            String userID = intent.getStringExtra("ID");
            String userFirstName = intent.getStringExtra("FirstName");
            String userLastName = intent.getStringExtra("LastName");
            String userType = intent.getStringExtra("type");
            String userphone = intent.getStringExtra("phone");
            String userEmail = intent.getStringExtra("Email");
            SendToActivityProfile(userID, userEmail, userFirstName, userLastName, userphone, userType);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CHECK_SETTINGS) {

            switch (resultCode) {
                case Activity.RESULT_OK:
                    Toast.makeText(this, "GPS is tured on", Toast.LENGTH_SHORT).show();

                case Activity.RESULT_CANCELED:
                    Toast.makeText(this, "GPS required to be tured on", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void CheckPromlem() {
        Intent intent = new Intent(this, checkProblem.class);
        startActivity(intent);
    }

    public void onNavigationItemSelectedSetting(String pass) {
        if (isConnected()) {
            Intent intent = getIntent();
            String userID = intent.getStringExtra("ID");
            String userFirstName = intent.getStringExtra("FirstName");
            String userLastName = intent.getStringExtra("LastName");
            String userphone = intent.getStringExtra("phone");
            String userEmail = intent.getStringExtra("Email");

            sendToSetting(userID, userFirstName , userLastName , pass , userphone , userEmail );
        }
        else {
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

    public void sendHome() {
        //    Intent home = new Intent(this, MainActivity.class);
        //   startActivity(home);
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

    public void sendFeedBack(String ID) {
        Intent feed = new Intent(this, feedBack.class);
        feed.putExtra("ID", ID);
        startActivity(feed);

    }

    public void sendRate(String ID) {
        Intent rate = new Intent(this, rating.class);
        rate.putExtra("ID", ID);
        startActivity(rate);
    }

    public void Service() {
        if (isConnected()) {
            Intent intent = getIntent();
            String userID = intent.getStringExtra("ID");
            String userFirstName = intent.getStringExtra("FirstName");
            String userLastName = intent.getStringExtra("LastName");
            String userType = intent.getStringExtra("type");
            String userphone = intent.getStringExtra("phone");
            String userEmail = intent.getStringExtra("Email");
            SendToActivityService(userID, userEmail, userFirstName, userLastName, userphone, userType);
        } else {
            NoInternet();
        }
    }

    public void Map() {
        if (isConnected()) {
            Intent intent = new Intent(this, MapActivity.class);
            startActivity(intent);
        } else {
            NoInternet();
        }
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

    public void SendToActivityService(String ID, String Email, String FirstName, String LastName, String phone, String myChoices) {
        Intent intent = new Intent(this, services.class);
        intent.putExtra("ID", ID);
        intent.putExtra("Email", Email);
        intent.putExtra("FirstName", FirstName);
        intent.putExtra("LastName", LastName);
        intent.putExtra("phone", phone);
        intent.putExtra("type", myChoices);
        startActivity(intent);
    }

    public void turnLocation() {
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(2000);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);
        Task<LocationSettingsResponse> result = LocationServices.getSettingsClient(getApplicationContext())
                .checkLocationSettings(builder.build());
        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {

                try {
                    LocationSettingsResponse response = task.getResult(ApiException.class);
                    Toast.makeText(MainActivity.this, "GPS is already tured on", Toast.LENGTH_SHORT).show();

                } catch (ApiException e) {

                    switch (e.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:

                            try {
                                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                                resolvableApiException.startResolutionForResult(MainActivity.this, REQUEST_CHECK_SETTINGS);
                            } catch (IntentSender.SendIntentException ex) {
                                ex.printStackTrace();
                            }
                            break;

                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            //Device does not have location
                            break;
                    }
                }
            }
        });
    }
}