package com.optika.services;

import com.optika.interfaces.BuyerInterface;
import com.optika.model.Buyer;
import com.optika.repo.BuyerRepository;
import com.optika.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuyerService implements BuyerInterface {

    @Autowired
    BuyerRepository repository;

    @Override
    public List<Buyer> findAll() {
        return (List<Buyer>) repository.findAll();
    }

    @Override
    @Nullable
    public List<Buyer> findByNameIgnoreCaseContainingAndLastnameIgnoreCaseContaining(String name, @Nullable  String lastname) {
        return (List<Buyer>) repository.findByNameIgnoreCaseContainingAndLastnameIgnoreCaseContaining(name, lastname);
    }

    @Override
    @Nullable
    public List<Buyer> findByNameIgnoreCaseContaining(@Nullable String name) {
        return (List<Buyer>) repository.findByNameIgnoreCaseContaining(name);
    }

    public void save(Buyer buyer) {
        repository.save(buyer);
    }

    @Override
    public Buyer findById(int Id) {
        return (Buyer) repository.findById(Id);
    }

    @Transactional
    public String persistBuyer(String name, String lastname) {
        int id = -1;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        if(lastname == null) {
            Buyer buyer = new Buyer(name);
            session.saveOrUpdate(buyer);
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                session.getTransaction().rollback();
            } finally {
                HibernateUtil.closeSession(session);
            }
            id = buyer.getId();
        } else {
            Buyer buyer = new Buyer(name, lastname);
            session.saveOrUpdate(buyer);
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                session.getTransaction().rollback();
            } finally {
                HibernateUtil.closeSession(session);
            }
            id = buyer.getId();
        }
        return String.valueOf(id);
    }

    @Transactional
    public String deleteBuyer(Buyer buyer) {
        buyer.setDeleted(true);
        String deletedBuyerId = String.valueOf(buyer.getId());
        boolean deleted = false;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Buyer buyerToDelete = (Buyer) session.merge(buyer);
        session.saveOrUpdate(buyerToDelete);
        try {
            session.getTransaction().commit();
            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        if(deleted == true) {
            return deletedBuyerId;
        } else {
            return "Failed to delete Buyer with id: " + deletedBuyerId;
        }
    }
}
