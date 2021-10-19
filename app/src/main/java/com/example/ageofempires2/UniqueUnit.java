package com.example.ageofempires2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class UniqueUnit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unique_unit);
        getSupportActionBar().setTitle("Unique Unit");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}