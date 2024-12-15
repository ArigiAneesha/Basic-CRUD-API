package com.aneesha.io.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aneesha.io.Service.UserService;
import com.aneesha.io.pojo.User;
import com.aneesha.io.pojo.UserRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
		@Autowired
		private UserService userService;
		
		
		@GetMapping
		public List<User> getAllUsers(){
			return userService.getAllUsers();
		}
		
		
		
		@PostMapping
		public ResponseEntity<?> createUser(@Valid @RequestBody UserRequest userRequest) {

			 return ResponseEntity.ok(userService.createUser(userRequest));
		}
		
		
		@GetMapping("/{id}")
		public User getUserById(@PathVariable Long id) {
			return userService.getUserById(id);
		}
		
		@PutMapping("/{id}")
		public User updateUser(@PathVariable Long id, @RequestBody User user) {
			return userService.updateUser(id, user);
		}
		
		@DeleteMapping("/{id}")
		public String deleteUser(@PathVariable Long id) {
			userService.deleteUser(id);
			return "user deleted";
		}
}
