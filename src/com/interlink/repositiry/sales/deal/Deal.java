package com.interlink.repositiry.sales.deal;

import com.interlink.employee.Employee;
import com.interlink.product.Product;

import java.time.LocalDate;
import java.util.List;

public abstract class Deal {
    private int id;
    private List<Product> products;
    private LocalDate date;
    private Employee seller;

    public Deal(int id, List<Product> products, LocalDate date, Employee seller) {
        this.id = id;
        this.products = products;
        this.date = date;
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getDate() {
        return date;
    }

    public Employee getSeller() {
        return seller;
    }

    public double getTotalPrice() {
       return products.stream()
               .map(Product::getPrice).count();
    }
}
