package com.example.residentcheckin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CurrentStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_status);

        Button back = (Button) findViewById(R.id.btnBack);
        Button next = (Button) findViewById(R.id.btnNext);

        next =(Button)findViewById(R.id.btnNext);

        next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent myIntent = new Intent(CurrentStatus.this, Status.class);

                CurrentStatus.this.startActivity(myIntent);
            }
        });
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                finish();
            }

        });

    }}

