package com.interlink.repositiry.goods;

import com.interlink.repositiry.goods.position.AssortmentPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShowroomAssortment implements Assortment {
    private List<AssortmentPosition> assortmentPositions;

    public ShowroomAssortment() {
        this.assortmentPositions = new ArrayList<>();
    }

    @Override
    public List<AssortmentPosition> getAssortment() {
        return assortmentPositions;
    }

    @Override
    public Optional<AssortmentPosition> getPositionById(int id) {
        return assortmentPositions.stream()
                .filter(assortmentPosition -> assortmentPosition.getId() == id)
                .findAny();
    }

    @Override
    public void addPosition(AssortmentPosition position) {
        assortmentPositions.add(position);
    }

    @Override
    public void updatePosition(int id, int productsCount) {
        getPositionById(id)
                .ifPresent(assortmentPosition ->
                        assortmentPosition.increaseQuantity(productsCount));
    }

    @Override
    public void salePosition(int id, int productsCount) {
        getPositionById(id)
                .ifPresent(assortmentPosition ->
                        assortmentPosition.salePosition(productsCount));
    }

    @Override
    public void removePosition(int id) {
        getPositionById(id)
                .ifPresent(assortmentPosition ->
                        assortmentPositions.remove(assortmentPosition));
    }
}
