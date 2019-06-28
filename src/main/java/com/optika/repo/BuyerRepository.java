package com.optika.repo;

import com.optika.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Long> {

    List<Buyer> findByNameContainingOrLastnameContaining(String searchParam);
}
