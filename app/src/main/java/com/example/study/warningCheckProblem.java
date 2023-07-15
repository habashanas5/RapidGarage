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

public class warningCheckProblem extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button CHECK, TIER, TEMPERATURE, BATTERY, OIL, BRAKE, ABS, CHECKENGINE;

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
        setContentView(R.layout.activity_warning_check_problem);
        CHECK = findViewById(R.id.EngineLight);
        TIER = findViewById(R.id.Tire);
        TEMPERATURE = findViewById(R.id.Temperature);
        BATTERY = findViewById(R.id.Battery);
        OIL = findViewById(R.id.Oil);
        BRAKE = findViewById(R.id.Brake);
        ABS = findViewById(R.id.ABS);
        CHECKENGINE = findViewById(R.id.checkEngineNumber);
        CHECK.setOnClickListener(this);
        TIER.setOnClickListener(this);
        TEMPERATURE.setOnClickListener(this);
        BATTERY.setOnClickListener(this);
        OIL.setOnClickListener(this);
        BRAKE.setOnClickListener(this);
        ABS.setOnClickListener(this);
        CHECKENGINE.setOnClickListener(this);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);

    }

    @Override
    public void onClick(View v) {
        if (v == CHECK) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Warning light is on")
                    .setMessage("Description : When your vehicle's Check Engine Light comes on, it is important to seek service quickly to prevent damage to your engine."
                            + "\n\n" + "Cause : Check Engine Light (Fault Codes) "
                            + "\n\n" + "Solution : Dashboard Warning Diagnostic"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.checkenginelight).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == TIER) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Warning light is on")
                    .setMessage("Description : Tire pressure plays an important role in vehicle preformance. If your tire pressure is uneven or low, the vehicle may handle poorly and will lose fuel economy. If the tires are overinflated , the vehicle will not ride smoothly. Both underinflated and overinflated tires contribute to prematurely worn tires. Environmental factors such as temperature change may affect tire pressure, as well. Make sure to check tire pressure regularly.  "
                            + "\n\n" + "Cause : Incorrect Tire Pressure"
                            + "\n\n" + "Solution : Dashboard Warning Diagnostic"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.tire).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();


        } else if (v == TEMPERATURE) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Warning light is on")
                    .setMessage("Description : Your vehicle's thermostat controls the amount of coolant released to the engine. If the thermostat is stuck closed, your vehicle will not receive the proper amount of coolant it needs, and may overheat. It is necessary to replace a stuck thermostat immediately. "
                            + "\n\n" + "Cause : Stuck Thermostat"
                            + "\n\n" + "Solution : Dashboard Warning Diagnostic"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.temp).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == BATTERY) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Warning light is on")
                    .setMessage("Description : The serpentine belt helps run the motors and pumps that make sure your vehicle is running smoothly. It is important to replace a damaged or loose serpentine belt, as it may cause your vehicle to stall, steering to tighten up, or your vehicle to overheat. "
                            + "\n\n" + "Cause : Serpentine Belt Slipping/Damaged"
                            + "\n\n" + "Solution : Dashboard Warning Diagnostic"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.battery).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == OIL) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Warning light is on")
                    .setMessage("Description : An oil pump should last the life of you engine, but may become prematurely worn over time. If your vehicle's oil pressure is low even thougt the oil level is high, this is a sign the oil pump may need replacement"
                            + "\n\n" + "Cause : Worn Oil Pump "
                            + "\n\n" + "Solution : Dashboard Warning Diagnostic"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.oil).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == BRAKE) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Warning light is on")
                    .setMessage("Description : The brake switch may cause the warning light to come on if it is damaged or stuck."
                            + "\n\n" + "Cause : Faulty Parking Brake Switch "
                            + "\n\n" + "Solution : Dashboard Warning Diagnostic"
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : If your vehicle's Brake Warning Light is on and your emergency brake is released, your brakes may have lost pressure. Your vehicle is dangerous if the brake are not working properly. It is important to check brake pressure when your brake warning light comes on."
                            + "\n\n" + "Cause : Loss of Brake Pressure "
                            + "\n\n" + "Solution : Dashboard Warning Diagnostic"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.brake).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == ABS) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Warning light is on")
                    .setMessage("Description : If there is a fault in the ABS system, the vehicle will still brake, however there may be a loss of power-assist. This situation is very unsafe, and the faulty ABS system should be repaired immediately."
                            + "\n\n" + "Cause : ABS System Fault "
                            + "\n\n" + "Solution : Dashboard Warning Diagnostic"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.abs).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == CHECKENGINE) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Warning light is on")
                    .setMessage("Description : Check Engine Light on with code P0382 or P0400 through P0408 means there is an issue with your vehicle's exhaust gas recirculation flow."
                            + "\n\n" + "Cause : Check Engine Light On (EGR Valve) "
                            + "\n\n" + "Solution : Dashboard Warning Diagnostic"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}