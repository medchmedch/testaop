package com.example.demo1.service.impl;

import com.example.demo1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.User;
import com.example.demo1.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository ur;
	

	
	public User ajouterUser(User u) {
		
		return ur.save(u);
	}

	public Iterable<User> afficherUser() {
		return ur.findAll();
	}
	
	public User modifierUser(long user_id, User user) {
		User u = new User();
		u = ur.findById(user_id).get();
		u.setUser_nom(user.getUser_nom());		
		return ur.save(u);
	}
	public void supprimerUser(long user_id) {
		ur.deleteById(user_id);
		
	}
}
