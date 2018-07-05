package com.interlink.repositiry.sales;

import com.interlink.repositiry.sales.deal.Deal;

import java.time.Month;
import java.util.List;
import java.util.Optional;

public interface SalesList {
    List<Deal> getAllSales();

    Optional<Deal> getDealById(int id);

    List<Deal> getDealsBySellerId(int id);

    void addDeal(Deal deal);

    List<Deal> getDealsByMonth(Month month);

}
