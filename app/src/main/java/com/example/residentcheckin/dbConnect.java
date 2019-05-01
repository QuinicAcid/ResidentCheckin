package com.example.residentcheckin;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnect {

    public static void main (String[] args)
    {
        try
        {
            // Step 1: Load the JDBC ODBC driver
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // Step 2: Establish the connection to the database
            String url = "jdbc:jtds:sqlserver://SQL5008.site4now.net/DB_A47087_smgroup";
            Connection conn = DriverManager.getConnection(url,"DB_A47087_smgroup_admin","ftccgroup1");
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}
