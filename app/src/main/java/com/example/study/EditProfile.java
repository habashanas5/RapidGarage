package com.example.study;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfile extends AppCompatActivity implements View.OnClickListener {
    private EditText ID, FName, Lname, pass, email, phone;
    private Button saveButton;
    DatabaseReference reference;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Edit Profile");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        ID = findViewById(R.id.userID_edit);
        FName = findViewById(R.id.userFirst_name_edit);
        Lname = findViewById(R.id.user_Last_name_edit);
        pass = findViewById(R.id.password_edit);
        email = findViewById(R.id.email_edit);
        phone = findViewById(R.id.phone_edit);
        showUserData();
        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == saveButton) {
            reference = FirebaseDatabase.getInstance().getReference("users");
            Intent intent = getIntent();
            String userID = intent.getStringExtra("ID");
            String userFirstName = intent.getStringExtra("FirstName");
            String userLastName = intent.getStringExtra("LastName");
            String passwordUser = intent.getStringExtra("password");
            String userphone = intent.getStringExtra("phone");
            String userEmail = intent.getStringExtra("Email");

            isLastChanged(userID, userLastName);
            isFirstChanged(userID, userFirstName);
            isPhoneChanged(userID, userphone);
            isEmailChanged(userID, userEmail);
            isPasswordChanged(userID, passwordUser);

            if (isLastChanged(userID, userLastName) || isFirstChanged(userID, userFirstName) ||
                    isPhoneChanged(userID, userphone) || isEmailChanged(userID, userEmail) ||
                    isPasswordChanged(userID, passwordUser)) {
                Toast.makeText(this, "Information updated successfully", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean isFirstChanged(String userID, String FirstnameUser) {
        String name = FName.getText().toString();
        if (name.isEmpty() == false) {
            if (!FirstnameUser.equals(FName.getText().toString())) {
                reference.child(userID).child("firstName").setValue(FName.getText().toString());
                FirstnameUser = FName.getText().toString();
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    private boolean isIDChanged(String userID) {
        if (!userID.equals(ID.getText().toString())) {
            reference.child(userID).child("userID").setValue(ID.getText().toString());
            return true;
        } else {
            return false;
        }
    }

    private boolean isLastChanged(String userID, String LastnameUser) {
        String name = Lname.getText().toString();
        if (name.isEmpty() == false) {
            if (!LastnameUser.equals(Lname.getText().toString())) {
                reference.child(userID).child("lastName").setValue(Lname.getText().toString());
                LastnameUser = Lname.getText().toString();
                return true;
            }
        } else {
            return false;
        }
        return false;
    }


    private boolean isEmailChanged(String userID, String emailUser) {
        String myEmail = email.getText().toString();
        if (myEmail.isEmpty() == false) {
            if (!emailUser.equals(email.getText().toString())) {
                reference.child(userID).child("email").setValue(email.getText().toString());
                emailUser = email.getText().toString();
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    private boolean isPhoneChanged(String userID, String phoneUser) {
        String myPhone = phone.getText().toString();
        if (myPhone.isEmpty() == false) {
            if (!phoneUser.equals(phone.getText().toString())) {
                reference.child(userID).child("phone").setValue(phone.getText().toString());
                phoneUser = phone.getText().toString();
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    private boolean isPasswordChanged(String userID, String passwordUser) {
        String newPassword = pass.getText().toString();
        if (newPassword.isEmpty() == false) {
            if (passwordUser.compareTo(newPassword) != 0) {
                reference.child(userID).child("password").setValue(newPassword);
                passwordUser = newPassword;
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public void showUserData() {

        Intent intent = getIntent();

        String userID = intent.getStringExtra("ID");
        String userFirstName = intent.getStringExtra("FirstName");
        String userLastName = intent.getStringExtra("LastName");
        String userphone = intent.getStringExtra("phone");
        String userEmail = intent.getStringExtra("Email");
        String passwordUser = intent.getStringExtra("password");

        ID.setText(userID);
        ID.setEnabled(false);

    }
}