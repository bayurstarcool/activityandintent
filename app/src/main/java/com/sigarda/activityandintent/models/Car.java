package com.sigarda.activityandintent.models;

import java.io.Serializable;

public class Car implements Serializable {
    String name;
    String price;
    String color;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
