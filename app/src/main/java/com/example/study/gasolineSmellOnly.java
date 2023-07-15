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

public class gasolineSmellOnly extends AppCompatActivity implements View.OnClickListener , DialogInterface.OnClickListener{
    private Button inside;

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
        setContentView(R.layout.activity_gasoline_smell_only);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        inside = findViewById(R.id.inside);
        inside.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         if (v == inside) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\tInside the vehicle when the heat or A/C is turned on")
                    .setMessage("Description : Clogged fuel injectors are caused by dirt in the fuel system. If dirt gets past the fuel filter and into the fuel injectors, they will become plugged and prevent fuel from reaching the combustion chamber"
                            + "\n\n" + "Cause : Fuel Injector Leak"
                            + "\n\n" + "Solution : Fuel Injection."
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description: Fuel leaks within the fuel pressure regulator unit and a dirty fuel system will cause the fuel pressure regulator to fail"
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