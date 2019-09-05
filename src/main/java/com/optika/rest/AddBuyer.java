package com.optika.rest;

import com.optika.interfaces.BuyerInterface;
import com.optika.model.Buyer;
import com.optika.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AddBuyer")
public class AddBuyer {

    @Autowired
    BuyerInterface buyerInterface;

    @PostMapping
    public String addBuyer(
            @RequestParam("name") String name,
            @RequestParam(value = "lastname", required = false) String lastname
    ) {
        int id = -1;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        if(lastname == null) {
            Buyer buyer = new Buyer(name);
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
            id = buyer.getId();
        } else {
            Buyer buyer = new Buyer(name, lastname);
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
            id = buyer.getId();
        }
        session.close();
        return String.valueOf(id);
    }
}
