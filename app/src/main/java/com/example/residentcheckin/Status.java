package com.example.residentcheckin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Status extends AppCompatActivity {
//    private static final String url = "jdbc:sqlserver://SQL5008.site4now.net;databaseName=DB_A47087_smgroup";
    private static final String url = "jdbc:jtds:sqlserver://SQL5008.site4now.net/DB_A47087_smgroup";
    private static final String user = "DB_A47087_smgroup_admin";
    private static final String pass = "ftccgroup1";
    private TextView firstName, lastName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        firstName = (TextView) findViewById(R.id.textViewFirstName);
        lastName = (TextView) findViewById(R.id.textViewLastName);
        Button buttonCheckIn = (Button) findViewById(R.id.buttonCheckIn);

        buttonCheckIn.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View v) {
                new MyTask().execute();
            }

        });

    }

    private class MyTask extends AsyncTask<Void, Void, Void>{
        private String fName="", lName="";
        @Override
        protected Void doInBackground(Void... arg0) {
            try{
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);

                Statement st = con.createStatement();
                String sql = "SELECT * FROM Resident WHERE Resident_ID = 17";

                final ResultSet rs = st.executeQuery(sql);
                rs.next();
                lName = rs.getString(2);
                fName = rs.getString(3);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            lastName.setText(lName);
            firstName.setText(fName);
            super.onPostExecute(aVoid);
        }
    }
}