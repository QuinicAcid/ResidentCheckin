package com.example.residentcheckin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

import android.os.Bundle;



import java.util.ArrayList;

public class DisplayActivity {

    private ArrayList<String> arraylist=new ArrayList<>();
    private SQLiteDatabase MYdatabase;
    ListView listView;
    Button back;


   // @Override
   // protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
       // super.onCreate(savedInstanceState);
       // setContextView(R.layout.display);
      //  listView=(ListView)findViewById(R.id.listView1);

      //  DatabaseHelper db=new DatabaseHelper(this);
      //  MYdatabase=db.getWritableDatabase();
      //  try {
           // Cursor c=MYdatabase.rawQuery("SELECt * FROM Student", null);
           // if(c!=null)
          //  {
               // if(c.moveToFirst())
               // {
                  //  do {
                        //String name=c.getString(c.getColumnIndex("NAME"));
                       // String age=c.getString(c.getColumnIndex("AGE"));
                      //  String address=c.getString(c.getColumnIndex("ADDRESS"));
                       // arraylist.add("Name :"+name+"\n"+"Age :"+age+"\n"+"Address :"+address+"\n");

                    //} while (c.moveToNext());
               // }
            }

          //  ((Cursor) c).close();
            //c.deactivate();

       // } catch (SQLiteException e) {

           // Log.d(getClass().getSimpleName(), "could not create"+"or open the database");

      //  }
      //  finally
       // {
           // if(MYdatabase!=null)
          //  {
           //     MYdatabase.close();
         //   }
      ///  }
     //   listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arraylist));
   // }
 //   public void Back(View v)
   // {
      //  Intent back=new Intent(DisplayActivity.this,DisplayActivity.class);
     //   startActivity(back);
   // }
//}