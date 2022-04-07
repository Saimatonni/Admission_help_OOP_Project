package com.example.admission_help.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class eligibilityController implements Initializable {
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
    //private TextField eligiList;

    /*public home(TextField eligiList) {
           eligiList.setText("Hello");
    }*/


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

        File bannerFile = new File("images/List.png");
        Image bannerImage = new Image(bannerFile.toURI().toString());
        bannerimageview.setImage(bannerImage);

        File logoutFile = new File("images/Circles.png");
        Image logoutImage = new Image(logoutFile.toURI().toString());
        logoutimageview.setImage(logoutImage);
    }
    String in;
    public void submit(ActionEvent actionEvent) {
        in = myinputtext.getText();
        String SS="",HS="",temp="";
        double SSC=0,HSC=0;
        int flag=1,n=in.length();
        try {
            for(int i=0;i<n;i++)
            {
                char ss=in.charAt(i);
                if(ss!=',') temp+=ss;
                if(ss==','|| i+1==n)
                {
                    //System.out.println("YES");
                    if(flag==3)
                        SSC=Double.valueOf(temp);
                    else if(flag==4)
                        SS=temp;
                    else if(flag==1)
                        HSC=Double.valueOf(temp);
                    else HS=temp;
                    temp="";
                    flag++;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(SSC+" "+HSC+" "+SS+" "+HS);
        String A="Arts",S="Science",C="Commerce",all="All";
        int i,j=0;
        String []printstr=new String[100];
        if((HSC>=0.00 && HSC<=5.00 ) && (SSC>=0.00 && SSC<= 5.00) && (SS.equals(A)|| SS.equals(S) || SS.equals(C)) &&(HS.equals(A)|| HS.equals(S) || HS.equals(C))) {
            try {
                FileReader fr = new FileReader("Read.txt");
                BufferedReader read = new BufferedReader(fr);
                String line = read.readLine();
                String str;
                double Sg = 0, hg = 0;
                String SSC_Steam = "", HSC_Steam = "";
                temp = "";
                flag = 1;
                //System.out.println(line);
                while (line!=null) {
                    n = line.length();
                    for (i = 0; i < n; i++) {
                        char ch = line.charAt(i);
                        if (ch != ' ') temp += ch;
                        else if (ch == ' ' ) {
                            if (flag == 1)
                                Sg = Double.valueOf(temp);
                            else if (flag == 2)
                                SSC_Steam = temp;
                            else if (flag == 3)
                                hg = Double.valueOf(temp);
                            else HSC_Steam = temp;
                            temp = "";
                            flag++;
                        }
                        if (flag == 5) {
                            //System.out.println(HSC_Steam+" "+SSC_Steam+" "+Sg+" "+hg);
                            if ( (HSC_Steam.equals(all) || (HSC_Steam.equals(HS) && SSC_Steam.equals(SS))) && SSC >= Sg && HSC >= hg) {
                                temp = "";
                                while (i < n) {
                                    ch = line.charAt(i);
                                    temp += ch;
                                    i++;
                                }
                                outputtext.setText(temp);
                                printstr[j++]=temp;
                            }
                            else System.out.println("No");
                            break;
                        }
                    }

                    line = read.readLine();
                    flag=1;
                    System.out.println(line);
                    //outputtext.setText(s+" "+s2);
                    //break;
                    temp="";
                }
                read.close();
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            temp="";
            for(i=0;i<j;i++)
            {

                System.out.println(printstr[i]);
                temp+=printstr[i];
                temp+="\n";

            }
            if(j==0) temp="Sorry Your Not elligible for any Versity\n";
            outputtext.setText(temp);
            //
        }
        else  outputtext.setText("Please,Enter Result In correct Output Formate,it should be Sapareted by , ");

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

}
