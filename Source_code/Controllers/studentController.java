package com.example.admission_help.controllers;

import com.example.admission_help.Student.student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class studentController implements Initializable {
    @FXML
    private TextField nametextfield;
    @FXML
    private TextField grouptextfield;
    @FXML
    private TextField sscgpatextfield;
    @FXML
    private TextField hscgpatextfield;
    @FXML
    private TextField divisiontextfield;
    @FXML
    private TextField passedyeartextfield;
    @FXML
    private Label namelabel;
    @FXML
    private Label grouplabel;
    @FXML
    private Label ssclabel;
    @FXML
    private Label hsclabel;
    @FXML
    private Label divisionlabel;
    @FXML
    private Label yearlabel;

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
    private ImageView logoutimageview2;
    @FXML
    private ImageView profileimageview;


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

        File questionsFile = new File("images/Read.png");
        Image questionsImage = new Image(questionsFile.toURI().toString());
        questionsimageview.setImage(questionsImage);

        File dashFile = new File("images/Disk.png");
        Image dashImage = new Image(dashFile.toURI().toString());
        dashimageview.setImage(dashImage);

        File logoutFile = new File("images/Circles.png");
        Image logoutImage = new Image(logoutFile.toURI().toString());
        logoutimageview.setImage(logoutImage);

        File logoutFile2 = new File("images/Circles.png");
        Image logoutImage2 = new Image(logoutFile2.toURI().toString());
        logoutimageview2.setImage(logoutImage2);
        File profilefile = new File("images/prof2.png");
        Image profileimage = new Image(profilefile.toURI().toString());
        profileimageview.setImage(profileimage);

    }
    public void addStudentonAction(ActionEvent event) throws IOException {

        student std = new student();
        String name = nametextfield.getText();
        std.setName(name);
        String group = grouptextfield.getText();
        std.setGroup(group);
        String ssc_gpa = sscgpatextfield.getText();
        std.setSsc_gpa(ssc_gpa);
        String hsc_gpa = hscgpatextfield.getText();
        std.setHsc_gpa(hsc_gpa);
        String division = divisiontextfield.getText();
        std.setDivision(division);
        String passed_year = passedyeartextfield.getText();
        std.setPassed_year(passed_year);
        // studenttextarea.appendText(std.toString() + "\n");
        namelabel.setText(std.toStringN());
        grouplabel.setText(std.toStringG());
        ssclabel.setText(std.toStringSSC());
        hsclabel.setText(std.toStringHSC());
        divisionlabel.setText(std.toStringD());
        yearlabel.setText(std.toStringYear());
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

}