package com.example.demo1.service.impl;

import com.example.demo1.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.Question;
import com.example.demo1.repository.IQuestionRepository;

@Service
public class QuestionServiceImpl implements IQuestionService {
	
	@Autowired
	IQuestionRepository qr;
	

	
	public Question ajouterQuestion(Question q) {
		
		return qr.save(q);
	}

	public Iterable<Question> afficherQuestion() {
		return qr.findAll();
	}
	
	public Question modifierQuestion(long q_id, Question question) {
		Question q = new Question();
		q = qr.findById(q_id).get();
		q.setQ_description(question.getQ_description());


		return qr.save(q);
	}
	public void supprimerQuestion(long q_id) {
		qr.deleteById(q_id);
		
	}
}
