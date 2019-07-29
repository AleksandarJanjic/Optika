package com.optika.interfaces;

import com.optika.model.Buyer;

import java.util.List;

public interface BuyerInterface {

    List<Buyer> findAll();

    List<Buyer> findByNameIgnoreCaseContainingAndLastnameIgnoreCaseContaining(String name, String lastname);

    List<Buyer> findByNameIgnoreCaseContaining(String name);

    Buyer findById(int Id);

    void save(Buyer buyer);
}
