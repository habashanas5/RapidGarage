package com.example.study;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class setting extends AppCompatActivity implements View.OnClickListener {
    private Button UPDATE, UPLOADE, CALL, MAIL, ABOUT, FREQUENT;


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
        setContentView(R.layout.activity_setting);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Setting");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        UPDATE = findViewById(R.id.update_info);
        UPLOADE = findViewById(R.id.update_image);
        CALL = findViewById(R.id.Call);
        MAIL = findViewById(R.id.Mail);
        ABOUT = findViewById(R.id.about);
        FREQUENT = findViewById(R.id.frequent_questions);
        UPDATE.setOnClickListener(this);
        UPLOADE.setOnClickListener(this);
        CALL.setOnClickListener(this);
        MAIL.setOnClickListener(this);
        ABOUT.setOnClickListener(this);
        FREQUENT.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == UPDATE) {
            Intent intent = getIntent();
            String userID = intent.getStringExtra("ID");
            String userFirstName = intent.getStringExtra("FirstName");
            String userLastName = intent.getStringExtra("LastName");
            String userType = intent.getStringExtra("password");
            String userphone = intent.getStringExtra("phone");
            String userEmail = intent.getStringExtra("Email");
            sendToEdit(userID,userFirstName ,userLastName , userType ,userphone ,userEmail );

        } else if (v == UPLOADE) {

        } else if (v == CALL) {
            SendToCallUs();

        } else if (v == MAIL) {
            SendToMailUs();

        } else if (v == ABOUT) {
            SendTOAbout();

        } else if (v == FREQUENT) {
            SendToFrequent();
        }
    }

    public void SendToMailUs() {
        Intent email = new Intent(Intent.ACTION_SEND);
        String[] Recepion = {"habashanas716@gmail.com"};
        email.setData(Uri.parse("mailto: habashanas716@gmail.com"));
        email.putExtra(email.EXTRA_EMAIL, Recepion);
        email.putExtra(Intent.EXTRA_SUBJECT, "Urgent email");
        email.putExtra(email.EXTRA_BCC, "habashanas716@gmail.com");
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Send Email"));
    }

    public void SendToCallUs() {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:0595497329"));
        startActivity(call);
    }

    public void SendTOAbout(){
        Intent I = new Intent(this,about.class);
        startActivity(I);
    }

    public void SendToFrequent(){
        Intent I = new Intent(this , frequent.class);
        startActivity(I);
    }

    public void sendToEdit(String ID , String userFirstName , String userLastName , String userType , String userphone , String userEmail) {
        Intent Edit = new Intent(this , EditProfile.class);
        Edit.putExtra("ID", ID);
        Edit.putExtra("FirstName" , userFirstName);
        Edit.putExtra("LastName" , userLastName);
        Edit.putExtra("password" , userType);
        Edit.putExtra("phone" , userphone);
        Edit.putExtra("Email" , userEmail);
        startActivity(Edit);
    }
}

