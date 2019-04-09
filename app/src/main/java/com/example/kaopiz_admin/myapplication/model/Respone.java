package com.example.kaopiz_admin.myapplication.model;

import com.google.gson.annotations.Expose;

public class Respone {
    @Expose
    private int code;
    @Expose
    private int content;

    public Respone(int code, int content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }
}
