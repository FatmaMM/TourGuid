package com.example.android.tourguide;


public class HisPlace {
    private String name;
    private String address;
    private String year;
    private int imageResId;
    private int id;

    public HisPlace(String name, String address, String year, int imageResId, int id) {
        this.name = name;
        this.address = address;
        this.imageResId = imageResId;
        this.year = year;
        this.id = id;
    }

    public HisPlace(String name, String address, String year, int imageResId) {
        this.name = name;
        this.address = address;
        this.imageResId = imageResId;
        this.year = year;
    }

    public HisPlace(String name, String address, int imageResId) {
        this.name = name;
        this.address = address;
        this.imageResId = imageResId;
        this.year = "";
    }

    public boolean isRes() {
        if (this.year == "")
            return true;
        return false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getYear() {
        return year;
    }
}
