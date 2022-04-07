package com.example.admission_help.Student;

import com.example.admission_help.database.dbconnect;

import java.sql.Connection;
import java.sql.Statement;

public class register implements register_In{
    private String name = "";
    private String gmail = "";
    private String username = "";
    private String password = "";
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name =name;
    }
    public String getGmail(){
        return gmail;
    }
    public void setGmail(String gmail){
        this.gmail =gmail;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username =username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password =password;
    }
    @Override
    public String toString() {
        return "Name     :  " + name + "\ngmail     :  " + gmail + "\nusername      :  " + username + "\npassword     :  " + password + '\n';

    }
    public void inputvalues(String name, String gmail,String username, String password){
        dbconnect connectnow = new dbconnect();
        Connection connectdb = connectnow.getConnection();
        String insertFields = "INSERT INTO login.admission_login (name, gmail, username, password) VALUES ('";
        String insertValues = name + "','" + gmail + "','" + username + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectdb.createStatement();
            statement.executeUpdate(insertToRegister);


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
