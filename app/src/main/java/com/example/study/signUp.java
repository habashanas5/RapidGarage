package com.example.study;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUp extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    private Button SINGUP, LOGING;
    private EditText USERID, PASSWORD, EMAIL, PHONE, FIRSTNAME, LASTNAME;
    private RadioButton CLIENT, OWNWE;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    public void onBackPressed() {
        AlertDialog x = new AlertDialog.Builder(this)
                .setTitle("\t\t\t Exit the from register page")
                .setMessage("\n\t\t\t\t\t\t\t\t\t\t Do you want to Exit?")
                .setIcon(R.drawable.exit).setCancelable(true)
                .setPositiveButton("yes", this)
                .setNeutralButton("cancel", this).create();
        x.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("");
        bar.hide();
        SINGUP = findViewById(R.id.btnSign);
        LOGING = findViewById(R.id.BtnLogin);
        USERID = findViewById(R.id.userID_reg);
        PASSWORD = findViewById(R.id.password_reg);
        EMAIL = findViewById(R.id.email_reg);
        PHONE = findViewById(R.id.phone_reg);
        CLIENT = findViewById(R.id.Client);
        OWNWE = findViewById(R.id.owner);
        FIRSTNAME = findViewById(R.id.userFirst_name_reg);
        LASTNAME = findViewById(R.id.user_Last_name_reg);
        SINGUP.setOnClickListener(this);
        LOGING.setOnClickListener(this);

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == DialogInterface.BUTTON_POSITIVE) {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == LOGING) {
            Intent i = new Intent(this, login.class);
            startActivity(i);

        }
        if (v == LOGING) {
            Intent i = new Intent(this, login.class);
            startActivity(i);

        } else if (v == SINGUP) {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("users");
            String id = USERID.getText().toString();
            String pass = PASSWORD.getText().toString();
            String email = EMAIL.getText().toString();
            String phone = PHONE.getText().toString();
            String firstName = FIRSTNAME.getText().toString();
            String lastName = LASTNAME.getText().toString();
            String myChoice = "";

            if (CLIENT.isChecked() == true) {
                myChoice = "client";
            } else if (OWNWE.isChecked() == true) {
                myChoice = "owner";
            }

            if (isConnected()) {
                if (id.isEmpty() == true || pass.isEmpty() == true || email.isEmpty() == true
                        || phone.isEmpty() == true || firstName.isEmpty() == true || lastName.isEmpty() == true
                        || myChoice.isEmpty() == true) {
                    Toast.makeText(this, "Please fill in all information ", Toast.LENGTH_SHORT).show();
                } else {

                    HelperClass helperClass = new HelperClass(id, firstName, lastName, pass, email, phone, myChoice);
                    reference.child(id).setValue(helperClass);
                    Toast.makeText(this, "You have signup successfully!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, login.class);
                    startActivity(intent);
                }
            } else {
                NoInternet();
            }
        }
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

}