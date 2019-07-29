package com.optika.repo;

import com.optika.model.Diopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiopterRepository extends JpaRepository<Diopter, Long> {

    Diopter findByDiopter(double diopter);
}
