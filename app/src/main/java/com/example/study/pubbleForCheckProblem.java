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

public class pubbleForCheckProblem extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button OIL, AUTOMATIC, POWER, COOLANT;

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
        setContentView(R.layout.activity_pubble_for_check_problem);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        OIL = findViewById(R.id.oil);
        AUTOMATIC = findViewById(R.id.Automatic);
        POWER = findViewById(R.id.Power);
        COOLANT = findViewById(R.id.Coolant);
        OIL.setOnClickListener(this);
        AUTOMATIC.setOnClickListener(this);
        POWER.setOnClickListener(this);
        COOLANT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == OIL) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Puddle or leak")
                    .setMessage("Description : Valve cover gaskets are subject to normal wear and tear which may cause leaks. An overly hot engine may also cause the valve cover to break."
                            + "\n\n" + "Cause : Leaking Valve Covers "
                            + "\n\n" + "Solution : Engine Tune-Up"
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : Oil filters may leak due to improper installation or from regular wear"
                            + "\n\n" + "Cause : Leaking Oil Filter"
                            + "\n\n" + "Solution : Lube and Oil Change "
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.leak).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == AUTOMATIC) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Puddle or leak")
                    .setMessage("Description : Transmission cooler lines may become loose and leak at radiator fittings due to regular vibrations."
                            + "\n\n" + "Cause : Leaking Transmission Lines "
                            + "\n\n" + "Solution : Automatic Transmission Repair"
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : Transmission fluid must be regularly replaced. Regular maintenance will help prevent tasks"
                            + "\n\n" + "Cause : Leaking Transmission Pan Gasket"
                            + "\n\n" + "Solution : Automatic Transmission Repair"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.leak).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == POWER) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Puddle or leak")
                    .setMessage("Description : It is common for power steering hoses to leak or malfunction from regular wear"
                            + "\n\n" + "Cause : Leaking Power Steering Hose"
                            + "\n\n" + "Solution : Steering and Suspension System"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.leak).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == COOLANT) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Puddle or leak")
                    .setMessage("Description : A leak may occur from failing components in the cooling system"
                            + "\n\n" + "Cause : Leaking Water Pump "
                            + "\n\n" + "Solution : Cooling System Repair"
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : Normal heating and cooling will cause the radiator hoses to become brittle and crack or leak"
                            + "\n\n" + "Cause : Leaking Radiator Hose"
                            + "\n\n" + "Solution : null "
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : The radiator may leak due to regular wear and tear. If the vehicle overheats or if coolant goes unmaintained, the radiator may also begin to leak or malfunction. Regular maintenance is necessary."
                            + "\n\n" + "Cause : Leaking Radiator and Cap"
                            + "\n\n" + "Solution : Cooling System Repair "
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.leak).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}