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

public class exhaustSmeel extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    private Button INSIDE, OUTSIDE;

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
        setContentView(R.layout.activity_exhaust_smeel);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        INSIDE = findViewById(R.id.inside);
        OUTSIDE = findViewById(R.id.outside);
        INSIDE.setOnClickListener(this);
        OUTSIDE.setOnClickListener(this);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    @Override
    public void onClick(View v) {
        if (v == INSIDE) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t Exhaust")
                    .setMessage("Description : The exhaust manifold carries the combustion gasses from the engine to the exhaust. The exhaust manifold becomes extremely hot because of engine combustion. The constant heating and cooling of the exhaust manifold can cause it to crack or wear the gasket down over time causing it to leak."
                            + "\n\n" + "Cause : Exhaust Manifold Gasket Leak"
                            + "\n\n" + "Solution : Manifold Replacement."
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : The constant heating and cooling of the exhaust manifold can cause leaks. You may catch a small crack before it becomes large enough to make a noise and become a more serious problem."
                            + "\n\n" + "Case :  Exhaust Leak (Front Pipe)"
                            + "\n\n" + "Solution : Exhaust Inspection."
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == OUTSIDE) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t Exhaust")
                    .setMessage("Description : The constant heating and cooling of the exhaust manifold can cause leaks. You may catch a small crack before it becomes large enough to make a noise and become a more serious problem."
                            + "\n\n" + "Cause : Exhaust System Leak"
                            + "\n\n" + "Solution : Exhaust Inspection"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        }
    }
}