package com.optika.repo;

import com.optika.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    @Nullable
    List<Buyer> findByNameIgnoreCaseContainingAndLastnameIgnoreCaseContaining(@Nullable String name, @Nullable String lastname);

    @Nullable
    List<Buyer> findByNameIgnoreCaseContaining(@Nullable String lastname);

    @Override
    <S extends Buyer> S save(S s);

    Buyer findById(int Id);
}
