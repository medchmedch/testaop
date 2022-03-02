package com.women.empowerment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.women.empowerment.entites.Message;
import com.women.empowerment.repositories.MessageRepository;

@Service
public class MessageServiceImpl implements IMessageService {

	
	@Autowired
	MessageRepository mr;

	@Override
	public Message ajouterMessage(Message m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message afficherMessage(Message m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message modifierMessage(Message m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message supprimerMessage(Message m) {
		// TODO Auto-generated method stub
		return null;
	}
}
