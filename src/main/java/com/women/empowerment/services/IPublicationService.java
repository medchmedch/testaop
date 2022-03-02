package com.women.empowerment.services;

import com.women.empowerment.entites.Publication;

public interface IPublicationService {
	
	Publication ajouterPublication(Publication p);
	Iterable<Publication> afficherPublication();
	Publication modifierPublication( int idp, String contenu);
	void supprimerPublication(int idp);


}
