package com.optika.services;

import com.optika.interfaces.DiopterInterface;
import com.optika.model.Diopter;
import com.optika.repo.DiopterRepository;
import com.optika.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiopterService implements DiopterInterface {

    @Autowired
    DiopterRepository repository;

    @Override
    public Diopter findByDiopter(double diopter) {
        return repository.findByDiopter(diopter);
    }

    @Transactional
    public String persistDiopter(Diopter diopter) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(diopter);
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return "Diopter " + diopter.getDiopter() + " added";
    }
}
