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

public class exhaust extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button BLACK, WHITE, BLUE;

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
        setContentView(R.layout.activity_exhaust);
        BLACK = findViewById(R.id.Black);
        WHITE = findViewById(R.id.White);
        BLUE = findViewById(R.id.Blue);
        BLACK.setOnClickListener(this);
        WHITE.setOnClickListener(this);
        BLUE.setOnClickListener(this);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    @Override
    public void onClick(View v) {
        if (v == BLACK) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t\t\t Smoke")
                    .setMessage("Description : Black smoke may mean your engine is burning too much fule or that your fuel return line is clogged. It is important to check your sensors, fuel injectors, and fuel-pressure regulator. To fix the issue and gain better fuel economy, be sure to have your vehicle repaird by an expert."
                            + "\n\n" + "Cause : Engine is burning to much fule"
                            + "\n\n" + "Solution : Engine Diagnostics"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.smoke).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == WHITE) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t\t\t Smoke")
                    .setMessage("Description: White smoke from a car's exhaust is typically caused by the presence of water vapor. It appears as a thick, cloudy white or grayish smoke and may be accompanied by a sweet smell."
                            + "\n\n" + "Cause : Condensation, Coolant Leak and Fuel Injection Issues"
                            + "\n\n" + "Solution : Condensation: No action is necessary as this is a normal occurrence and will usually resolve itself once the engine warms up.\n"
                            + "Coolant Leak: It is important to have a qualified mechanic inspect the vehicle. They can diagnose the specific cause of the leak and perform the necessary repairs, such as replacing the damaged gasket or repairing the engine block.\n"
                            + "Fuel Injection Issues: Consult with a mechanic to diagnose the fuel injection system. They will be able to identify any faulty components and replace or repair them as needed."
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.smoke).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == BLUE) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t\t\t Smoke")
                    .setMessage("Description: Blue smoke emitted from a car's exhaust appears bluish-gray and tends to linger in the air. It often has a distinctive burning oil smell."
                            + "\n\n" + "Cause : Blue smoke in the exhaust is typically a result of oil entering the combustion chamber and being burned along with the fuel. The possible causes include: Oil Leaks and Engine Wear"
                            + "\n\n" + "Solution :  Oil Leaks Identify and repair any oil leaks in the engine. This may involve replacing worn piston rings, valve seals, or repairing the PCV system. A qualified mechanic should perform these repairs.\n"
                            + "Engine Wear: If the blue smoke is a result of engine wear, it may require an engine overhaul or rebuild. In severe cases, an engine replacement might be necessary. Consult with a professional mechanic to assess the extent of the wear and determine the best course of action."
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.smoke).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        }

    }
}