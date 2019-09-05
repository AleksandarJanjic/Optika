package com.optika.rest;

import com.optika.model.Contact;
import com.optika.model.Order;
import com.optika.repo.OrderRepository;
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

    @PostMapping("/DeleteOrder")
    public String deleteOrder(
            @RequestParam("id") int id
    ) {
        Order order = repository.findById(id);
        order.setIsDeleted(true);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Order orderToUpdate = (Order) session.merge(order);
        session.saveOrUpdate(orderToUpdate);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted order");
        return String.valueOf(id);
    }
}
