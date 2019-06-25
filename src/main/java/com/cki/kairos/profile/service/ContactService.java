package com.cki.kairos.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cki.kairos.profile.model.Contact;
import com.cki.kairos.profile.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	public Contact getContact(int contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Contact> getAllContacts() {

		return contactRepository.findAll();
	}

	public Contact createContact(Contact contact) {
		return contactRepository.save(contact);
	}

	
}
