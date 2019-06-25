package com.cki.kairos.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cki.kairos.profile.model.Contact;
import com.cki.kairos.profile.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Contact Controller", description = "Supports Contact CRUDS")
@RestController
@RequestMapping("/api/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@ApiOperation(value = "Get a contact by Id", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved a contact"),
			@ApiResponse(code = 500, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 503, message = "Accessing the resource you were trying to reach is down"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 422, message = "The params have been entered are not vaild.")})
	@GetMapping("/{contactId}")
	public ResponseEntity<Contact> getOne(@PathVariable(name = "contactId") int contactId) {

		Contact contact = contactService.getContact(contactId);
		if (contact == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}

	@ApiOperation(value = "List All users", response = Iterable.class)
	@GetMapping("")
	public Iterable<Contact> findAllContacts() {
		return contactService.getAllContacts();
	}

	@ApiOperation(value = "Create a new contact", response = Iterable.class)
	@PostMapping("")
	public ResponseEntity<Contact> create(@RequestBody Contact contact) {

		try {
			
			Contact createdContact = contactService.createContact(contact);
			return new ResponseEntity<>(createdContact, HttpStatus.CREATED);

		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
