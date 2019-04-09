package com.example.kaopiz_admin.myapplication.model;

import com.google.gson.annotations.Expose;

public class UserLogin {
    @Expose
    private String mail;
    @Expose
    private String password;

    public UserLogin(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
