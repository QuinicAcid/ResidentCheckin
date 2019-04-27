package com.example.residentcheckin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn;
    Button btn2;
    EditText edtTxt;
    String st;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btnSearch);
        Button button2;
        button2 = (Button) findViewById(R.id.btnNext);
        button.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),VerifyStatus.class);
                startActivity(i);

                setContentView(R.layout.activity_main);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myintent2 = new Intent(MainActivity.this,Button.class);
                startActivity(myintent2);

            }
        });


    }

}
