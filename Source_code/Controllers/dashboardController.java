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

public class dashboardController implements Initializable {
    @FXML
    private ImageView studentimageview;
    @FXML
    private ImageView universityimageview;
    @FXML
    private ImageView dashimageview;
    @FXML
    private ImageView homeimageview;
    @FXML
    private ImageView euniversityimageview;
    @FXML
    private ImageView dstudentimageview;
    @FXML
    private ImageView questionsimageview;
    @FXML
    private ImageView logoutimageview;
    @FXML
    private ImageView studentimageview2;
    @FXML
    private ImageView universityimageview2;

    @FXML
    private ImageView homeimageview2;
    @FXML
    private ImageView euniversityimageview2;
    @FXML
    private ImageView dstudentimageview2;
    @FXML
    private ImageView questionsimageview2;
    @FXML
    private ImageView logoutimageview2;
    @FXML
    private ImageView bannerimageview;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File studentFile = new File("images/Male.png");
        Image studentImage = new Image(studentFile.toURI().toString());
        studentimageview.setImage(studentImage);

        File universityFile = new File("images/university-icon-19.png");
        Image universityImage = new Image(universityFile.toURI().toString());
        universityimageview.setImage(universityImage);

        File homeFile = new File("images/home.png");
        Image homeImage = new Image(homeFile.toURI().toString());
        homeimageview.setImage(homeImage);

        File dstudentFile = new File("images/Chat.png");
        Image dstudentImage = new Image(dstudentFile.toURI().toString());
        dstudentimageview.setImage(dstudentImage);

        File euniversityFile = new File("images/Search.png");
        Image euniversityImage = new Image(euniversityFile.toURI().toString());
        euniversityimageview.setImage(euniversityImage);

        File questionsFile = new File("images/Alarm.png");
        Image questionsImage = new Image(questionsFile.toURI().toString());
        questionsimageview.setImage(questionsImage);

        File dashFile = new File("images/Disk.png");
        Image dashImage = new Image(dashFile.toURI().toString());
        dashimageview.setImage(dashImage);

        File bannerFile = new File("images/admission.jpg");
        Image bannerImage = new Image(bannerFile.toURI().toString());
        bannerimageview.setImage(bannerImage);

        File studentFile2 = new File("images/Male.png");
        Image studentImage2 = new Image(studentFile2.toURI().toString());
        studentimageview2.setImage(studentImage2);

        File universityFile2 = new File("images/university-icon-19.png");
        Image universityImage2 = new Image(universityFile2.toURI().toString());
        universityimageview2.setImage(universityImage2);

        File homeFile2 = new File("images/home.png");
        Image homeImage2 = new Image(homeFile2.toURI().toString());
        homeimageview2.setImage(homeImage2);

        File dstudentFile2 = new File("images/Chat.png");
        Image dstudentImage2 = new Image(dstudentFile2.toURI().toString());
        dstudentimageview2.setImage(dstudentImage2);

        File euniversityFile2 = new File("images/Search.png");
        Image euniversityImage2 = new Image(euniversityFile2.toURI().toString());
        euniversityimageview2.setImage(euniversityImage2);

        File questionsFile2 = new File("images/Alarm.png");
        Image questionsImage2 = new Image(questionsFile2.toURI().toString());
        questionsimageview2.setImage(questionsImage2);

        File logoutFile = new File("images/Circles.png");
        Image logoutImage = new Image(logoutFile.toURI().toString());
        logoutimageview.setImage(logoutImage);

        File logoutFile2 = new File("images/Circles.png");
        Image logoutImage2 = new Image(logoutFile2.toURI().toString());
        logoutimageview2.setImage(logoutImage2);



    }
    @FXML
    public void dash(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    @FXML
    public void home(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("homeview.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }

    @FXML
    public void university(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UniversityList.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }

    @FXML
    public void logout(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    @FXML
    public void euniversity(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Eligibility.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    @FXML
    public void student(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("student.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    @FXML
    public void time(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("time.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    @FXML
    public void about(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }


}