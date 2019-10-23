package com.optika.services;

import com.optika.interfaces.TypeInterface;
import com.optika.model.Type;
import com.optika.repo.TypeRepository;
import com.optika.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypeService implements TypeInterface {

    @Autowired
    TypeRepository repository;

    @Override
    public Type findByTip(String tip) {
        return (Type) repository.findByTip(tip);
    }

    @Transactional
    public String persistType(Type type) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(type);
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return "Type " + type.getTip() + " added";
    }
}
