package com.optika.rest;

import com.optika.model.Contact;
import com.optika.model.Order;
import com.optika.repo.OrderRepository;
import com.optika.services.OrderService;
import com.optika.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteOrder {

    @Autowired
    OrderRepository repository;

    @Autowired
    OrderService orderService;

    @PostMapping("/DeleteOrder")
    public String deleteOrder(
            @RequestParam("id") int id
    ) {
        Order order = repository.findById(id);
        String res = orderService.deleteOrder(order);
        return String.valueOf(order.getBuyer().getId());
    }
}
