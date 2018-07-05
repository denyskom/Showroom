package com.interlink.repositiry.goods.position;

import com.interlink.product.Product;

public class AssortmentPosition {
    private final int id;
    private int quantity;
    private Product product;

    public AssortmentPosition(int quantity, Product product, int id) {
        this.quantity = quantity;
        this.product = product;
        this.id = id;
    }

    public AssortmentPosition(Product product, int id) {
        this.product = product;
        this.quantity = 1;
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getId() {
        return id;
    }

    public void increaseQuantity(int count) {
        quantity += count;
    }

    public void salePosition(int count) {
        quantity -= count;
    }


}
