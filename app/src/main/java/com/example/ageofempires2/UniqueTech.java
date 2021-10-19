package com.example.ageofempires2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class UniqueTech extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unique_tech);
        getSupportActionBar().setTitle("Unique Technology");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}