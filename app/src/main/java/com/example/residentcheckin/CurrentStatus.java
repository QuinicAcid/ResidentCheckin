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

        Button back = (Button) findViewById(R.id.btnSearch);
        Button next;
        next = (Button) findViewById(R.id.btnNext);
        next.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Status.class);
                startActivity(i);

                setContentView(R.layout.activity_main);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myintent2 = new Intent(CurrentStatus.this,Button.class);
                startActivity(myintent2);

            }
        });

    }
}
