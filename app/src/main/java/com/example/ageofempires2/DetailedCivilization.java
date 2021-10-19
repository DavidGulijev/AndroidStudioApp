package com.example.ageofempires2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DetailedCivilization extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_civilization);
        getSupportActionBar().setTitle("Detailed view");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button changeActivityTech = findViewById(R.id.tech_button);
        Button changeActivityUnit = findViewById(R.id.unit_button);
        changeActivityTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTech();
            }
        });
        changeActivityUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityUnit();
            }
        });
    }
    private void activityTech(){
        Intent intent = new Intent(this, UniqueTech.class);
        startActivity(intent);
    }
    private void activityUnit(){
        Intent intent = new Intent(this, UniqueUnit.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}