package com.cki.Kairos.service;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cki.Kairos.model.Address;
import com.cki.Kairos.model.User;
import com.cki.Kairos.repository.AddressRepository;
import com.cki.Kairos.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AddressRepository addressRepository;

	/**
	 * 
	 * @param id identifier of the user to find
	 * @return user instance if a match is found, null otherwise
	 */
	public User getUser(int id) {
		return userRepository.findByUserId(id);
	}

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Iterable<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	public User createUser(User user) {
		
		if (isUserExist(user)) {
			throw new InvalidParameterException("Cannot create an existing User!");
		}
		
		return userRepository.save(user);
	}

	public boolean isUserExist(User user) {
		
		if(getUser(user.getUserId()) == null) {
			return false;
		}
		return true;
	}
	
	public Address findAddress(int id) {
		return addressRepository.findByAddressId(id);
	}

}
