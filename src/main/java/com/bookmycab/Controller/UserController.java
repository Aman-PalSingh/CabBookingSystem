package com.bookmycab.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookmycab.Entities.User;
import com.bookmycab.Exceptions.UserException;
import com.bookmycab.Service.UserService;

// TODO: Completely remove User Controller

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public User saveUserHandler(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/users")
	public List<User> getAllUserHandler() {
		return userService.getAllUser();
	}

	@GetMapping("/users/{id}")
	public User getUserHandler(@PathVariable("id") Integer id) {
		return userService.getUserById(id);
	}

	@PutMapping("/users/{id}")
	public User updateUserHandler(@PathVariable("id") Integer id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUserHandler(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("User deleted with id!" + id, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<String> userLoginHandler(@RequestBody User user) {

		try {
			boolean loginSuccessful = userService.loginUser(user);
			if (loginSuccessful)
				return new ResponseEntity<>("login successful", HttpStatus.OK);
			return new ResponseEntity<>("passwords don't match", HttpStatus.UNAUTHORIZED);
		} catch (UserException e) {
			return new ResponseEntity<>("User does not exist", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/login/{id}")
	public boolean isLoggedIn(@PathVariable("id") Integer id) {
		User user = new User();
		user.setUserId(id);
		return userService.isLoggedIn(user);
	}

	@GetMapping("/logout/{id}")
	public ResponseEntity<String> logout(@PathVariable("id") Integer id) {
		User user = new User();
		user.setUserId(id);
		boolean successful = userService.logoutUser(user);
		if (successful)
			return new ResponseEntity<>("User logged out successfully", HttpStatus.OK);
		return new ResponseEntity<>("User not logged in", HttpStatus.BAD_REQUEST);
	}
}
