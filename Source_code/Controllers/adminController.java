package com.example.admission_help;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    @FXML
    private ImageView adminprofileimageview;
    @FXML
    private ImageView logoutimageview;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File adminFile = new File("images/admin.png");
        Image adminImage = new Image(adminFile.toURI().toString());
        adminprofileimageview.setImage(adminImage);

        File logoutFile = new File("images/Circles.png");
        Image logoutImage = new Image(logoutFile.toURI().toString());
        logoutimageview.setImage(logoutImage);


    }
    @FXML
    void add(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adduni.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void show(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("displayUniversity.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void logout(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void addtime(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addtime.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
}
