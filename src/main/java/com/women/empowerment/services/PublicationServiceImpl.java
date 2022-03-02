package com.women.empowerment.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.women.empowerment.entites.Publication;
import com.women.empowerment.repositories.PublicationRpository;

@Service
public class PublicationServiceImpl implements IPublicationService {

	
	@Autowired
	PublicationRpository pr;

	@Override
	public Publication ajouterPublication(Publication p) {
		
		return pr.save(p);
	}

	@Override
	public Iterable<Publication> afficherPublication() {
		return pr.findAll();
	}

	@Override
	public Publication modifierPublication(int idp, String contenu) {
		Publication p = new Publication();
		p = pr.findById(idp).get();
		p.setContenu(contenu);
		p.setDate_pub(new Date());
		
		return pr.save(p);
	}

	@Override
	public void supprimerPublication(int idp) {
		pr.deleteById(idp);
		
	}
}
