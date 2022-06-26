package com.example.admission_help;

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
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class studentController implements Initializable {
    @FXML
    private TextField nametextfield;
    @FXML
    private TextField sscgrouptextfield;
    @FXML
    private TextField sscgpatextfield;
    @FXML
    private TextField hscgpatextfield;
    @FXML
    private TextField divisiontextfield;
    @FXML
    private TextField hscgrouptextfield;
    @FXML
    private Label namelabel;
    @FXML
    private Label sscgrouplabel;
    @FXML
    private Label sscgpalabel;
    @FXML
    private Label hscgpalabel;
    @FXML
    private Label divisionlabel;
    @FXML
    private Label hscgrouplabel;

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
        studentdata();
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
        String sscgroup = sscgrouptextfield.getText();
        std.setsscGroup(sscgroup);
        String ssc_gpa = sscgpatextfield.getText();
        std.setSsc_gpa(ssc_gpa);
        String hsc_gpa = hscgpatextfield.getText();
        std.setHsc_gpa(hsc_gpa);
        String division = divisiontextfield.getText();
        std.setDivision(division);
        String hscgroup = hscgrouptextfield.getText();
        std.sethscGroup(hscgroup);
        // studenttextarea.appendText(std.toString() + "\n");
        FileWriter fw = new FileWriter("Write.txt");
        BufferedWriter write = new BufferedWriter(fw);
        try {
            write.write(name);
            write.newLine();
            write.write(sscgroup);
            write.newLine();
            write.write(hscgroup);
            write.newLine();
            write.write(ssc_gpa);
            write.newLine();
            write.write(hsc_gpa);
            write.newLine();
            write.write(division);
            write.newLine();
            write.write("\0");

            write.close();
        } catch (IOException Ex) {
            System.out.println(Ex.getMessage());
        }
        studentdata();
    }
     public  void  studentdata(){
        String[] str = new String[10];
        try {
            FileReader fr = new FileReader("Write.txt");
            BufferedReader read = new BufferedReader(fr);
            String line = read.readLine();
            int i = 0;
            while (line != null) {
                System.out.println(line);
                str[i++] = line;
                line = read.readLine();
            }
            read.close();
        } catch (IOException Ex) {
            System.out.println(Ex.getMessage());
        }
        /*namelabel.setText(std.toStringN());
        sscgrouplabel.setText(std.toStringSSCG());
        sscgpalabel.setText(std.toStringSSC2());
        hscgpalabel.setText(std.toStringHSC2());
        divisionlabel.setText(std.toStringD());
        hscgrouplabel.setText(std.toStringHSCG());*/
        namelabel.setText(str[0]);
        sscgrouplabel.setText(str[1]);
        hscgpalabel.setText(str[2]);
        sscgpalabel.setText(str[3]);
        hscgrouplabel.setText(str[4]);
        divisionlabel.setText(str[5]);
        System.out.println(std.getsscGroup()+std.gethscGroup());

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
