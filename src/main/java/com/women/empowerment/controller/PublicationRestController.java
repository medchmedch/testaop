package com.women.empowerment.controller;

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

import com.women.empowerment.entites.Publication;
import com.women.empowerment.services.PublicationServiceImpl;

@RestController
@RequestMapping(value="/publication")
public class PublicationRestController {
	
	private final PublicationServiceImpl ps;
	
	@Autowired
	public PublicationRestController(PublicationServiceImpl ps) {
		this.ps=ps;
		
	}
	
	@GetMapping(value = "/all")
	public MappingJacksonValue getPublication() {
		List<Publication> publicationList=(List<Publication>) ps.afficherPublication();
		MappingJacksonValue publicationsMapping = new MappingJacksonValue(publicationList);
		
		return publicationsMapping;
	}
	
	@PostMapping(value = "/add")
	public Publication addPublication(@RequestBody Publication p) {
		return ps.ajouterPublication(p);
	}
	
	@PutMapping(value = "/edit")
	public Publication editPublication(@RequestParam("idp") int id,@RequestParam("contenu") String contenu) {
		
		return ps.modifierPublication(id, contenu);
	}
	
	@DeleteMapping(value = "/delete")
	public void deletePublication (@RequestParam("idp") int idp) {
		ps.supprimerPublication(idp);
	}

}
