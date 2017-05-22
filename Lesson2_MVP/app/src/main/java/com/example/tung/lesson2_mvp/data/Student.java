package com.example.tung.lesson2_mvp.data;

import android.content.ContentValues;

/**
 * Created by tung on 5/19/17.
 */

public class Student {

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";

    
    private int id;
    private String name;
    private String phone;

    public Student() {
    }

    public Student(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Student(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        if (id != 0) {
            contentValues.put(COLUMN_ID, id);
        }
        if (name != null) {
            contentValues.put(COLUMN_NAME, name);
        }
        if (phone != null) {
            contentValues.put(COLUMN_PHONE, phone);
        }
        return contentValues;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
