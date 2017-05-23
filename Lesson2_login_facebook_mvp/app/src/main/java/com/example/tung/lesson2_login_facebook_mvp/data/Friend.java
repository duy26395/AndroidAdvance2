package com.example.tung.lesson2_login_facebook_mvp.data;

/**
 * Created by tung on 5/22/17.
 */

public class Friend {
    private String name;
    private String image;

    public Friend(){}

    public Friend(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
