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

import com.example.demo1.entity.Question;
import com.example.demo1.service.impl.QuestionServiceImpl;

@RestController
@RequestMapping(value="/question")
public class QuestionRestController {
	
	private final QuestionServiceImpl qs;
	
	@Autowired
	public QuestionRestController(QuestionServiceImpl qs) {
		this.qs=qs;
		
	}
	
	@GetMapping(value = "/all")
	public MappingJacksonValue getQuestion() {
		List<Question> questionList=(List<Question>) qs.afficherQuestion();
		MappingJacksonValue questionMapping = new MappingJacksonValue(questionList);
		
		return questionMapping;
	}
	
	@PostMapping(value = "/add")
	public Question addQuestion(@RequestBody Question q) {
		return qs.ajouterQuestion(q);
	}
	
	@PutMapping(value = "/edit")
	public Question editQuestion(@RequestParam("q_id") long q_id,@RequestParam Question question) {
		
		return qs.modifierQuestion(q_id, question);
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteQuestion (@RequestParam("q_id") long q_id) {
		qs.supprimerQuestion(q_id);
	}

}