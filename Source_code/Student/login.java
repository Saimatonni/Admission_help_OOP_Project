package com.example.admission_help.Student;

import com.example.admission_help.database.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class login implements user {
    register regi = new register();
    private String username = "";
    private String password = "";

    //regi.setUsername(username);
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int verify(String username, String password) {
        dbconnect connectnow = new dbconnect();
        Connection connectdb = connectnow.getConnection();
        String verifylogin = "SELECT count(1) FROM admission_login WHERE username = '" + username + "' AND password ='" + password + "'";
        try {
            Statement statement = connectdb.createStatement();
            ResultSet queryresult = statement.executeQuery(verifylogin);
            while (queryresult.next()) {
                if (queryresult.getInt(1) == 1) {
                    return 1;
                } else {
                    return 2;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return 0;
    }
    public void registration(String name,String gmail,String username,String password){

    }
}



