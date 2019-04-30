package com.example.residentcheckin;

import android.Manifest;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.ResidentCheckin.MESSAGE";

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create object of listview
        listView=(ListView)findViewById(R.id.listview);

        //create ArrayList of String
        ArrayList<String> arrayList=new ArrayList<>();

        //Add elements to arraylist
        arrayList.add("Resident01");
        arrayList.add("Resident02");
        arrayList.add("Resident03");
        arrayList.add("Resident04");
        arrayList.add("Resident05");
        arrayList.add("Resident06");
        arrayList.add("Resident07");
        arrayList.add("Resident08");
        arrayList.add("Resident09");
        arrayList.add("Resident10");
        arrayList.add("Resident11");
        arrayList.add("Resident12");
        arrayList.add("Resident13");
        arrayList.add("Resident14");
        arrayList.add("Resident15");
        arrayList.add("Resident16");
        arrayList.add("Resident17");
        arrayList.add("Resident18");
        arrayList.add("Resident19");
        arrayList.add("Resident20");


        //Create Adapter
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

        //assign adapter to listview
        listView.setAdapter(arrayAdapter);

        //add listener to listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"clicked item:"+i+" "+arrayList.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, CurrentStatus.class);
        EditText editText = (EditText) findViewById(R.id.txtToSend);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}