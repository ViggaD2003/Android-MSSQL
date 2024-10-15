package com.example.myapplication;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection conn;
    String username, password, ip, port, database;

    public Connection connectionClass() {
        ip = "10.0.2.2";
        database = "PRM_Demo_Database";
        username = "sa";
        password = "12345";
        port = "1433";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy((policy));

        Connection connection = null;
        String ConnectionURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databaseName=" + database + ";user=" + username + ";password=" + password + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        return connection;
    }
}
