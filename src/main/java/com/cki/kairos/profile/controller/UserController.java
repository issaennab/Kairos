package com.cki.kairos.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cki.kairos.profile.model.User;
import com.cki.kairos.profile.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "User Controller", description = "Supports User Info")
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
	
	@GetMapping("")
	public Iterable<User> findAllUser() {
		return userService.getAllUsers();
	}
}
