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

public class frequent extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button services, work, problem, adv, language, problem1;

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
        setContentView(R.layout.activity_frequent);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Frequent Questions");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        services = findViewById(R.id.service);
        work = findViewById(R.id.work);
        problem = findViewById(R.id.problem);
        problem1 = findViewById(R.id.problem1);
        adv = findViewById(R.id.advantages);
        language = findViewById(R.id.language);
        services.setOnClickListener(this);
        work.setOnClickListener(this);
        problem.setOnClickListener(this);
        adv.setOnClickListener(this);
        language.setOnClickListener(this);
        problem1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == language) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("What language is used to build Rapid Garage application?")
                    .setMessage("language used in Rapid Garage is: java ")
                    .setIcon(R.drawable.baseline_question_mark_24).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == services) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("What services does the application provide?")
                    .setMessage("* The nearest auto technician to repair the car "+
                            "\n* The nearest car technician specialized in car electrics " +
                            "\n* The nearest car technician specialized in car parts " +
                            "\n* Provides you with a map " +
                            "\n* Provides you with the nearest car wash "+
                            "\n* Provides you with the nearest gas station ")
                    .setIcon(R.drawable.baseline_question_mark_24).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == adv) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("What are the advantages of this app?")
                    .setMessage("* User-Friendly Interface " +
                            "\n* Reliable and Trustworthy " +
                            "\n* Speed and Efficiency" +
                            "\n* Accurate and Up-to-Date Information" +
                            "\n* Scalable and Maintainable"
                    )
                    .setIcon(R.drawable.baseline_question_mark_24).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == problem) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("What problems does Rapid Garage solve?")
                    .setMessage("Have you ever encountered a problem while driving your car? Or do you want to do maintenance for your car and do not know where to go? This idea of having a driver garage assisted application and website came as a savior for drivers and garages. There is no need to contact family and friends to ask for help after today, we will solve the problem!"
                            + "\nAnother problem that drivers suffer from is the routine repairs that cars need. The driver wonders What type of garage is suitable for my car? and wonders if this garage is available, or if this service is available in it. In most cases, drivers do not have enough experience to know the problem that their car suffers from.")
                    .setIcon(R.drawable.baseline_question_mark_24).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == work) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("How does the Rapid Garage work?")
                    .setMessage("This application is linked to a wide range of local garages, car washes, and gas stations so that you can find out everything you need for your car with just one click.")
                    .setIcon(R.drawable.baseline_question_mark_24).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        } else if (v == problem1) {
            AlertDialog x = new AlertDialog.Builder(this)
                    .setTitle("What are the problems with the Rapid Garage application?")
                    .setMessage("* Limited Coverage " +
                            "\n* Dependance on Internet Connection " +
                            "\n* Inaccurate Information: While the application is designed to provide accurate information, there is a possibility that a garage owner fills inaccurate information.")
                    .setIcon(R.drawable.baseline_question_mark_24).setCancelable(true)
                    .setPositiveButton("yes", this).create();
            x.show();

        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}