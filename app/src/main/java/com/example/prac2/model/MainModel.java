package com.example.prac2.model;

import java.io.Serializable;

public class MainModel implements Serializable {
    private String name;
    private String number;
    private int imageView;
    private String specialization;
    private String email;
    private String place;

    public MainModel(String name, String number, int imageView, String specialization, String email, String place) {
        this.name = name;
        this.number = number;
        this.imageView = imageView;
        this.specialization = specialization;
        this.email = email;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
