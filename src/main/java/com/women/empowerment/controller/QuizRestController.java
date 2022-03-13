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

import com.example.demo1.entity.Quiz;
import com.example.demo1.service.impl.QuizServiceImpl;

@RestController
@RequestMapping(value="/quiz")
public class QuizRestController {
	
	private final QuizServiceImpl qs;
	
	@Autowired
	public QuizRestController(QuizServiceImpl qs) {
		this.qs=qs;
		
	}
	
	@GetMapping(value = "/all")
	public MappingJacksonValue getQuiz() {
		List<Quiz> quizList=(List<Quiz>) qs.afficherQuiz();
		MappingJacksonValue quizMapping = new MappingJacksonValue(quizList);
		
		return quizMapping;
	}
	
	@PostMapping(value = "/add")
	public Quiz addQuiz(@RequestBody Quiz q) {
		return qs.ajouterQuiz(q);
	}
	
	@PutMapping(value = "/edit")
	public Quiz editQuiz(@RequestParam("quiz_id") long quiz_id,@RequestParam Quiz quiz) {
		
		return qs.modifierQuiz(quiz_id, quiz);
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteQuiz (@RequestParam("quiz_id") long quiz_id) {
		qs.supprimerQuiz(quiz_id);
	}

}