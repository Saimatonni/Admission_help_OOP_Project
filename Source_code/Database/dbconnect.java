package com.example.admission_help.database;

import java.sql.Connection;
import java.sql.DriverManager;
public class dbconnect {
    public Connection databaselink;
    public Connection getConnection(){
        String databaseName="login";
        String databaseUser="root";
        String databasePassword="mysql_123";
        String url="jdbc:mysql://localhost/" + databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaselink;
    }
}
