package com.example.residentcheckin;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
