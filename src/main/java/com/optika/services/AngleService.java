package com.optika.services;

import com.optika.interfaces.AngleInterface;
import com.optika.model.Angle;
import com.optika.repo.AngleRepository;
import com.optika.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AngleService implements AngleInterface {

    @Autowired
    AngleRepository repository;

    @Override
    public Angle findByAngle(Integer angle) {

        return (Angle) repository.findByAngle(angle);
    }

    @Transactional
    public String persistAngle(Angle angle) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(angle);
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return "Angle " + angle.getAngle() + " added";
    }
}
