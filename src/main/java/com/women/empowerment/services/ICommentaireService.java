package com.women.empowerment.services;

import com.women.empowerment.entites.Commentaire;


import java.util.List;
import java.util.Set;

public interface ICommentaireService {
	
	Commentaire ajouterCommentaire (Commentaire c);
	Iterable<Commentaire> afficherCommentaire ();
	Commentaire modifierCommentaire (int idc,String contenu);
	void supprimerCommentaire (int idc);
	Set<Commentaire> findRecent();
	Set<Commentaire> getCommentByIdPublication(int idPub);
	

}
