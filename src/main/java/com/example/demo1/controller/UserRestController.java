package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.entity.User;
import com.example.demo1.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value="/user")
public class UserRestController {
	
	private final UserServiceImpl us;
	
	@Autowired
	public UserRestController(UserServiceImpl us) {
		this.us=us;
		
	}
	
	@GetMapping(value = "/all")
	public MappingJacksonValue getUser() {
		List<User> userList=(List<User>) us.afficherUser();
		MappingJacksonValue userMapping = new MappingJacksonValue(userList);
		
		return userMapping;
	}
	
	@PostMapping(value = "/add")
	public User addUser(@RequestBody User u) {
		return us.ajouterUser(u);
	}
	
	@PutMapping(value = "/edit")
	public User editUser(@RequestParam("user_id") long user_id,@RequestParam User user) {
		
		return us.modifierUser(user_id, user);
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteUser (@RequestParam("user_id") long user_id) {
		us.supprimerUser(user_id);
	}

}