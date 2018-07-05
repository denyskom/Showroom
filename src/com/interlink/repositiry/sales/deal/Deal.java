package com.interlink.repositiry.sales.deal;

import com.interlink.employee.manager.Salesman;
import com.interlink.product.Product;

import java.time.LocalDate;
import java.util.List;

public class Deal {
    private final int id;
    private List<Product> products;
    private LocalDate date;
    private Salesman seller;
    private boolean valid = true;

    public Deal(int id, List<Product> products, LocalDate date, Salesman seller) {
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

    public Salesman getSeller() {
        return seller;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public double getTotalPrice() {
       return products.stream()
               .mapToDouble(Product::getPrice).sum();
    }
}
