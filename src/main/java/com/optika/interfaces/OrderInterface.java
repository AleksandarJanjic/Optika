package com.optika.interfaces;

import com.optika.model.Order;

import java.util.List;

public interface OrderInterface {

    List<Order> findById(int id);

    void save(Order order);
}
