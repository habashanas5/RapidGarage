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

public class checkProblemFeel extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    private Button DRIFTS, EXCESSIVE, PULLS, PULSATION, SHIMMY, SWAY, VIBRATION;

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
        setContentView(R.layout.activity_check_problem_feel);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        DRIFTS = findViewById(R.id.Drifts);
        EXCESSIVE = findViewById(R.id.Excessive);
        PULLS = findViewById(R.id.Pulls);
        PULSATION = findViewById(R.id.Pulsation);
        SHIMMY = findViewById(R.id.Shimmy);
        SWAY = findViewById(R.id.Sway);
        VIBRATION = findViewById(R.id.Vibration);
        DRIFTS.setOnClickListener(this);
        EXCESSIVE.setOnClickListener(this);
        PULLS.setOnClickListener(this);
        PULSATION.setOnClickListener(this);
        SHIMMY.setOnClickListener(this);
        SWAY.setOnClickListener(this);
        VIBRATION.setOnClickListener(this);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    @Override
    public void onClick(View v) {
        if (v == DRIFTS) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t\t\t Drifts")
                    .setMessage("Description : Loose or Worn suspension components will affect vehicle handling and wheel alignment. Loose wheel bearings and worn bushings can cause vibrations, pulling, and increased tire wear."
                            + "\n\n" + "Cause : Loose or Worn Front End Component "
                            + "\n\n" + "Solution : Suspension Inspection"
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : Tire pressure is often overlooked, but it directly influences how a vehicle rides on the road. Low tire pressure can affect handling, ride, and fuel economy. Over inflating tires can cause the vehicle to ride hard, and the tires to wear prematurely. Temperature directly affects tire pressure, check the pressure regularly."
                            + "\n\n" + "Cause : Uneven Tire Pressure "
                            + "\n\n" + "Solution : TPMS Repair "
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : A wheel alignment is very. important, it keeps the vehicle running smooth and makes sure all the parts of the steering and suspension are working together. When the vehicle is out of alignment it can put stress on other components of the steering and suspension and cause them to wear faster. There are also safety concerns when a vehicle is improperly aligned. When you have suspension related parts replaced you should ask your technician if the vehicle. needs to be aligned."
                            + "\n\n" + "Cause : Wheels Out Of Alignment "
                            + "\n\n" + "Solution : Four-Wheel Alignment "
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == EXCESSIVE) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Excessive play")
                    .setMessage("Description : Tie rod ends are part of the steering system, tie rods are responsible for wheel alignment toe, and steering. Worn tie rod ends can cause abnormal tire wear, front and noise , and wheel shimmy or looseness in steering "
                            + "\n\n" + "Case : Loose/Worn Tie Rod Ends"
                            + "\n\n" + "Solution  : Inner Tie Rod & Outer Tie Rod."
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == PULLS) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t\t\t Pulls")
                    .setMessage("Description : Loose or Worn suspension components will affect vehicle handling and wheel alignment. Loose wheel bearings and worn bushings can cause vibrations, pulling, and increased tire wear."
                            + "\n\n" + "Cause : Loose or Worn Front End Component "
                            + "\n\n" + "Solution : Suspension Inspection"
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : Brake calipers will usually bind on the slides from being improperly lubed or overly dirty. Gunk builds up on the slides and will not allow the caliper to press together, preventing the pads. from stopping the rotor from spinning."
                            + "\n\n" + "Cause : Dragging Front Brake "
                            + "\n\n" + "Solution : Front Disc Brake Repair "
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : Tire pressure is often overlooked, but it directly influences how a vehicle rides on the road. Low tire pressure can affect handling, ride, and fuel economy. Over inflating tires can cause the vehicle to ride hard, and the tires to wear prematurely. Temperature directly affects tire pressure, check the pressure regularly."
                            + "\n\n" + "Cause : Uneven Tire Pressure "
                            + "\n\n" + "Solution : TPMS Repair "
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : A wheel alignment is very. important, it keeps the vehicle running smooth and makes sure all the parts of the steering and suspension are working together. When the vehicle is out of alignment it can put stress on other components of the steering and suspension and cause them to wear faster. There are also safety concerns when a vehicle is improperly aligned. When you have suspension related parts replaced you should ask your technician if the vehicle. needs to be aligned."
                            + "\n\n" + "Cause : Wheels Out Of Alignment "
                            + "\n\n" + "Solution : Four-Wheel Alignment "
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == PULSATION) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t\t\t Pulsation")
                    .setMessage("Description : A warped brake rotor can be caused by excessive heat or improper wheel lug nut torque. If you feel a pulsation or vibration in the brake pedal , check the rotors for runout and parallelism is normal on vehicles with ABS when ABS is working."
                            + "\n\n" + "Cause : Warped Brake Rotors "
                            + "\n\n" + "Solution : Brake Rotor Replacement"
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : Out of round brake drums are often caused by extreme temperature changes during normal braking. An out of round brums may look okay to the naked eye, but it can cause gabbing, pulling, and pedal pulsations."
                            + "\n\n" + "Cause : Out of round brake drums "
                            + "\n\n" + "Solution : Rear Drum Brake Repair "
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == SHIMMY) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t\t\t Shimmy")
                    .setMessage("Description : Loose or Worn suspension components will affect vehicle handling and wheel alignment. Loose wheel bearings and worn bushings can cause vibrations, pulling, and increased tire wear"
                            + "\n\n" + "Case : Loose or Worn Front End Component"
                            + "\n\n" + "Solution  : Suspension Inspection."
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == SWAY) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t\t\t Sway")
                    .setMessage("Description : Loose or Worn suspension components will affect vehicle handling and wheel alignment. Loose wheel bearings and worn bushings can cause vibrations, pulling, and increased tire wear."
                            + "\n\n" + "Cause : Loose or Worn Front End Component "
                            + "\n\n" + "Solution : Suspension Inspection"
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : hocks control stability when driving and also reduce impact of the road to the rest of the vehicle. Bad shocks can add stress to other suspension parts. Shocks are the most important regular service item in your suspension, regular replacement of your vehicles shocks, because they do wear down over time, can keep other suspension components stronger longer."
                            + "\n\n" + "Cause : Worn Out Shocks/Struts  "
                            + "\n\n" + "Solution : Shocks Replacement "
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == VIBRATION) {
            Intent I = new Intent(this, checkProblemVibration.class);
            startActivity(I);

        }
    }
}