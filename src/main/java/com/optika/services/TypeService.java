package com.optika.services;

import com.optika.interfaces.TypeInterface;
import com.optika.model.Type;
import com.optika.repo.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeService implements TypeInterface {

    @Autowired
    TypeRepository repository;

    @Override
    public Type findByTip(String tip) {
        return (Type) repository.findByTip(tip);
    }
}
