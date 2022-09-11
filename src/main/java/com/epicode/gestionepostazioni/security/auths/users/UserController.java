package com.epicode.gestionepostazioni.security.auths.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired UserService userService;
	
	@PostMapping
	public User createUser(@RequestBody User u) {
		return userService.createUser(u);
	}
	
	@GetMapping("/{id}")
	public User readUser(@PathVariable Long id) {
		return userService.readUser(id);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User u) {
		return userService.updateUser(u);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		 userService.deleteUser(id);
	}

}
