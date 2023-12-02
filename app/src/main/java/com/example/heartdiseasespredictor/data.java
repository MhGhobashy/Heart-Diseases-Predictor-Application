package com.example.heartdiseasespredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class data extends AppCompatActivity {
    ImageView chest1;
    ImageView chest2;
    ImageView chest3;
    ImageView ang;
    ImageView risk;
    ImageView prev;
    ImageView hosp;
    ImageView doc;
    ImageView food;
    ImageView chip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        chest1 = findViewById(R.id.chest1);
        chest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.healthline.com/health/stable-angina#symptoms");
            }
        });
        chest2 = findViewById(R.id.chest2);
        chest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.healthline.com/health/heart/atypical-chest-pain#symptoms");
            }
        });
        chest3 = findViewById(R.id.chest3);
        chest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://my.clevelandclinic.org/health/diseases/15851-gerd-non-cardiac-chest-pain");
            }
        });
        ang = findViewById(R.id.ang);
        ang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.healthline.com/health/heart-disease/problems-during-exercise#warning-signs");
            }
        });
        risk = findViewById(R.id.risk);
        risk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.cdc.gov/heartdisease/risk_factors.htm");
            }
        });
        prev = findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.cdc.gov/heartdisease/prevention.htm");
            }
        });
        hosp = findViewById(R.id.hosp);
        hosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.lyfboat.com/hospitals/cardiology-hospitals-and-costs-in-egypt/");
            }
        });
        doc = findViewById(R.id.doc);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.vezeeta.com/en/doctor/cardiology/egypt");
            }
        });
        food = findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.nhlbi.nih.gov/health/heart-healthy-living/healthy-foods");
            }
        });
        chip = findViewById(R.id.chip);
        chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.shiksha.com/online-courses/articles/understanding-multilayer-perceptron-mlp-neural-networks/");
            }
        });
    }





    private void goLink(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
