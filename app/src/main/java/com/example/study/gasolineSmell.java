package com.example.study;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gasolineSmell extends AppCompatActivity implements View.OnClickListener {
    private Button ALL, ONLY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasoline_smell);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        ALL = findViewById(R.id.AllTheTime);
        ONLY = findViewById(R.id.only);
        ALL.setOnClickListener(this);
        ONLY.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == ONLY) {
            Intent I = new Intent(this , gasolineSmellOnly.class);
            startActivity(I);

        } else if (v == ALL) {
            Intent I = new Intent(this , gasolineSmellAll.class);
            startActivity(I);
        }

    }
}