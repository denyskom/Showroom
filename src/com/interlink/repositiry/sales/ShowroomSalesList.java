package com.interlink.repositiry.sales;

import com.interlink.repositiry.sales.deal.Deal;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShowroomSalesList implements SalesList{

    private List<Deal> deals;

    public ShowroomSalesList() {
        this.deals = new ArrayList<>();
    }

    @Override
    public List<Deal> getAllSales() {
        return deals;
    }

    @Override
    public Optional<Deal> getDealById(int id) {
        return deals.stream()
                .filter(deal -> deal.getId() == id)
                .findAny();
    }

    @Override
    public List<Deal> getDealsBySellerId(int id) {
        return deals.stream()
                .filter(deal -> deal.getSeller().getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public void addDeal(Deal deal) {
        deals.add(deal);
    }

    @Override
    public List<Deal> getDealsByMonth(Month month) {
        return deals.stream()
                .filter(deal ->
                        deal.getDate().getMonth().equals(month))
                .collect(Collectors.toList());
    }
}
