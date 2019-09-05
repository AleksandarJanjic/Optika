package com.optika.services;

import com.optika.interfaces.ContactInterface;
import com.optika.model.Contact;
import com.optika.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
