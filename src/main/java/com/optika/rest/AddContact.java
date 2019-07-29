package com.optika.rest;

import com.optika.model.Buyer;
import com.optika.model.Contact;
import com.optika.repo.BuyerRepository;
import com.optika.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AddContact")
public class AddContact {

    @Autowired
    ContactRepository repository;

    @Autowired
    BuyerRepository buyerRepository;

    @PostMapping
    public void addContact(
            @RequestParam("id") int id,
            @RequestParam("phoneNum") String phoneNum
    ){
        Buyer buyer = buyerRepository.findById(id);
        Contact contact = new Contact(phoneNum, buyer);
        repository.save(contact);
    }
}
