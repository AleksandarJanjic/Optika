package com.optika.repo;

import com.optika.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Nullable
    List<Order> findById(@Nullable int id);

    @Override
    <S extends Order> S save(S s);
}
