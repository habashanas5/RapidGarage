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

public class AntifreezeSmeel extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button HEATERON, WARMEDUP;

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
        setContentView(R.layout.activity_antifreeze_smeel);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        HEATERON = findViewById(R.id.heater);
        WARMEDUP = findViewById(R.id.warmed);
        HEATERON.setOnClickListener(this);
        WARMEDUP.setOnClickListener(this);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    @Override
    public void onClick(View v) {
        if (v == HEATERON) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t Antifreeze")
                    .setMessage("Description : A heater core is a small scaled down version of the radiator in the front of your vehicle. The heater core is located inside your vehicle in the dash on the passenger side inside of the blower case. They can wear down over time from heat expansion and corrosion. If your windows are fogging up when you put on the defroster there is a good chance the heater core is to blame. A small leak in the heater core will give off steam that can cause your windows to fog and is usually accompanied with a sweet coolant /antifreeze smell."
                            + "\n\n" + "Cause : Leaking Heater Core"
                            + "\n\n" + "Solution : Heating System Service."
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == WARMEDUP) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t Antifreeze")
                    .setMessage("Description : The Radiator will leak after normal wear."
                            + "\n\n" + "Cause : Coolant Leak (smoke)"
                            + "\n\n" + "Solution : however, failure may result if coolant is left unserviced, collision damage, or having the vehicle overheat. To prolong the life of the radiator, perform periodic maintenance on the coolant system."
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        }

    }
}