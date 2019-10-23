package com.optika.services;

import com.optika.interfaces.UtilInterface;
import com.optika.model.Buyer;
import com.optika.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtilService implements UtilInterface {

    @Transactional
    public String countSearch(Buyer buyer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(buyer);
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return String.valueOf(buyer.getName());
    }

    @Transactional
    public String countAdd(Buyer buyer) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(buyer);
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
            session.close();
        }
        return String.valueOf(buyer.getName());
    }
}
