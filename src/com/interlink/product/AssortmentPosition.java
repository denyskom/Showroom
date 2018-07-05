package com.interlink.product;

public class AssortmentPosition {
    private int quantity;
    private Product product;

    public AssortmentPosition(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public AssortmentPosition(Product product) {
        this.product = product;
        this.quantity = 1;
    }
}
