package com.optika.services;

import com.optika.interfaces.OrderInterface;
import com.optika.model.Buyer;
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
    public Order findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Order> findByBuyerOrderByDateDesc(Buyer buyer) {
        return (List<Order>) repository.findByBuyerOrderByDateDesc(buyer);
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }
}
