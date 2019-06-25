package com.cki.kairos.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cki.kairos.profile.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	
}
