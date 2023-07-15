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

public class checkProblemVibration extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    private Button BRAKING, ACCELERATION, HIGHER_SPEED;

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
        setContentView(R.layout.activity_check_problem_vibration);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        BRAKING = findViewById(R.id.Braking);
        ACCELERATION = findViewById(R.id.acceleration);
        HIGHER_SPEED = findViewById(R.id.Constantly);
        BRAKING.setOnClickListener(this);
        ACCELERATION.setOnClickListener(this);
        HIGHER_SPEED.setOnClickListener(this);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    @Override
    public void onClick(View v) {
        if (v == BRAKING) {
            Intent I = new Intent(this, vibrationWhenBraking.class);
            startActivity(I);

        } else if (v == ACCELERATION) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t When accelerating from a stop")
                    .setMessage("Description : Loose or Worn suspension components will affect vehicle handling and wheel alignment. Loose wheel bearings and worn bushings can cause vibrations, pulling, and increased tire wear"
                            + "\n\n" + "Case : Loose or Worn Front End Component"
                            + "\n\n" + "Solution  : Suspension Inspection."
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == HIGHER_SPEED) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t When accelerating from a stop")
                    .setMessage("Description : Loose or Worn suspension components will affect vehicle handling and wheel alignment. Loose wheel bearings and worn bushings can cause vibrations, pulling, and increased tire wear"
                            + "\n\n" + "Case : Loose or Worn Front End Component"
                            + "\n\n" + "Solution  : Suspension Inspection."
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : Wheel balance can affect the ride of your vehicle, if the wheels are out of balance you may be experiencing a vibration feeling or vibration noise when driving, and sometimes its even stronger at highway speeds. Wheel balancing is done to compensate for heavy spots of the wheel and tire, if your wheels are bent or chipped this can cause your wheel to be out of balance. Wheel weights are adhered or clipped to the wheel rim to compensate for these differences. Irregular tire wear is also a symptom of a wheel not being balanced"
                            + "\n\n" + "Case : Front Wheels Out of Balance (Wheel Weight Fell Off)"
                            + "\n\n" + "Solution  : Computerized Wheel Balancing."
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : The most common causes of a wheel becoming bent is running into a large object, hitting a curb, or running over a large pothole at a fast speed. "
                            + "\n\n" + "Case : Bent Wheel/Rim "
                            + "\n\n" + "Solution  : Wheel Purchase & Wheel Installation."
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        }
    }
}