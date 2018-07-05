package com.interlink.repositiry.goods;

import com.interlink.product.AssortmentPosition;
import com.interlink.product.Product;

import java.util.List;

public interface Assortment {

    List<AssortmentPosition> getAssortment();

    AssortmentPosition getPositionById(int id);

    AssortmentPosition getPositionByName(String name);

    void addPosition(AssortmentPosition position);

    void updatePosition(int id);

    void removePosition(int id);

}
