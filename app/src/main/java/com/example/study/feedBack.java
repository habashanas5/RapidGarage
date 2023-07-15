package com.example.study;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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

public class feedBack extends AppCompatActivity implements View.OnClickListener {
    private EditText edit_Text_For_ID, edit_Text_For_Notes;
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
        setContentView(R.layout.activity_feed_back);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("FeedBack");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        edit_Text_For_ID = findViewById(R.id.Text_for_Id);
        edit_Text_For_Notes = findViewById(R.id.Edit_for_note);
        submit = findViewById(R.id.btnsend);
        submit.setOnClickListener(this);
        Intent intent = getIntent();
        String userID = intent.getStringExtra("ID");
        edit_Text_For_ID.setText(userID);
        edit_Text_For_ID.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        if (v == submit) {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("feedback");
            String id = edit_Text_For_ID.getText().toString();
            String note = edit_Text_For_Notes.getText().toString();
            HelperClass helperClass = new HelperClass(id , note);
            reference.child(id).setValue(helperClass);
            Toast.makeText(this, "Thank you for the feedback!", Toast.LENGTH_LONG).show();

        }
    }
}