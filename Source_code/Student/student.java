package com.example.admission_help.Student;


public class student implements studentin{

    private String sscgpa = "";
    private String hscgpa = "";

    public String getSscgpa(){
        return sscgpa;
    }
    public void setSsc_gpa(String sscgpa){
        this.sscgpa =sscgpa;
    }
    public String getHscgpa(){
        return hscgpa;
    }
    public void setHsc_gpa(String hscgpa){
        this.hscgpa =hscgpa;
    }
    public static String name = "";
    public String ssc_group = "";
    public String hsc_group="";
    public double ssc_gpa = 0;
    public double hsc_gpa = 0;
    public String division = "";
    public String passed_year = "";
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name =name;
    }
    public String getsscGroup(){
        return ssc_group;
    }
    public void setsscGroup(String ssc_group){
        this.ssc_group =ssc_group;
    }
    public double getSsc_gpa(){
        return ssc_gpa;
    }
    public String gethscGroup(){
        return ssc_group;
    }
    public void sethscGroup(String hsc_group){
        this.hsc_group =hsc_group;
    }

    public void setSsc_gpa(double ssc_gpa){
        this.ssc_gpa =ssc_gpa;
    }
    public double getHsc_gpa(){
        return hsc_gpa;
    }
    public void setHsc_gpa(double hsc_gpa){
        this.hsc_gpa =hsc_gpa;
    }
    public String getDivision(){
        return division;
    }
    public void setDivision(String division){
        this.division =division;
    }


    public String toStringN(){
        return name;
    }
    public String toStringSSCG(){
        return ssc_group;
    }
    public String toStringHSCG(){
        return hsc_group;
    }
    public double toStringSSC(){
        return ssc_gpa;
    }
    public double toStringHSC(){
        return hsc_gpa;
    }
    public String toStringSSC2(){
        return sscgpa;
    }
    public String toStringHSC2(){
        return hscgpa;
    }
    public String toStringD(){
        return division;
    }

}