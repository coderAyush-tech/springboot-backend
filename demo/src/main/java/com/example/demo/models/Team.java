package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("team")
public class Team {

    @Id
    private String id;

    private String name;
    private String motto;
    private String color;
    private String image;

    public Team() {}

    public Team(String name, String motto, String color, String image) {
        this.name = name;
        this.motto = motto;
        this.color = color;
        this.image = image;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getMotto() { return motto; }
    public String getColor() { return color; }
    public String getImage() { return image; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setMotto(String motto) { this.motto = motto; }
    public void setColor(String color) { this.color = color; }
    public void setImage(String image) { this.image = image; }
}