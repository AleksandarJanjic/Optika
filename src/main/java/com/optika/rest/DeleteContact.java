package com.optika.rest;

import com.optika.model.Contact;
import com.optika.repo.ContactRepository;
import com.optika.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteContact {

    @Autowired
    ContactRepository repository;

    @Autowired
    ContactService contactService;

    @PostMapping("/DeleteContact")
    public String deleteContact(
            @RequestParam("id") int id
    ) {
        Contact contact = repository.findById(id);
        String res = contactService.deleteContact(contact);
        return res;
    }
}
