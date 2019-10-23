package com.optika.services;

import com.optika.interfaces.ContactInterface;
import com.optika.model.Contact;
import com.optika.repo.ContactRepository;
import com.optika.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService implements ContactInterface {

    @Autowired
    ContactRepository repository;

    @Override
    public void Save(Contact contact) {
        repository.save(contact);
    }

    @Override
    public Contact findById(int Id) {
        return (Contact) repository.findById(Id);
    }

    @Transactional
    public String persistContact(Contact contact) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(contact);
        session.getTransaction().commit();
        session.close();
        return String.valueOf(contact.getId());
    }

    @Transactional
    public String deleteContact(Contact contact) {
        contact.setIsDeleted(true);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Contact contactToUpdate = (Contact) session.merge(contact);
        session.saveOrUpdate(contactToUpdate);
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return String.valueOf(contact.getId());
    }
}
