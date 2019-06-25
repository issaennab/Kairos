package com.cki.kairos.profile.service;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cki.kairos.profile.model.Address;
import com.cki.kairos.profile.model.Profile;
import com.cki.kairos.profile.repository.AddressRepository;
import com.cki.kairos.profile.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	AddressRepository addressRepository;

	/**
	 * 
	 * @param id identifier of the user to find
	 * @return user instance if a match is found, null otherwise
	 */
	public Profile getProfile(int id) {
		return profileRepository.findByProfileId(id);
	}

	public Iterable<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	public Iterable<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	public Profile createProfile(Profile profile) {
		
		if (isProfileExist(profile)) {
			throw new InvalidParameterException("Cannot create an existing Profile!");
		}
		
		return profileRepository.save(profile);
	}

	public boolean isProfileExist(Profile profile) {
		
		if(getProfile(profile.getProfileId()) == null) {
			return false;
		}
		return true;
	}
	
	public Address findAddress(int id) {
		return addressRepository.findByAddressId(id);
	}

	public Profile updateProfile(Profile profile) {
		
		if (isProfileExist(profile)) {
			return profileRepository.save(profile);
		}
		throw new InvalidParameterException("Profile not found!");
		
	}

	public void deleteProfile(int profileId) {
		
		Profile profile = getProfile(profileId);
		profileRepository.delete(profile);
		
	}

}
