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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import utilities.sqliteConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static com.example.admission_help.universityInfo.daysleft.dayleft;

//import static javax.xml.catalog.CatalogMessages.resourceBundle;

//import static com.sun.java.swing.action.ActionManager.utilities;

// all users class
public class addtimecontroller implements Initializable {

    @FXML
    private TextField unametextfield;
    @FXML
    private TextField datetextfield;

    @FXML
    private TableView<time> tableView;
    @FXML
    private TableColumn<time,Integer> id;
    @FXML
    private TableColumn<time,String> uname;
    @FXML
    private TableColumn<time,String> date;

    //ObservableList<String> typelist= FXCollections.observableArrayList("STUDENT","FACULTY","ADMIN");
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
    public void rmdata() throws SQLException {
        time selectedItem = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems().remove(selectedItem);


        dbconnect connectnow = new dbconnect();
        Connection connectdb = connectnow.getConnection();
        Statement statement = connectdb.createStatement();

        int status = statement.executeUpdate("DELETE FROM uni_time WHERE id= '"+selectedItem.getId()+"'");

        if (status==1) {
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Remove time");
            alert.setHeaderText(null);

            alert.showAndWait();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loaddata();
    }

    @FXML
    public void add(ActionEvent event) throws SQLException, IOException {
        dbconnect connectnow = new dbconnect();
        Connection connectdb = connectnow.getConnection();

        String uname = unametextfield.getText();
        String date = datetextfield.getText();

        String insertFields = "INSERT INTO login.uni_time (uniname,time,dayleft) VALUES ('";
        String leftday= dayleft(date);
        String insertValues = uname + "','" + date + "','" + leftday +"')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectdb.createStatement();
            statement.executeUpdate(insertToRegister);
            //createAccountFrom();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
    @FXML
    void back(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }



}