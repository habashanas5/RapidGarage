package com.example.study;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class smokeForCheckProblem extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button ENGINE, EXHAUST;

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
        setContentView(R.layout.activity_check_problem_see_smoke);
        ENGINE = findViewById(R.id.Engine);
        EXHAUST = findViewById(R.id.Exhaust);
        ENGINE.setOnClickListener(this);
        EXHAUST.setOnClickListener(this);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
    }

    @Override
    public void onClick(View v) {
        if (v == ENGINE) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t\t\t Smoke")
                    .setMessage("Description : Your vehicle's radiator may begin to leak due to normal wear. Failure may happen if coolant goes unserviced, if the vehicle suffers collision damage , or if the vehicle overheats. It is important to regularly maintain the cooling system to prolong the life of the radiator."
                            + "\n\n" + "Cause : Coolant Leak"
                            + "\n\n" + "Solution : Cooling System Flush & Fill"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.enginesmoke).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == EXHAUST) {
            Intent I = new Intent(this,exhaust.class);
            startActivity(I);
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}