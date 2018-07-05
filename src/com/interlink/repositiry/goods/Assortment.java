package com.interlink.repositiry.goods;

import com.interlink.repositiry.goods.position.AssortmentPosition;

import java.util.List;
import java.util.Optional;

public interface Assortment {

    List<AssortmentPosition> getAssortment();

    Optional<AssortmentPosition> getPositionById(int id);

    void addPosition(AssortmentPosition position);

    void updatePosition(int id, int productsCount);

    void salePosition(int id, int productsCount);

    void removePosition(int id);

}
