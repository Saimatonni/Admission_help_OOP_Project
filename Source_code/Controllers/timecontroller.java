package com.example.admission_help;

import com.example.admission_help.database.dbconnect;
import com.example.admission_help.universityInfo.time;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class timecontroller implements Initializable {

    @FXML
    private TableView<time> tableView;
    @FXML
    private TableColumn<time,Integer> id;
    @FXML
    private TableColumn<time,String> uname;
    @FXML
    private TableColumn<time,String> date;
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

        File logoutFile = new File("images/Circles.png");
        Image logoutImage = new Image(logoutFile.toURI().toString());
        logoutimageview.setImage(logoutImage);
        loaddata();


    }
    @FXML
    public void loaddata() {

        id.setCellValueFactory(new PropertyValueFactory<time,Integer>("id"));
        uname.setCellValueFactory(new PropertyValueFactory<time,String>("uname"));
        date.setCellValueFactory(new PropertyValueFactory<time,String>("edate"));



        tableView.setItems(gettime());
    }

    public ObservableList<time> gettime(){
        ObservableList<time> time= FXCollections.observableArrayList();
        try {
           /* Connection connection = sqliteConnection.dbConnector();
            Statement statement = connection.createStatement();*/
            dbconnect connectnow = new dbconnect();
            Connection connectdb = connectnow.getConnection();
            Statement statement = connectdb.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from uni_time");
            while (resultSet.next()) {
                time.add(new time(resultSet.getInt("idtime"), resultSet.getString("uniname"), resultSet.getString("time")));
            }


        } catch (SQLException e) {
            System.err.println("Cannot Connect to Database");
        }



        return time;
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