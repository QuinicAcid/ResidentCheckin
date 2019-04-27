package com.example.residentcheckin;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    String ip="SQL5008.site4now.net";
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //String Class = "net.sourceforge.jtds.jdbc.Driver";
    String db="DB_A47087_smgroup";
    String un="DB_A47087_smgroup_admin";
    String password="ftccgroup1";

    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try
        {
            Class.forName(driver);
            ConnURL="jdbc:sqlserver://"+ip+";databaseName="+db+";user="+un+";password="+password;
            conn = DriverManager.getConnection(ConnURL);
        }
        catch (SQLException se)
        {
            Log.e("Erro",se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("Erro",e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("Erro", e.getMessage());
        }
        return conn;
    }


}
