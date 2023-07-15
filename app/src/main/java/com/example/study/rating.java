package com.example.study;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class rating extends AppCompatActivity implements View.OnClickListener {
    private RatingBar rate;
    private Button submit;
    FirebaseDatabase database;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Rating");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        rate = findViewById(R.id.ratingBar);
        submit = findViewById(R.id.Submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == submit) {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("rate");
            Intent intent = getIntent();
            String userID = intent.getStringExtra("ID");
            float myrate = rate.getRating();
            HelperClass helperClass = new HelperClass(userID, myrate);
            reference.child(userID).setValue(helperClass);
            Toast.makeText(this, "Thank you for rating ", Toast.LENGTH_SHORT).show();
        }
    }
}