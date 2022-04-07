package com.example.admission_help.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UniversityListController implements Initializable {
    @FXML
    private ImageView universitylistimageview;

    @FXML
    private Button btnBUET;

    @FXML
    private Button btnBUTEX;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCU;

    @FXML
    private Button btnCUET;

    @FXML
    private Button btnDU;

    @FXML
    private Button btnJU;

    @FXML
    private Button btnKUET;

    @FXML
    private Button btnRU;

    @FXML
    private Button btnRUET;

    @FXML
    private Button btnSUST;

    @FXML
    private Button btnHome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File universitylistFile = new File("images/images.jpg");
        Image universitylistImage = new Image(universitylistFile.toURI().toString());
        universitylistimageview.setImage(universitylistImage);
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {

    }

    @FXML
    void goHome(ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("homeview.fxml"));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

    }

    @FXML
    void openBuetWindow(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("BuetInfo.fxml"));
        Scene scene= new Scene(root);

        Stage NewStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    @FXML
    void openButexWindow(ActionEvent event) throws IOException{

    }

    @FXML
    void openCuWindow(ActionEvent event) throws IOException{

    }

    @FXML
    void openCuetWindow(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CuetInfo.fxml"));
        Scene scene= new Scene(root);

        Stage NewStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    @FXML
    void openDuWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("duInfo.fxml"));
        Scene scene= new Scene(root);

        Stage NewStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    @FXML
    void openJuWindow(ActionEvent event) throws IOException{

    }

    @FXML
    void openKuetWindow(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("KuetInfo.fxml"));
        Scene scene= new Scene(root);

        Stage NewStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    @FXML
    void openRuWindow(ActionEvent event) throws IOException{

    }

    @FXML
    void openRuetWindow(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("RuetInfo.fxml"));
        Scene scene= new Scene(root);

        Stage NewStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    @FXML
    void openSustWindow(ActionEvent event) throws IOException{

    }

}
