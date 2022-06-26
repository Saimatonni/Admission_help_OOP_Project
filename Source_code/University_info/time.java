package com.example.admission_help.universityInfo;


public class time {
    Integer id;
    String uname;
    String edate;
    public time(){
        uname=" ";
        edate=" ";

    }
    public time(Integer id, String uname, String edate){
        this.id = id;
        this.uname =uname;
        this.edate=edate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }




}
