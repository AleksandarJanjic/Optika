package com.optika.services;

import com.optika.interfaces.OrderInterface;
import com.optika.model.Buyer;
import com.optika.model.Order;
import com.optika.repo.OrderRepository;
import com.optika.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public String persistOrder(Order order) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(order);
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
        System.out.println("Order added");
        return String.valueOf(order.getId());
    }

    @Transactional
    public String deleteOrder(Order order) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        order.setIsDeleted(true);
        Order orderToUpdate = (Order) session.merge(order);
        session.saveOrUpdate(orderToUpdate);
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return "deleted";
    }
}
