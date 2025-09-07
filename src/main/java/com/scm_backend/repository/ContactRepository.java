package com.scm_backend.repository;

import com.scm_backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

    @RestResource(path = "by-email")
    List<Contact> findByEmail(String email);

    @RestResource(path = "by-name")
    List<Contact> findByPhoneNumber(String phoneNumber);


}
