package com.example.webexample.model;

public class Color {

    private Integer idColor;
    private String description;
    private String rgb;

    public Color() {
        super();
    }

    public Color(Integer idColor, String description, String rgb) {
        this.idColor = idColor;
        this.description = description;
        this.rgb = rgb;
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

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }
}
