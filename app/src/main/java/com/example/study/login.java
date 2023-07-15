package com.example.study;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button SINGUP, LOGING, facebook, google;
    private EditText USERID, PASSWORD;
    private TextView FORKET;
    private RadioButton CLIENT, OWNWE;

    @Override
    public void onBackPressed() {
        AlertDialog x = new AlertDialog.Builder(this)
                .setTitle("\t\t\t\t Exit the application")
                .setMessage("\n\t\t\t\t\t\t\t\t\t\t Do you want to Exit?")
                .setIcon(R.drawable.exit).setCancelable(true)
                .setPositiveButton("yes", this)
                .setNeutralButton("cancel", this).create();
        x.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("");
        bar.hide();
        SINGUP = findViewById(R.id.BtnSignUp);
        LOGING = findViewById(R.id.btnlogin);
        facebook = findViewById(R.id.btnFacebook);
        google = findViewById(R.id.btnGoogle);
        USERID = findViewById(R.id.username);
        PASSWORD = findViewById(R.id.password);
        FORKET = findViewById(R.id.forgotPassword);
        CLIENT = findViewById(R.id.Client);
        OWNWE = findViewById(R.id.owner);
        SINGUP.setOnClickListener(this);
        LOGING.setOnClickListener(this);
        facebook.setOnClickListener(this);
        google.setOnClickListener(this);
        FORKET.setOnClickListener(this);

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == DialogInterface.BUTTON_POSITIVE) {
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == LOGING) {
            String user = USERID.getText().toString();
            String pass = PASSWORD.getText().toString();
            String myChoices = "";

            if (CLIENT.isChecked() == true) {
                myChoices = "client";
            } else if (OWNWE.isChecked() == true) {
                myChoices = "owner";
            }

            if (isConnected()) {

                if (user.isEmpty() == true || pass.isEmpty() == true || myChoices.isEmpty() == true) {
                    Toast.makeText(this, "Please enter your name, password and choose(client or owner) ", Toast.LENGTH_SHORT).show();
                } else {

                    if (!validateUsername() | !validatePassword()) {

                    } else {
                        Toast.makeText(this, "It will take a few seconds, please wait", Toast.LENGTH_SHORT).show();
                        checkUser();
                    }
                }
            } else {
                NoInternet();
            }

        } else if (v == SINGUP) {
            Intent i = new Intent(this, signUp.class);
            startActivity(i);
        } else if (v == google) {

        } else if (v == facebook) {

        } else if (v == FORKET) {

        }
    }


    public Boolean validateUsername() {
        String val = USERID.getText().toString();
        if (val.isEmpty()) {
            USERID.setError("Username cannot be empty");
            return false;
        } else {
            USERID.setError(null);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = PASSWORD.getText().toString();
        if (val.isEmpty()) {
            PASSWORD.setError("Password cannot be empty");
            return false;
        } else {
            PASSWORD.setError(null);
            return true;
        }
    }

    public void SendToActivity(String ID, String Email, String FirstName, String LastName, String phone, String myChoices , String pass) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ID", ID);
        intent.putExtra("Email", Email);
        intent.putExtra("FirstName", FirstName);
        intent.putExtra("LastName", LastName);
        intent.putExtra("phone", phone);
        intent.putExtra("type", myChoices);
        intent.putExtra("pass" , pass);
        startActivity(intent);
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

    public void NoInternet() {
        AlertDialog x1 = new AlertDialog.Builder(this)
                .setTitle("\t\t\t\t Connection Failed")
                .setMessage("\n\t\t please check your internet connection")
                .setIcon(R.drawable.baseline_wifi_off_24).setCancelable(true).create();
        x1.show();
    }


    public void checkUser() {
        String userUserID = USERID.getText().toString().trim();
        String userPassword = PASSWORD.getText().toString().trim();
        String myChoices = "";

        if (CLIENT.isChecked() == true) {
            myChoices = "client";
        } else if (OWNWE.isChecked() == true) {
            myChoices = "owner";
        }
        String type = myChoices.trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("userID").equalTo(userUserID);
        System.out.println(type);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    USERID.setError(null);
                    String passwordFromDB = snapshot.child(userUserID).child("password").getValue(String.class);
                    String myChoicesFromDB = snapshot.child(userUserID).child("myChoice").getValue(String.class);

                    if (passwordFromDB.equals(userPassword) && myChoicesFromDB.equals(type)) {
                        USERID.setError(null);

                        String IDFromDB = snapshot.child(userUserID).child("userID").getValue(String.class);
                        String emailFromDB = snapshot.child(userUserID).child("email").getValue(String.class);
                        String firstNameFromDB = snapshot.child(userUserID).child("firstName").getValue(String.class);
                        String lastNameFromDB = snapshot.child(userUserID).child("lastName").getValue(String.class);
                        String phoneFromDB = snapshot.child(userUserID).child("phone").getValue(String.class);
                        SendToActivity(IDFromDB, emailFromDB, firstNameFromDB, lastNameFromDB, phoneFromDB, myChoicesFromDB , passwordFromDB);

                    } else {
                        PASSWORD.setError("Invalid Credentials");
                        PASSWORD.requestFocus();
                    }

                } else {
                    USERID.setError("User does not exist");
                    USERID.requestFocus();
                }
                
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }

}







































