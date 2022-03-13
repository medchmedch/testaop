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

import com.example.demo1.entity.Sujet;
import com.example.demo1.service.impl.SujetServiceImpl;

@RestController
@RequestMapping(value="/sujet")
public class SujetRestController {
	
	private final SujetServiceImpl ss;
	
	@Autowired
	public SujetRestController(SujetServiceImpl ss) {
		this.ss=ss;
		
	}
	
	@GetMapping(value = "/all")
	public MappingJacksonValue getSujet() {
		List<Sujet> sujetList=(List<Sujet>) ss.afficherSujet();
		MappingJacksonValue sujetsMapping = new MappingJacksonValue(sujetList);
		
		return sujetsMapping;
	}
	
	@PostMapping(value = "/add")
	public Sujet addSujet(@RequestBody Sujet s) {
		return ss.ajouterSujet(s);
	}
	
	@PutMapping(value = "/edit")
	public Sujet editSujet(@RequestParam("sujet_id") long sujet_id,@RequestBody Sujet sujet) {
		
		return ss.modifierSujet(sujet_id, sujet);
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteSujet (@RequestParam("sujet_id") long sujet_id) {
		ss.supprimerSujet(sujet_id);
	}

}