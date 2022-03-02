package com.women.empowerment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.women.empowerment.entites.Commentaire;
import com.women.empowerment.repositories.CommentaireRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CommentaireServiceImpl implements ICommentaireService {

	@Autowired
	public CommentaireRepository cr;

	@Override
	public Commentaire ajouterCommentaire(Commentaire c) {
		
		return cr.save(c);
	}

	@Override
	public List<Commentaire> afficherCommentaire () {
		return (List<Commentaire>) cr.findAll();
	}

	@Override
	public Commentaire modifierCommentaire (int idc,String contenu) {
		
		Commentaire c = new Commentaire();
		c = cr.findById(idc).get();
		c.setContenu(contenu);
		c.setDate_pub(new Date());
		
		return cr.save(c);
		
	}

	@Override
	public void  supprimerCommentaire(int idc) {
		cr.deleteById(idc);
	}

	@Override
	public Set<Commentaire> findRecent() {
		return  cr.findTop3ByOrderByLikesNbrLikeDesc();
	}

	@Override
	public Set<Commentaire> getCommentByIdPublication(int idPub) {
		return  cr.findByOrderByPublicationDesc();//cr.findByPubOrderByDateCreation(idPub);
		
	}

	
	
	

}
