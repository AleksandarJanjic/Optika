package com.optika.repo;

import com.optika.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Override
    <S extends Contact> S save(S s);
}
