package com.optika.repo;

import com.optika.model.Angle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AngleRepository extends JpaRepository<Angle, Long> {

    Angle findByAngle(int angle);
}
