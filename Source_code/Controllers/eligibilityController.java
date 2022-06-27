package com.example.admission_help;

import com.example.admission_help.database.dbconnect;
import com.example.admission_help.universityInfo.Eligibility_check;
import com.example.admission_help.universityInfo.university;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class eligibilityController implements Initializable {
    @FXML
    private TableView<university> tableView;
    @FXML
    private TableColumn<university,Integer> idc;
    @FXML
    private TableColumn<university,String> universityc;
    @FXML
    private TableColumn<university,String> unitc;
    @FXML
    private TableColumn<university,String> hscgpac;
    @FXML
    private TableColumn<university,String> hscsteamc;
    @FXML
    private TableColumn<university,String> sscgpac;
    @FXML
    private TableColumn<university, String> sscsteamc;
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
    private ImageView bannerimageview;
    @FXML
    private TextField myinputtext;

    @FXML
    private Button myButton;
    @FXML
    private Label outputtext;

    @FXML
    public void loaddata() {

        idc.setCellValueFactory(new PropertyValueFactory<university,Integer>("id"));
        universityc.setCellValueFactory(new PropertyValueFactory<university,String>("university"));
        unitc.setCellValueFactory(new PropertyValueFactory<university,String>("unit"));
        hscgpac.setCellValueFactory(new PropertyValueFactory<university,String>("hsc_gpa"));
        hscsteamc.setCellValueFactory(new PropertyValueFactory<university,String>("hsc_steam"));
        sscgpac.setCellValueFactory(new PropertyValueFactory<university,String>("ssc_gpa"));
        sscsteamc.setCellValueFactory(new PropertyValueFactory<university,String>("ssc_steam"));


        tableView.setItems(getUni());
    }

    public ObservableList<university> getUni(){
        ObservableList<university> uni= FXCollections.observableArrayList();
        try {
           /* Connection connection = sqliteConnection.dbConnector();
            Statement statement = connection.createStatement();*/
            dbconnect connectnow = new dbconnect();
            Connection connectdb = connectnow.getConnection();
            Statement statement = connectdb.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from university_list");
            while (resultSet.next()) {
                uni.add(new university(resultSet.getInt("iduniversity_list"), resultSet.getString("uni_name"), resultSet.getString("unit"),  resultSet.getString("hsc_gpa"), resultSet.getString("hsc_steam"), resultSet.getString("ssc_gpa"), resultSet.getString("ssc_steam")));
            }


        } catch (SQLException e) {
            System.err.println("Cannot Connect to Database");
        }



        return uni;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        myinputtext.setText(str[4]+","+str[2]+","+str[3]+","+str[1]);
        submission();

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
    String in;
    public void submit(ActionEvent actionEvent) {
        submission();
    }
    public void submission(){
        in = myinputtext.getText();
        Eligibility_check obj = new Eligibility_check();
        String ans = obj.Inputcut(in);
        outputtext.setText(ans);
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
    @FXML
    public void logout(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }

}
