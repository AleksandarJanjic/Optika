package com.optika.rest;

import com.optika.interfaces.BuyerInterface;
import com.optika.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AddBuyer")
public class AddBuyer {

    @Autowired
    BuyerInterface buyerInterface;

    @PostMapping
    public void addBuyer(
            @RequestParam("name") String name,
            @RequestParam(value = "lastname", required = false) String lastname
    ) {
        if(lastname == null) {
            Buyer buyer = new Buyer(name);
            buyerInterface.save(buyer);
        } else {
            Buyer buyer = new Buyer(name, lastname);
            buyerInterface.save(buyer);
        }
    }
}
