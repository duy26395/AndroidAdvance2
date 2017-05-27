package com.example.tung.lesson4_reactivex.data.model;

/**
 * Created by tung on 5/26/17.
 */

public class User {

    private int id;
    private String name;
    private String avatarUrl;
    private String htmlUrl;

    public User(){}

    public User(int id, String name, String avatarUrl, String htmlUrl) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}
