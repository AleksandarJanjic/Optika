package com.optika.rest;

import com.optika.model.Contact;
import com.optika.repo.ContactRepository;
import com.optika.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteContact {

    @Autowired
    ContactRepository repository;

    @PostMapping("/DeleteContact")
    public String deleteContact(
            @RequestParam("id") int id
    ) {
        Contact contact = repository.findById(id);
        contact.setIsDeleted(true);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Contact contactToUpdate = (Contact) session.merge(contact);
        session.saveOrUpdate(contactToUpdate);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted contact");
        return String.valueOf(id);
    }
}
