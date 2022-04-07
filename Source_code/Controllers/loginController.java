package com.example.admission_help.controllers;

import com.example.admission_help.database.dbconnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class loginController implements Initializable {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("images/index.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("images/295128.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {

        if(usernameTextField.getText().isBlank()==false && enterPasswordField.getText().isBlank() == false){
            dbconnect connectnow = new dbconnect();
            Connection connectdb = connectnow.getConnection();

            String verifylogin = "SELECT count(1) FROM admission_login WHERE username = '" + usernameTextField.getText() + "' AND password ='" + enterPasswordField.getText() + "'";

            try{
                Statement statement = connectdb.createStatement();
                ResultSet queryresult = statement.executeQuery(verifylogin);
                while(queryresult.next()){
                    if(queryresult.getInt(1)==1){
                        //loginMessageLabel.setText("congrats");
                        //createAccountFrom();
                        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                        Node node = (Node) event.getSource();

                        Stage stage = (Stage) node.getScene().getWindow();

                        stage.setScene(new Scene(root));

                    }
                    else{
                        loginMessageLabel.setText("Invalid");
                    }
                }

            }catch(Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        else{
            loginMessageLabel.setText("please enter username and password");
        }
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}