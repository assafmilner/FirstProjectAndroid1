package com.example.myapplicationrv.models;

public class Data {

    private String name;
    private String summary;
    private int image;
    private int id;

    public Data(String name, String summary, int image, int id) {
        this.name = name;
        this.summary = summary;
        this.image = image;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String version) {
        this.summary = summary;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
