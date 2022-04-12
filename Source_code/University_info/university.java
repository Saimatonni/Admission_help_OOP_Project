package com.example.admission_help.universityInfo;


public class university {
    Integer id;
    String user,pass,fname,lname,address,typee,gender;
    String dob;
    String university,unit,hsc_gpa,hsc_steam,ssc_gpa,ssc_steam;

    public university(){
        university =" ";
        unit=" ";
        hsc_gpa =" ";
        hsc_steam=" ";
        ssc_gpa=" ";
        ssc_steam = " ";

    }
    public university(Integer id, String university, String unit, String hsc_gpa, String hsc_steam, String ssc_gpa, String ssc_steam){
       /* this.id=id;
        this.fname=Fname;
        this.lname=Lname;
        this.address=address;
        this.gender=gender;
        this.dob=dobb;
        this.typee=typee;*/
        this.id = id;
        this.university =university;
        this.unit = unit;
        this.hsc_gpa =hsc_gpa;
        this.hsc_steam=hsc_steam;
        this.ssc_gpa=ssc_gpa;
        this.ssc_steam=ssc_steam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHsc_gpa() {
        return hsc_gpa;
    }

    public void setHsc_gpa(String hsc_gpa) {
        this.hsc_gpa = hsc_gpa;
    }

    public String getHsc_steam() {
        return hsc_steam;
    }

    public void setHsc_steam(String hsc_steam) {
        this.hsc_steam = hsc_steam;
    }

    public String getSsc_gpa() {
        return ssc_gpa;
    }

    public void setSsc_gpa(String ssc_gpa) {
        this.ssc_gpa = ssc_gpa;
    }

    public String getSsc_steam() {
        return ssc_steam;
    }

    public void setSsc_steam(String ssc_steam) {
        this.ssc_steam = ssc_steam;
    }

    public String getTypee() {
        return typee;
    }

    public void setTypee(String typee) {
        this.typee = typee;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



}
