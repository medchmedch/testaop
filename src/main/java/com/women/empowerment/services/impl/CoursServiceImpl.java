package com.example.demo1.service.impl;

import com.example.demo1.entity.Note;
import com.example.demo1.entity.User;
import com.example.demo1.repository.IUserRepository;
import com.example.demo1.service.ICoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.Cours;
import com.example.demo1.repository.ICoursRepository;

import java.util.List;
import java.util.function.Predicate;

@Service
public class CoursServiceImpl implements ICoursService {
	
	@Autowired
	ICoursRepository cr;
	@Autowired
	IUserRepository ur;


	
	public Cours ajouterCours(Cours c) {
		
		return cr.save(c);
	}

	public Iterable<Cours> afficherCours() {
		return cr.findAll();
	}
	
	public Cours modifierCours_description(long cours_id, String cours_description) {
		Cours c = new Cours();
		c = cr.findById(cours_id).get();
		c.setCours_description(cours_description);
		return cr.save(c);
	}
	public Cours modifierCours_nom(long cours_id, String cours_nom) {
		Cours c = new Cours();
		c = cr.findById(cours_id).get();
		c.setCours_nom(cours_nom);
		return cr.save(c);
	}
	public Cours modifierCours_enr_nbr(long cours_id) {
		Cours c = new Cours();
		c = cr.findById(cours_id).get();

		c.setEnr_nbr(c.getUsers().size());
		return cr.save(c);
	}
	public Cours modifierCours_status(long cours_id) {
		Cours c = new Cours();
		c = cr.findById(cours_id).get();
		c.setCours_status(true);
		return cr.save(c);
	}
	public String addUsertocours(long cours_id, long user_id) {


		Cours c = cr.findById(cours_id).get();
		int exist;
		exist=0;
		List<User> n = c.getUsers();
		if(c.getCours_status()==true)
		{

		for (User element : n){if(element.getUser_id()==user_id){exist=1;}}

		if(exist==0){
			c.getUsers().add(ur.findById(user_id).get());
			c.setEnr_nbr(c.getUsers().size());
		cr.save(c);
		return " utilisateur ajouté";}else{return "L'utilisateur est deja associé au cours";}
		}else{return "Course have not been approved yet";}
	}
	public void supprimerCours(long cours_id) {
		cr.deleteById(cours_id);
		
	}
}
