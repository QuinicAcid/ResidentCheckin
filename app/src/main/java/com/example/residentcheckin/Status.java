package com.example.residentcheckin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Status extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Button back = (Button) findViewById(R.id.btnBack);
        Button locker = (Button) findViewById(R.id.btnLocker);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                finish();
            }

        });
        locker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0){}


        });

    }
}