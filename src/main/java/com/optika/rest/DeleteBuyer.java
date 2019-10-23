package com.optika.rest;

import com.optika.model.Buyer;
import com.optika.repo.BuyerRepository;
import com.optika.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteBuyer {

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    BuyerService buyerService;

    @PostMapping("/deleteBuyer")
    public String deleteBuyer(
            @RequestParam("id") int id
    ) {
        Buyer buyer = buyerRepository.findById(id);
        String res = buyerService.deleteBuyer(buyer);
        return res;
    }
}
