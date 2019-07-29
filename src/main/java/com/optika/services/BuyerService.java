package com.optika.services;

import com.optika.interfaces.BuyerInterface;
import com.optika.model.Buyer;
import com.optika.repo.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService implements BuyerInterface {

    @Autowired
    BuyerRepository repository;

    @Override
    public List<Buyer> findAll() {
        return (List<Buyer>) repository.findAll();
    }

    @Override
    @Nullable
    public List<Buyer> findByNameIgnoreCaseContainingAndLastnameIgnoreCaseContaining(String name, @Nullable  String lastname) {
        return (List<Buyer>) repository.findByNameIgnoreCaseContainingAndLastnameIgnoreCaseContaining(name, lastname);
    }

    @Override
    @Nullable
    public List<Buyer> findByNameIgnoreCaseContaining(@Nullable String name) {
        return (List<Buyer>) repository.findByNameIgnoreCaseContaining(name);
    }

    public void save(Buyer buyer) {
        repository.save(buyer);
    }

    @Override
    public Buyer findById(int Id) {
        return (Buyer) repository.findById(Id);
    }
}
