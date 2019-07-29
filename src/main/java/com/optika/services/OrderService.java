package com.optika.services;

import com.optika.interfaces.OrderInterface;
import com.optika.model.Order;
import com.optika.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderInterface {

    @Autowired
    OrderRepository repository;

    @Override
    public List<Order> findById(int id) {
        return (List<Order>) repository.findById(id);
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }
}
