package com.example.demo1.model;

public class Product {
    private int id;
    private String name;
    private String date;
    private int idCate;

    public Product() {
    }

    public Product(int id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Product(String name, String date, int idCate) {
        this.name = name;
        this.date = date;
        this.idCate = idCate;
    }

    public Product(int id, String name, String date, int idCate) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.idCate = idCate;
    }

    public int getIdCate() {
        return idCate;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
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
}
