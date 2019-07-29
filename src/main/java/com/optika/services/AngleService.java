package com.optika.services;

import com.optika.interfaces.AngleInterface;
import com.optika.model.Angle;
import com.optika.repo.AngleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AngleService implements AngleInterface {

    @Autowired
    AngleRepository repository;

    @Override
    public Angle findByAngle(int angle) {
        return (Angle) repository.findByAngle(angle);
    }
}
