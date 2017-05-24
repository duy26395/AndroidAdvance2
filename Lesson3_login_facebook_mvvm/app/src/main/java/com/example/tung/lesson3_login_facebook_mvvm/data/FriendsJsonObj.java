package com.example.tung.lesson3_login_facebook_mvvm.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 5/24/17.
 */

public class FriendsJsonObj {

    private ArrayList<Data> data;

    public ArrayList<Data> getData() { return this.data; }

    public void setData(ArrayList<Data> data) { this.data = data; }

    public List<Friend> getFriends(){
        List<Friend> friends = new ArrayList<>();
        for (Data d: data) {
            friends.add(new Friend(d.getName(), d.getPicture().getData().getUrl()));
        }
        return friends;
    }
    @Override
    public String toString() {
        String result = "";
        for (Data d: data) {
            result += d.toString();
        }
        return result;
    }


    public class Data
    {
        private String id;

        public String getId() { return this.id; }

        public void setId(String id) { this.id = id; }

        private String name;

        public String getName() { return this.name; }

        public void setName(String name) { this.name = name; }

        private Picture picture;

        public Picture getPicture() { return this.picture; }

        public void setPicture(Picture picture) { this.picture = picture; }

        @Override
        public String toString() {
            return "Data{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", picture=" + picture.getData().getUrl() +
                    '}';
        }
    }

    public class Picture
    {
        private PictureData data;

        public PictureData getData() { return this.data; }

        public void setData(PictureData data) { this.data = data; }
    }

    public class PictureData
    {
        private boolean is_silhouette;
        private String url;

        public PictureData() {
        }

        public boolean is_silhouette() {
            return is_silhouette;
        }

        public void setIs_silhouette(boolean is_silhouette) {
            this.is_silhouette = is_silhouette;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
