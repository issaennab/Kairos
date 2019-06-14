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

import com.cki.kairos.profile.dto.UserDto;
import com.cki.kairos.profile.model.Address;
import com.cki.kairos.profile.model.User;
import com.cki.kairos.profile.service.UserService;
import com.cki.kairos.profile.util.UserConvertor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "User Controller", description = "Supports User Account Info")
@RestController
@RequestMapping("/api/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "Get a user by Id", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved a User"),
			@ApiResponse(code = 500, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 503, message = "Accessing the resource you were trying to reach is down"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 422, message = "The params have been entered are not vaild.")})
	@GetMapping("/{userId}")
	public ResponseEntity<User> getOne(@PathVariable(name = "userId") int userId) {

		User user = userService.getUser(userId);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "List All Users", response = Iterable.class)
	@GetMapping("/listAll")
	public Iterable<User> findAllUsers() {
		return userService.getAllUsers();
	}

	@ApiOperation(value = "Create a new user", response = Iterable.class)
	@PostMapping("")
	public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {

		try {
			
			User user = UserConvertor.fromDto(userDto);
			User createdUser = userService.createUser(user);
			return new ResponseEntity<>(UserConvertor.toDto(createdUser), HttpStatus.CREATED);

		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Update an existing user", response = Iterable.class)
	@PutMapping("")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {

		try {
			User user = UserConvertor.fromDto(userDto);
			User updatedUser = userService.updateUser(user);
			
			return new ResponseEntity<>(UserConvertor.toDto(updatedUser), HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Delete an existing user by Id", response = Iterable.class)
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable(name = "userId") int userId) {
		
		// proper validation need to be added here
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
		
	}
	
	@ApiOperation(value = "List all address", response = Iterable.class)
	@GetMapping("/allAddresses")
	public Iterable<Address> findAllAddresses() {
		return userService.getAllAddresses();
	}
	
}
