package com.optika.interfaces;

import com.optika.model.Buyer;
import com.optika.model.Order;

import java.util.List;

public interface OrderInterface {

    Order findById(int id);

    List<Order> findByBuyerOrderByDateDesc(Buyer buyer);

    void save(Order order);
}
