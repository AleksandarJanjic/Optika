package com.optika.rest;

import com.optika.interfaces.BuyerInterface;
import com.optika.model.Buyer;
import com.optika.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/getBuyer")
public class GetBuyer {

    @Autowired
    BuyerInterface buyerInterface;

    @GetMapping("/getAll")
    public List<Buyer> getAll() {
        List<Buyer> buyers = buyerInterface.findAll();
        System.out.println("GET Request");
        return buyers;
    }

    @GetMapping("/getBuyerByName")
    public List<Buyer> getBuyerByName(
            @RequestParam("name") String name,
            @RequestParam(value = "lastname", required = false) String lastname
    ){
        if(lastname == null) {
            List<Buyer> result = buyerInterface.findByNameIgnoreCaseContaining(name);
            List<Buyer> finalResult = new ArrayList<>();
            for (Buyer b: result
                 ) {
                if(b.isDeleted() == null) {
                    finalResult.add(b);
                }
                if(b.isDeleted() != null) {
                    if(b.isDeleted() == false) {
                        finalResult.add(b);
                    }
                }
            }
            return finalResult;
        } else {
            List<Buyer> buyers = buyerInterface.findByNameIgnoreCaseContainingAndLastnameIgnoreCaseContaining(name, lastname);
            List<Buyer> finalResult = new ArrayList<>();
            for (Buyer b: buyers
            ) {
                if(b.isDeleted() == null) {
                    finalResult.add(b);
                }
                if(b.isDeleted() != null) {
                    if(b.isDeleted() == false) {
                        finalResult.add(b);
                    }
                }
            }
            return finalResult;
        }
    }

    @GetMapping("/getBuyerById")
    public Buyer getBuyerById(
            @RequestParam("id") int id
    ){
        System.out.println("Requesting user with id: " + id);
        Buyer buyer = new Buyer();
        System.out.println("GET Request: getBuyerById");
        buyer = buyerInterface.findById(id);
        if(!(buyer.getContacts() == null)) {
            for (Contact c : buyer.getContacts()
            ) {
                System.out.println("Contact is deleted:" + c.getIsDeleted());
            }
        }
        return buyer;
    }
}
