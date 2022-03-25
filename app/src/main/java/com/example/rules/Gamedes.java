package com.example.rules;

import android.graphics.Bitmap;

public class Gamedes {
    private String Name;

    private String Ages;

    private Bitmap bitmap;

    private String instruncrions;

    public Gamedes(String name, String ages, Bitmap bitmap, String instruncrions) {
        Name = name;
        Ages = ages;
        this.bitmap = bitmap;
        this.instruncrions = instruncrions;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAges() {
        return Ages;
    }

    public void setAges(String ages) {
        Ages = ages;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getInstruncrions() {
        return instruncrions;
    }

    public void setInstruncrions(String instruncrions) {
        this.instruncrions = instruncrions;
    }
}
