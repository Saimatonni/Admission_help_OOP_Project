package com.example.admission_help.Student;


public class student implements studentin{
    private static String name = "";
    private String group = "";
    private String ssc_gpa = "";
    private String hsc_gpa = "";
    private String division = "";
    private String passed_year = "";
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name =name;
    }
    public String getGroup(){
        return group;
    }
    public void setGroup(String group){
        this.group =group;
    }
    public String getSsc_gpa(){
        return ssc_gpa;
    }
    public void setSsc_gpa(String ssc_gpa){
        this.ssc_gpa =ssc_gpa;
    }
    public String getHsc_gpa(){
        return hsc_gpa;
    }
    public void setHsc_gpa(String hsc_gpa){
        this.hsc_gpa =hsc_gpa;
    }
    public String getDivision(){
        return division;
    }
    public void setDivision(String division){
        this.division =division;
    }
    public String getPassed_year(){
        return passed_year;
    }
    public void setPassed_year(String passed_year){
        this.passed_year =passed_year;
    }
    /*@Override
    public String toString() {
        return "Name     :  " + name + "\nGroup     :  " + group + "\nSSC_GPA      :  " + ssc_gpa + "\nHSC_GPA      :  " + hsc_gpa + "\nTotal_GPA      :  " + total_gpa + "\nPassed_year      :  " + passed_year + '\n';

    }*/
    //@Override
    public String toStringN(){
        return name;
    }
    public String toStringG(){
        return group;
    }
    public String toStringSSC(){
        return ssc_gpa;
    }
    public String toStringHSC(){
        return hsc_gpa;
    }
    public String toStringD(){
        return division;
    }
    public String toStringYear(){
        return passed_year;
    }
}