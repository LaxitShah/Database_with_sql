package com.example.database_with_sql;

public class UserBean {

    String id,name,username,password;

    public UserBean(String id,String name,String username,String password)
    {
        this.id=id;
        this.name=name;
        this.username=username;
        this.password=password;
    }

    public UserBean(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
