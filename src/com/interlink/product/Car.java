package com.interlink.product;

public class Car extends Product {
    private final String brand;
    private final String bodyType;


    public Car(String name, int id, double price, String brand, String bodyType) {
        super(name, id, price);
        this.brand = brand;
        this.bodyType = bodyType;
    }

    public String getBrand() {
        return brand;
    }

    public String getBodyType() {
        return bodyType;
    }
}
