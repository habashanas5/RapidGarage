package com.example.study;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vibrationWhenBraking extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button WHEEL, SEATS, NOTSURE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration_when_braking);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        WHEEL = findViewById(R.id.Wheel);
        SEATS = findViewById(R.id.seats);
        NOTSURE = findViewById(R.id.NOTSure);
        WHEEL.setOnClickListener(this);
        SEATS.setOnClickListener(this);
        NOTSURE.setOnClickListener(this);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    @Override
    public void onClick(View v) {
        if (v == WHEEL) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t Through the steering wheel")
                    .setMessage("Description : Loose or Worn suspension components will affect vehicle handling and wheel alignment. Loose wheel bearings and worn bushings can cause vibrations, pulling, and increased tire wear"
                            + "\n\n" + "Case : Loose or Worn Front End Component"
                            + "\n\n" + "Solution  : Suspension Inspection."
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : A warped brake rotor can be caused by excessive heat or improper wheel lug nut torque. If you feel a pulsation or vibration in the brake pedal , check the rotors for runout and parallelism is normal on vehicles with ABS when ABS is working."
                            + "\n\n" + "Cause : Warped Brake Rotors "
                            + "\n\n" + "Solution : Brake Rotor Replacement"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == SEATS) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t Through the seats")
                    .setMessage("Description : Out of round brake drums are often caused by extreme temperature changes during normal braking. An out of round brums may look okay to the naked eye, but it can cause gabbing, pulling, and pedal pulsations."
                            + "\n\n" + "Cause : Out of round brake drums "
                            + "\n\n" + "Solution : Rear Drum Brake Repair "
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == NOTSURE) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t When accelerating from a stop")
                    .setMessage("Description : A warped brake rotor can be caused by excessive heat or improper wheel lug nut torque. If you feel a pulsation or vibration in the brake pedal , check the rotors for runout and parallelism is normal on vehicles with ABS when ABS is working."
                            + "\n\n" + "Cause : Warped Brake Rotors "
                            + "\n\n" + "Solution : Brake Rotor Replacement"
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : Out of round brake drums are often caused by extreme temperature changes during normal braking. An out of round brums may look okay to the naked eye, but it can cause gabbing, pulling, and pedal pulsations."
                            + "\n\n" + "Cause : Out of round brake drums "
                            + "\n\n" + "Solution : Rear Drum Brake Repair "
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : Loose or Worn suspension components will affect vehicle handling and wheel alignment. Loose wheel bearings and worn bushings can cause vibrations, pulling, and increased tire wear."
                            + "\n\n" + "Cause : Loose or Worn Front End Component "
                            + "\n\n" + "Solution : Suspension Inspection"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        }

    }
}