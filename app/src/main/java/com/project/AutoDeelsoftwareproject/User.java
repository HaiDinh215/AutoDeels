package com.project.AutoDeelsoftwareproject;

public class User {
    private String username;
    private String password;
    private String conpassword;
    private String secquest;
    private String secans;

    //constructors
    public User() {

    }

    public User(String username, String password, String conpassword, String secquest, String secans) {
        this.username = username;
        this.password = password;
        this.conpassword = conpassword;
        this.secquest = secquest;
        this.secans = secans;
    }

    //getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConpassword() {
        return conpassword;
    }

    public String getSecquest() {
        return secquest;
    }

    public String getSecans() {
        return secans;
    }
}
