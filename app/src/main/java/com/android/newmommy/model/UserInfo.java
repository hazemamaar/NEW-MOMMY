package com.android.newmommy.model;

public class UserInfo {
    String email;
    String password;
    String username;
    String mobile;
    String dateOfBirth;
    String dateOfPregenance;

    public UserInfo(String email, String password, String username, String mobile, String dateOfBirth, String dateOfPregenance) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.dateOfPregenance = dateOfPregenance;
    }

    public UserInfo() {

    }

    public UserInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfPregenance() {
        return dateOfPregenance;
    }

    public void setDateOfPregenance(String dateOfPregenance) {
        this.dateOfPregenance = dateOfPregenance;
    }
}
