package com.android.newmommy.model;

public class UserModel {
    String email;
    String dateOfBirth;
    String username ;

    public UserModel(String email, String dateOfBirth, String username) {
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
    }

    public UserModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
