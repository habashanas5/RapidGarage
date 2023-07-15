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

public class checkProblemSmeel extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    private Button GASOLINE, ROTTEN, MILDEW, SWEET, BURNING, EXHAUST;

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
        setContentView(R.layout.activity_check_problem_smeel);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Manual Diagnostic");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        GASOLINE = findViewById(R.id.Gasoline);
        ROTTEN = findViewById(R.id.Rotten);
        MILDEW = findViewById(R.id.Mildew);
        BURNING = findViewById(R.id.Burning);
        EXHAUST = findViewById(R.id.Exhaust);
        SWEET = findViewById(R.id.Antifreeze);
        GASOLINE.setOnClickListener(this);
        ROTTEN.setOnClickListener(this);
        MILDEW.setOnClickListener(this);
        BURNING.setOnClickListener(this);
        EXHAUST.setOnClickListener(this);
        SWEET.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == GASOLINE) {
            Intent I = new Intent(this,gasolineSmell.class);
            startActivity(I);

        } else if (v == ROTTEN) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t Rotten eggs")
                    .setMessage("Description : Description Extreme heat, under-tuned engine, and normal wear will cause the inside of the converter to break down and fall apart. Replacement is recommended."
                            + "\n\n" + "Cause : Catalytic Converter Failure"
                            + "\n\n" + "Solution : however, it may not be enough to warn of other possible problems. Solving It can be as routine as an engine tune-up or needing further diagnosis if not easily traced."
                            + "\n\n" + "-----------------------"
                            + "\n\n" + "Description : Multiple problems can cause a rich fuel mixture, which may be simple to address or more complex to diagnose. The check engine light is normally the first indicator in the line of defense Cause"
                            + "\n\n" + "Case : Rich Fuel Condition"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == MILDEW) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t\t Mildew")
                    .setMessage("Description : Debris in your cabin air filter can build up multiple ways. If the vehicle has gone a long time without replacing the filter, then normal build up of dust and dirt is common. If you have been driving through dusty terrain, off-roading, highways chances are there is an excess of dust in the air going into the filter."
                            + "\n\n" + "Cause : A/C Vents (Foul Smell)"
                            + "\n\n" + "Solution : Air Conditioning System Service."
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == BURNING) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("\t\t\t\t\t\t\t Burning oil")
                    .setMessage("Description : Valve cover gaskets may begin to leak from normal wear and overheating of the engine. Most are constructed of rubber and others are cork. Excessive heating and cooling will eventually harden the materials and make them crack. Oil pressure and oil flow will leak out through small cracks that develop. Oil can also leak into the spark plugs causing the engine to misfire."
                            + "\n\n" + "Cause : Engine Oil Leak (Odor)"
                            + "\n\n" + "Solution : Engine Tune-Up"
                            + "\n\n" + "-----------------------" + "\n")
                    .setIcon(R.drawable.myimage).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == EXHAUST) {
            Intent I = new Intent(this,exhaustSmeel.class);
            startActivity(I);

        } else if (v == SWEET) {
            Intent I = new Intent(this,AntifreezeSmeel.class);
            startActivity(I);

        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
