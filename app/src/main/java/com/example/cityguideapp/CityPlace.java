package com.example.cityguideapp;

public class CityPlace {
    public String name;
    public String imageUrl;
    public String address;

    public CityPlace(String name, String address, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.address = address;
    }
}
