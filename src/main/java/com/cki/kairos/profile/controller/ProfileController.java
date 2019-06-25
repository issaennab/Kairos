package com.cki.kairos.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cki.kairos.profile.dto.ProfileDto;
import com.cki.kairos.profile.model.Address;
import com.cki.kairos.profile.model.Profile;
import com.cki.kairos.profile.service.ProfileService;
import com.cki.kairos.profile.util.ProfileConvertor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Profile Controller", description = "Supports Profile Account Info")
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	private ProfileService profileService;
	
	@Autowired
	public ProfileController(ProfileService profileService) {
		this.profileService = profileService;
	}

	@ApiOperation(value = "Get a profile by Id", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved a Profile"),
			@ApiResponse(code = 500, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 503, message = "Accessing the resource you were trying to reach is down"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 422, message = "The params have been entered are not vaild.")})
	@GetMapping("/{profileId}")
	public ResponseEntity<Profile> getOne(@PathVariable(name = "profileId") int profileId) {

		Profile profile = profileService.getProfile(profileId);
		if (profile == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(profile, HttpStatus.OK);
	}

	@ApiOperation(value = "List All profiles", response = Iterable.class)
	@GetMapping("")
	public Iterable<Profile> findAllProfiles() {
		return profileService.getAllProfiles();
	}

	@ApiOperation(value = "Create a new profile", response = Iterable.class)
	@PostMapping("")
	public ResponseEntity<Profile> create(@RequestBody ProfileDto profileDto) {

		try {
			
			Profile profile = ProfileConvertor.fromDto(profileDto);
			Profile createdProfile = profileService.createProfile(profile);
			return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);

		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Update an existing profile", response = Iterable.class)
	@PutMapping("")
	public ResponseEntity<Profile> updateprofile(@RequestBody ProfileDto profileDto) {

		try {
			Profile profile = ProfileConvertor.fromDto(profileDto);
			Profile updatedProfile = profileService.updateProfile(profile);
			
			return new ResponseEntity<>(updatedProfile, HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Delete an existing profile by Id", response = Iterable.class)
	@DeleteMapping("/{profileId}")
	public ResponseEntity<String> deleteProfile(@PathVariable(name = "profileId") int profileId) {
		
		// proper validation need to be added here
		profileService.deleteProfile(profileId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@ApiOperation(value = "List all address", response = Iterable.class)
	@GetMapping("/allAddresses")
	public Iterable<Address> findAllAddresses() {
		return profileService.getAllAddresses();
	}
	
}
