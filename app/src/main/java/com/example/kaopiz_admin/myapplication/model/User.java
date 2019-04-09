package com.example.kaopiz_admin.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
    @Expose
    private String userName;
    @Expose
    private String password;
    @Expose
    private String address;
    @Expose
    private String mail;
    @Expose
    private int userRole;
    @Expose
    private String numberPhone;

    public User(String userName, String password, String address, String mail, int userRole, String numberPhone) {
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.mail = mail;
        this.userRole = userRole;
        this.numberPhone = numberPhone;
    }

    public User(String password, String mail) {
        this.password = password;
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
