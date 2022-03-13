package com.example.demo1.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reponse implements Serializable {
	@Id @GeneratedValue
	private Long r_id;
	private String r_true;
	private String r_false1;
	private String r_false2;
	@OneToOne
	private Question question;
	

	public Reponse() {
		super();
	}


	public Long getR_id() {
		return r_id;
	}


	public void setR_id(Long r_id) {
		this.r_id = r_id;
	}


	public String getR_true() {
		return r_true;
	}


	public void setR_true(String r_true) {
		this.r_true = r_true;
	}


	public String getR_false1() {
		return r_false1;
	}


	public void setR_false1(String r_false1) {
		this.r_false1 = r_false1;
	}


	public String getR_false2() {
		return r_false2;
	}


	public void setR_false2(String r_false2) {
		this.r_false2 = r_false2;
	}

	@JsonIgnore
	@JsonProperty(value = "question")
	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}


	@Override
	public String toString() {
		return "Reponse [r_id=" + r_id + ", r_true=" + r_true + ", r_false1=" + r_false1 + ", r_false2=" + r_false2
				+ ", question=" + question + "]";
	}

	
	
	
}
