package com.example.admission_help;

import com.example.admission_help.Student.register;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class registerController implements Initializable{
    @FXML
    private ImageView registerimageview;
    @FXML
    private ImageView regiimageview;
    @FXML
    private Button closeButton;
    @FXML
    private Button haveaccountButton;
    @FXML
    private Label registerMessagelabel;
    @FXML
    private PasswordField passwordTextfield;
    @FXML
    private PasswordField confirmpasswordfield;
    @FXML
    private Label confirmpasswordlabel;
    @FXML
    private TextField nameTextfield;
    @FXML
    private TextField gmailTextfield;
    @FXML
    private TextField usernameTextfield;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File registerFile = new File("images/register-here-button.png");
        Image registerImage = new Image(registerFile.toURI().toString());
        registerimageview.setImage(registerImage);

        File regiFile = new File("images/ban7.png");
        Image regiImage = new Image(regiFile.toURI().toString());
        regiimageview.setImage(regiImage);

    }

    public void registerButtonOnAction(ActionEvent event) throws IOException {
        if(passwordTextfield.getText().equals(confirmpasswordfield.getText())){
            registerUser();
            confirmpasswordlabel.setText("");

                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

                Node node = (Node) event.getSource();

                Stage stage = (Stage) node.getScene().getWindow();

                stage.setScene(new Scene(root));


            //registerMessagelabel.setText("user has been registered successfully");
        }
        else{
            confirmpasswordlabel.setText("Password does not match");
        }
    }
    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        //Platform.exit();
        //createAccountFrom();
    }
    public void haveaccountButtonOnAction(ActionEvent event) throws IOException {
        //createAccountFrom();
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

    }

    public void registerUser(){
        register reg = new register();
        String name = nameTextfield.getText();
        reg.setName(name);
        String gmail = gmailTextfield.getText();
        reg.setGmail(gmail);
        String username = usernameTextfield.getText();
        reg.setUsername(username);
        String password = passwordTextfield.getText();
        reg.setPassword(password);
        reg.registration(name,gmail,username,password);

    }



}