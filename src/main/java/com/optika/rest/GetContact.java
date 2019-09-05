package com.optika.rest;

import com.optika.model.Contact;
import com.optika.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GetContact")
public class GetContact {

    @Autowired
    ContactRepository repository;

    @GetMapping
    public Contact getContactById(
            @RequestParam("id") int id
    ) {
        Contact contact = new Contact();
        return contact = repository.findById(id);
    }
}
