package com.example.admission_help;

import com.example.admission_help.database.dbconnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import utilities.sqliteConnection;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//import static javax.xml.catalog.CatalogMessages.resourceBundle;

//import static com.sun.java.swing.action.ActionManager.utilities;

// all users class
public class uniController {

    @FXML
    private TextField uniname;
    @FXML
    private TextField hsc_gpa;
    @FXML
    private TextField hsc_steam;
    @FXML
    private TextField ssc_gpa;
    @FXML
    private TextField ssc_steam;
    @FXML
    private TextField unit;
    @FXML
    private Label meassage;


    //ObservableList<String> typelist= FXCollections.observableArrayList("STUDENT","FACULTY","ADMIN");

    @FXML
    public void add_uni(MouseEvent event) throws SQLException, IOException {
        dbconnect connectnow = new dbconnect();
        Connection connectdb = connectnow.getConnection();

        String uname = uniname.getText();
        String Unit = unit.getText();
        String hscgpa = hsc_gpa.getText();
        String hscsteam = hsc_steam.getText();
        String sscgpa = ssc_gpa.getText();
        String sscsteam = ssc_steam.getText();
        
        String insertFields = "INSERT INTO login.university_list (uni_name, unit, hsc_gpa, hsc_steam, ssc_gpa,ssc_steam) VALUES ('";
        String insertValues = uname + "','" + Unit + "','" + hscgpa + "','" + hscsteam +  "','" + sscgpa + "','" + sscsteam + "')";
        String insertToRegister = insertFields + insertValues;
        String[] str = new String[10];
        try {
            FileWriter fw = new FileWriter("Read.txt");
            BufferedWriter write = new BufferedWriter(fw);
                System.out.println(sscgpa + " " + sscsteam + " " + hscgpa + " " + hscsteam + " " + uname + " " + Unit);
                write.write(sscgpa + " " + sscsteam + " " + hscgpa + " " + hscsteam + " " + uname + " " + Unit);
                write.newLine();
                write.close();
            try {
                Statement statement = connectdb.createStatement();
                statement.executeUpdate(insertToRegister);
                meassage.setText("added successfully");
                //createAccountFrom();

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }catch(IOException e){
            e.printStackTrace();
            e.getCause();
        }

    }
    @FXML
    void back(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }


}