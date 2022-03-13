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

import com.example.demo1.entity.Cours;
import com.example.demo1.service.impl.CoursServiceImpl;

@RestController
@RequestMapping(value="/cours")
public class CoursRestController {
	
	private final CoursServiceImpl cs;
	
	@Autowired
	public CoursRestController(CoursServiceImpl cs) {
		this.cs=cs;
		
	}
	
	@GetMapping(value = "/all")
	public MappingJacksonValue getCours() {
		List<Cours> coursList=(List<Cours>) cs.afficherCours();
		MappingJacksonValue coursMapping = new MappingJacksonValue(coursList);
		
		return coursMapping;
	}
	
	@PostMapping(value = "/add")
	public Cours addCours(@RequestBody Cours c) {
		return cs.ajouterCours(c);
	}
	
	@PutMapping(value = "/edit_d")
	public Cours editCours_description(@RequestParam("cours_id") long cours_id,@RequestParam String cours_description) {
		
		return cs.modifierCours_description(cours_id, cours_description);
	}
	@PutMapping(value = "/edit_n")
	public Cours editCours_nom(@RequestParam("cours_id") long cours_id,@RequestParam String cours_nom) {

		return cs.modifierCours_nom(cours_id, cours_nom);
	}
	@PutMapping(value = "/edit_enr")
	public Cours editCours_enr_nbr(@RequestParam("cours_id") long cours_id) {

		return cs.modifierCours_enr_nbr(cours_id);
	}
	@PutMapping(value = "/confirm")
	public Cours editCours_status(@RequestParam("cours_id") long cours_id) {

		return cs.modifierCours_status(cours_id);
	}
	@PutMapping(value = "/joincours")
	public String join_cours(@RequestParam("cours_id") long cours_id,@RequestParam("user_id") long user_id) {

		return cs.addUsertocours(cours_id, user_id);
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteCours (@RequestParam("cours_id") long cours_id) {
		cs.supprimerCours(cours_id);
	}

}