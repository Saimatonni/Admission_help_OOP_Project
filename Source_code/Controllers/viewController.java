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

public class viewController implements Initializable {
    @FXML
    private ImageView adminimageview;
    @FXML
    private ImageView userimageview;
    @FXML
    private ImageView bannerimageview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File adminFile = new File("images/Male.png");
        Image adminImage = new Image(adminFile.toURI().toString());
        adminimageview.setImage(adminImage);

        File userFile = new File("images/student.png");
        Image userImage = new Image(userFile.toURI().toString());
        userimageview.setImage(userImage);

        File bannerFile = new File("images/ban6.png");
        Image bannerImage = new Image(bannerFile.toURI().toString());
        bannerimageview.setImage(bannerImage);
    }
    @FXML
    void admin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void user(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
}
