package com.example.demo1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Sujet implements Serializable {

	@Id @GeneratedValue
	private Long sujet_id;
	private String sujet_nom;
	@OneToMany(mappedBy="sujet")
	private List<Cours> Courses = new ArrayList<Cours>();
	
	public Sujet() {
		super();
	}



	public Long getSujet_id() {
		return sujet_id;
	}

	public void setSujet_id(Long sujet_id) {
		this.sujet_id = sujet_id;
	}

	public String getSujet_nom() {
		return sujet_nom;
	}

	public void setSujet_nom(String sujet_nom) {
		this.sujet_nom = sujet_nom;
	}

	@JsonIgnore
	@JsonProperty(value = "Courses")
	public List<Cours> getCourses() {
		return Courses;
	}

	public void setCourses(List<Cours> courses) {
		Courses = courses;
	}

	@Override
	public String toString() {
		return "Sujet [sujet_id=" + sujet_id + ", sujet_nom=" + sujet_nom + ", Courses=" + Courses + "]";
	}

	
}
