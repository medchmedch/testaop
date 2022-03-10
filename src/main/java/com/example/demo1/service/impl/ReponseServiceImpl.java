package com.example.demo1.service.impl;

import com.example.demo1.service.IReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.Reponse;
import com.example.demo1.repository.IReponseRepository;

@Service
public class ReponseServiceImpl implements IReponseService {
	
	@Autowired
	IReponseRepository rr;
	

	
	public Reponse ajouterReponse(Reponse r) {
		
		return rr.save(r);
	}

	public Iterable<Reponse> afficherReponse() {
		return rr.findAll();
	}
	
	public Reponse modifierReponse(long r_id, Reponse reponse) {
		Reponse r = new Reponse();
		r = rr.findById(r_id).get();
		r.setR_true(reponse.getR_true());		
		r.setR_false1(reponse.getR_false1());
		r.setR_false2(reponse.getR_false2());


		return rr.save(r);
	}
	public void supprimerReponse(long r_id) {
		rr.deleteById(r_id);
		
	}
}
