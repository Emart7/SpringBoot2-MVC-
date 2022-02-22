package com.example.webexample.model;

public class Color {

    private Integer idColor;
    private String description;

    public Color() {
        super();
    }

    public Color(Integer idColor, String description) {
        this.idColor = idColor;
        this.description = description;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
