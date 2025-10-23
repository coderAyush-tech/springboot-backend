package com.example.demo.models;

public class TeamDetails {
    private String name;
    private String motto;
    private String color;
    private String image;


    public TeamDetails(String name, String motto, String color,String image) {
        this.name = name;
        this.motto = motto;
        this.color = color;
        this.image = image;


    }

    public String getName() { return name; }
    public String getMotto() { return motto; }
    public String getColor() { return color; }
    public String getImage() { return image; }

}
