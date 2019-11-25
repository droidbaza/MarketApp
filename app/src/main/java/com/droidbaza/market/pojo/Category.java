package com.droidbaza.market.pojo;

/**
 * Created by droidbaza on 25/11/19.
 */


public class Category {
    private int id;
    private String name;

    public int getImageUri() {
        return imageUri;
    }

    public void setImageUri(int imageUri) {
        this.imageUri = imageUri;
    }

    private int imageUri;
    private String attribute;

    public Category(int id, String name, int imageUri, String attribute) {
        this.id = id;
        this.name = name;
        this.imageUri = imageUri;
        this.attribute = attribute;
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


    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
