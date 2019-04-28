package com.example.residentcheckin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

        private Button btnNext;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Button btnSearch = (Button) findViewById(R.id.btnSearch);
            Button btnNext = (Button) findViewById(R.id.btnNext);


            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }

    public void onClick(View v) {
        Intent myIntent = new Intent(getBaseContext(), VerifyStatus.class);
        startActivity(myIntent);
    }
}