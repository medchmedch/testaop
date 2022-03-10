package com.example.demo1.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Quiz implements Serializable {
	@Id @GeneratedValue
	private Long quiz_id;
	private String quiz_nom;
	private String quiz_lvl;
	private double quiz_coef;
	private String quiz_description;
	@ManyToOne
	private Cours cours;	
	@OneToMany(mappedBy="quiz")
	private List<Note> Notes = new ArrayList<Note>();
	@OneToMany(mappedBy="quiz")
	private List<Question> Questions = new ArrayList<Question>();
	
	public Quiz() {
		super();
	}
	
	public Long getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(Long quiz_id) {
		this.quiz_id = quiz_id;
	}
	public String getQuiz_nom() {
		return quiz_nom;
	}
	public void setQuiz_nom(String quiz_nom) {
		this.quiz_nom = quiz_nom;
	}
	public String getQuiz_lvl() {
		return quiz_lvl;
	}
	public void setQuiz_lvl(String quiz_lvl) {
		this.quiz_lvl = quiz_lvl;
	}
	public double getQuiz_coef() {
		return quiz_coef;
	}
	public void setQuiz_coef(double quiz_coef) {
		this.quiz_coef = quiz_coef;
	}
	public String getQuiz_description() {
		return quiz_description;
	}
	public void setQuiz_description(String quiz_description) {
		this.quiz_description = quiz_description;
	}
	@JsonIgnore
	@JsonProperty(value = "cours")
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	@JsonIgnore
	@JsonProperty(value = "Notes")
	public List<Note> getNotes() {return Notes;}
	public void setNotes(List<Note> notes) {
		Notes = notes;
	}
	@JsonIgnore
	@JsonProperty(value = "Questions")
	public List<Question> getQuestions() {
		return Questions;
	}
	public void setQuestions(List<Question> questions) {
		Questions = questions;
	}
	
	
	
	
	
	
	
	
}
