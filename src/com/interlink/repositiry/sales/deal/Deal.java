package com.interlink.repositiry.sales.deal;

import com.interlink.employee.Employee;
import com.interlink.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Deal {
    private final int id;
    private List<Product> products;
    private LocalDate date;
    private Employee seller;
    private boolean valid = true;

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
        return new ArrayList<>(products);
    }

    public LocalDate getDate() {
        return date;
    }

    public Employee getSeller() {
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
