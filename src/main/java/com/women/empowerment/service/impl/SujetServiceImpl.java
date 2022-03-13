package com.example.demo1.service.impl;

import com.example.demo1.service.ISujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.Sujet;
import com.example.demo1.repository.ISujetRepository;

@Service
public class SujetServiceImpl implements ISujetService {
	
	@Autowired
	ISujetRepository sr;
	

	
	public Sujet ajouterSujet(Sujet s) {
		
		return sr.save(s);
	}

	public Iterable<Sujet> afficherSujet() {
		return sr.findAll();
	}
	
	public Sujet modifierSujet(long sujet_id, Sujet sujet) {
		Sujet s = new Sujet();
		s = sr.findById(sujet_id).get();
		s.setSujet_nom(sujet.getSujet_nom());		
		return sr.save(s);
	}
	public void supprimerSujet(long sujet_id) {
		sr.deleteById(sujet_id);
		
	}
}
