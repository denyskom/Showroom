package com.interlink.repositiry.sales;

import com.interlink.repositiry.sales.deal.Deal;

import java.util.List;

public interface Sales {
    List<Deal>  getAllSales();

    void addDeal();

}
