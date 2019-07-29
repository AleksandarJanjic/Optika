package com.optika.services;

import com.optika.interfaces.DiopterInterface;
import com.optika.model.Diopter;
import com.optika.repo.DiopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiopterService implements DiopterInterface {

    @Autowired
    DiopterRepository repository;

    @Override
    public Diopter findByDiopter(double diopter) {
        return repository.findByDiopter(diopter);
    }
}
