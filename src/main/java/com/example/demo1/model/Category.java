package com.example.demo1.model;

public class Category {
    private int id;
    private String nameC;

    public Category(int id, String nameC) {
        this.id = id;
        this.nameC = nameC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }
}
