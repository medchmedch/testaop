package com.example.demo1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class User implements Serializable {

	@Id @GeneratedValue
	private Long user_id;
	private String user_nom;
	@OneToMany(mappedBy="user")
	private List<Cours> Courses = new ArrayList<Cours>();
	@OneToMany(mappedBy="user")
	private List<Note> Notes = new ArrayList<Note>();
	@OneToMany(mappedBy="user")
	private List<Avertissement> Avertissements = new ArrayList<Avertissement>();
	@ManyToMany(mappedBy="Users")
	private List<Cours> Coursesu;
	
	public User() {
		super();
	}

	
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_nom() {
		return user_nom;
	}

	public void setUser_nom(String user_nom) {
		this.user_nom = user_nom;
	}

	@JsonIgnore
	@JsonProperty(value = "Courses")
	public List<Cours> getCourses() {
		return Courses;
	}

	@JsonIgnore
	@JsonProperty(value = "Coursesu")
	public List<Cours> getCoursesu() {
		return Coursesu;
	}
	public void setCoursesu(List<Cours> coursesu) {
		Coursesu = coursesu;
	}
	public void setCourses(List<Cours> courses) {
		Courses = courses;
	}
	@JsonIgnore
	@JsonProperty(value = "Avertissements")
	public List<Avertissement> getAvertissments() {
		return Avertissements;
	}
	public void setAvertissments(List<Avertissement> avertissments) {
		Avertissements = avertissments;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_nom=" + user_nom + ", Courses=" + Courses + "]";
	}



	
}
