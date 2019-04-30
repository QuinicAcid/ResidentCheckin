package com.example.residentcheckin;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    String ip,db,DBUserNameStr,DBPasswordStr;


    @SuppressLint("NewApi")
    public Connection connectionclasss()
    {

        // Declaring Server ip, username, database name and password
        ip = "SQL5008.site4now.net";
        db = "DB_A47087_smgroup";
        DBUserNameStr = "DB_A47087_smgroup_admin";
        DBPasswordStr = "ftccgroup1";
        // Declaring Server ip, username, database name and password


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection connection = null;
        String ConnectionURL = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + ip +";databaseName="+ db + ";user=" + DBUserNameStr+ ";password=" + DBPasswordStr + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (SQLException se)
        {
            Log.e("MDC SQL Error : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("MDC CLASS Error : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("MDC EXCEPTION Error : ", e.getMessage());
        }
        return connection;
    }

}
