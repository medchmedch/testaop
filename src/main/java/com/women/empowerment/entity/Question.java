package com.example.demo1.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Question implements Serializable {
	@Id @GeneratedValue
	private Long q_id;
	private String q_description;
	@ManyToOne
	private Quiz quiz;	
	@OneToOne
	private Reponse reponse;
	
	public Question() {
		super();
	}

	public Long getQ_id() {
		return q_id;
	}

	public void setQ_id(Long q_id) {
		this.q_id = q_id;
	}

	public String getQ_description() {
		return q_description;
	}

	public void setQ_description(String q_description) {
		this.q_description = q_description;
	}
	@JsonIgnore
	@JsonProperty(value = "quiz")
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	@JsonIgnore
	@JsonProperty(value = "reponse")
	public Reponse getReponse() {
		return reponse;
	}

	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}

	@Override
	public String toString() {
		return "Question [q_id=" + q_id + ", q_description=" + q_description + ", quiz=" + quiz + ", reponse=" + reponse
				+ "]";
	}
	
}
