package com.example.residentcheckin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CurrentStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_status);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);



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

