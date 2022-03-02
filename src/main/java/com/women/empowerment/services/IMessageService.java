package com.women.empowerment.services;

import com.women.empowerment.entites.Message;

public interface IMessageService {
	
	Message ajouterMessage(Message m);
	Message afficherMessage(Message m);
	Message modifierMessage(Message m);
	Message supprimerMessage(Message m);


}
