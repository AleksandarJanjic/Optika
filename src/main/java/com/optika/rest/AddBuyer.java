package com.optika.rest;

import com.optika.interfaces.BuyerInterface;
import com.optika.services.BuyerService;
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

    @Autowired
    BuyerService buyerService;

    @PostMapping
    public String addBuyer(
            @RequestParam("name") String name,
            @RequestParam(value = "lastname", required = false) String lastname
    ) {
        String res = buyerService.persistBuyer(name, lastname);
        return String.valueOf(res);
    }
}
