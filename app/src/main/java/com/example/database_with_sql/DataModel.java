package com.example.database_with_sql;

public class DataModel {


    String first_name,last_name;

    public DataModel(String s, String s1) {
        this.first_name=s;
        this.last_name=s1;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
