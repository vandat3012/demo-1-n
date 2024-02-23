package com.example.demo1.dto;

public class DTOProduct {
    private int id;
    private String name;
    private String date;
    private String nameCate;

    public DTOProduct() {
    }

    public DTOProduct(String name, String date, String nameCate) {
        this.name = name;
        this.date = date;
        this.nameCate = nameCate;
    }

    public DTOProduct(int id, String name, String date, String nameCate) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.nameCate = nameCate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }
}
