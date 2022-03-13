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

import com.example.demo1.entity.Reponse;
import com.example.demo1.service.impl.ReponseServiceImpl;

@RestController
@RequestMapping(value="/reponse")
public class ReponseRestController {
	
	private final ReponseServiceImpl rs;
	
	@Autowired
	public ReponseRestController(ReponseServiceImpl rs) {
		this.rs=rs;
		
	}
	
	@GetMapping(value = "/all")
	public MappingJacksonValue getReponse() {
		List<Reponse> reponseList=(List<Reponse>) rs.afficherReponse();
		MappingJacksonValue reponseMapping = new MappingJacksonValue(reponseList);
		
		return reponseMapping;
	}
	
	@PostMapping(value = "/add")
	public Reponse addReponse(@RequestBody Reponse r) {
		return rs.ajouterReponse(r);
	}
	
	@PutMapping(value = "/edit")
	public Reponse editReponse(@RequestParam("r_id") long r_id,@RequestParam Reponse reponse) {
		
		return rs.modifierReponse(r_id, reponse);
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteReponse (@RequestParam("r_id") long r_id) {
		rs.supprimerReponse(r_id);
	}

}