package com.example.demo1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Note implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long note_id;
	private double note_val;
	private String note_description;
	@ManyToOne
	private Quiz quiz;
	@ManyToOne
	private Cours coursn;
	@ManyToOne
	private User user;

	public Note() {
		super();
	}
	public Long getNote_id() {
		return note_id;
	}
	public void setNote_id(Long note_id) {
		this.note_id = note_id;
	}
	public double getNote_val() {
		return note_val;
	}
	public void setNote_val(double note_val) {
		this.note_val = note_val;
	}
	public String getNote_description() {
		return note_description;
	}
	public void setNote_description(String note_description) {
		this.note_description = note_description;
	}
	@JsonIgnore
	@JsonProperty(value = "quiz")
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {this.quiz = quiz;}
	@JsonIgnore
	@JsonProperty(value = "coursn")
	public Cours getCoursn() {
		return coursn;
	}
	public void setCoursn(Cours coursn) {this.coursn = coursn;}
	@JsonIgnore
	@JsonProperty(value = "user")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Note [note_id=" + note_id + ", note_val=" + note_val + ", note_description=" + note_description
				+ ", quiz=" + quiz + ", user=" + user + "]";
	}
	
	
	
	
	
	
	
	
	
}
