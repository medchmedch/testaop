package com.example.demo1.service.impl;

import com.example.demo1.service.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.Quiz;
import com.example.demo1.repository.IQuizRepository;

@Service
public class QuizServiceImpl implements IQuizService {
	
	@Autowired
	IQuizRepository qr;
	

	
	public Quiz ajouterQuiz(Quiz q) {
		
		return qr.save(q);
	}

	public Iterable<Quiz> afficherQuiz() {
		return qr.findAll();
	}
	
	public Quiz modifierQuiz(long quiz_id, Quiz quiz) {
		Quiz q = new Quiz();
		q = qr.findById(quiz_id).get();
		q.setQuiz_nom(quiz.getQuiz_nom());		
		return qr.save(q);
	}
	public void supprimerQuiz(long quiz_id) {
		qr.deleteById(quiz_id);
		
	}
}
