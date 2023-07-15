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

public class checkProblemSee extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button SMOKE, TIRE, WARNING, LEAK;

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
        setContentView(R.layout.activity_check_problem_see);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        SMOKE = findViewById(R.id.smook);
        TIRE = findViewById(R.id.tire);
        WARNING = findViewById(R.id.warning);
        LEAK = findViewById(R.id.leak);
        SMOKE.setOnClickListener(this);
        TIRE.setOnClickListener(this);
        WARNING.setOnClickListener(this);
        LEAK.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == LEAK) {
            Intent I = new Intent(this, pubbleForCheckProblem.class);
            startActivity(I);

        } else if (v == WARNING) {
               Intent I = new Intent(this , warningCheckProblem.class);
               startActivity(I);

        } else if (v == TIRE) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t Tire looks flat")
                    .setMessage("Description : A flat tire can happen at any time ,Knowing how to change your tire and keeping a regular check on your spare , checking the pressure and quality of the spare , can wind up saving you time , money , and aggravation . Keeping a tire plug kit in your vehicle is also a good way to be prepared in case of a flat . Tire plug kits are inexpensive and can be a life saver on long trips , they come in professional and emergecy kits , its a good idea to keep one in your  trunk or golve box "
                            + "\n\n" + "Case : punctured Tire"
                            + "\n\n" + "Solution  : vehicle idel fluctuation , hard , brake pedal , and a hissnig noise  heard under the hood."
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description: A vacuum is responsible for drawing air into the cylinders. It is also responsible for the operation of emission system, braking system, and cruise control system components. Vacuum is transferred through a complex system of rubber hoses and/or plastic tubes. The engine creates a great deal of heat and over time can cause the rubber and plastic hoses to dry out and leak. A vacuum leak can be elusive and take a long time to detect. Common symptoms of a vacuum leak include"
                            + "\n\n" + "Case: Damaged valve stem"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.baseline_tire_repair_24).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == SMOKE) {
            Intent I = new Intent(this, smokeForCheckProblem.class);
            startActivity(I);
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}