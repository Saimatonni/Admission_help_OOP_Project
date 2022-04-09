package com.example.admission_help;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DuInfoController implements Initializable {
    @FXML
    private ImageView duimageview;

    @FXML
    private MenuItem btnAunit;

    @FXML
    private Button btnBack;

    @FXML
    private MenuItem btnBunit;

    @FXML
    private Button btnContact;

    @FXML
    private MenuItem btnCunit;

    @FXML
    private MenuButton btnDept;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnResearch;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File duFile = new File("images/du_logo.png");
        Image duImage = new Image(duFile.toURI().toString());
        duimageview.setImage(duImage);
    }

    @FXML
    void openAunitWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("duAunit.fxml"));
        Scene scene= new Scene(root);

        Stage NewStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UniversityList.fxml"));
        Scene scene= new Scene(root);

        Stage NewStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    @FXML
    void goHome(ActionEvent event) {

    }

    @FXML
    void openConactWindow(ActionEvent event) {

    }

    @FXML
    void openResearchWindow(ActionEvent event) {

    }

    public void openBunitWindow(ActionEvent actionEvent) {

    }

    public void openCunitWindow(ActionEvent actionEvent) {

    }
}
