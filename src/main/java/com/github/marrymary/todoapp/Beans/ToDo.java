package com.github.marrymary.todoapp.Beans;

import java.io.Serializable;

public class ToDo implements Serializable {
    private int id;
    private String userid;
    private String text;

    public int getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setText(String text) {
        this.text = text;
    }
}
