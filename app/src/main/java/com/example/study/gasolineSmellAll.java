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

public class gasolineSmellAll extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button Engine, Rear;

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
        setContentView(R.layout.activity_gasoline_smell_all);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        Engine = findViewById(R.id.Engine);
        Rear = findViewById(R.id.Rear);
        Engine.setOnClickListener(this);
        Rear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == Rear) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Engine Compartment")
                    .setMessage("Description : It typically indicates the back part of the car, including the trunk or cargo area."
                            + "\n\n" + "Cause : The foul smell in the rear of the vehicle can have various causes, including: Spilled liquids, Mold or mildew, Animal presence, Exhaust fumes"
                            + "\n\n" + "Solution : Clean and deodorize, Check for leaks, Remove any pests, Exhaust system inspection ."
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == Engine) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Engine Compartment")
                    .setMessage("Description : Clogged fuel injectors are caused by dirt in the fuel system. If dirt gets past the fuel filter and into the fuel injectors, they will become plugged and prevent fuel from reaching the combustion chamber"
                            + "\n\n" + "Cause : Fuel Injector Leak"
                            + "\n\n" + "Solution : Fuel Injection."
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description:  If you are experiencing a foul smell coming from the rear of your vehicle, it could be an indication of a problem in the exhaust system or the fuel system. The smell can vary but is often described as a strong, pungent odor."
                            + "\n\n" + "Cause : Fuel Rail/Fuel Pressure Regulator Leak"
                            + "\n\n" + "Solution : Fuel Injection."
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