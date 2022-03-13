package com.example.demo1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cours implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long cours_id;
	private String cours_nom;
	private String cours_description;
	private int enr_nbr;
	private boolean cours_status;
	@ManyToOne
	private Sujet sujet;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy="cours")
	private List<Quiz> Quizes = new ArrayList<Quiz>();
	@OneToMany(mappedBy="coursn")
	private List<Note> Notes = new ArrayList<Note>();
	@OneToMany(mappedBy="cours")
	private List<Avertissement> Avertissements = new ArrayList<Avertissement>();
	@ManyToMany
	private List<User> Users;



	public Cours() {
		super();
	}
	public Long getCours_id() {
		return cours_id;
	}
	public void setCours_id(Long cours_id) {
		this.cours_id = cours_id;
	}
	public String getCours_nom() {
		return cours_nom;
	}
	public void setCours_nom(String cours_nom) {
		this.cours_nom = cours_nom;
	}
	public String getCours_description() {
		return cours_description;
	}
	public void setCours_description(String cours_description) {
		this.cours_description = cours_description;
	}
	public int getEnr_nbr() {
		return enr_nbr;
	}
	public void setEnr_nbr(int enr_nbr) {
		this.enr_nbr = enr_nbr;
	}
	public boolean getCours_status() {
		return cours_status;
	}
	public void setCours_status(boolean cours_status) {
		this.cours_status = cours_status;
	}
	@JsonIgnore
	@JsonProperty(value = "sujet")
	public Sujet getSujet() {
		return sujet;
	}
	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}
	@JsonIgnore
	@JsonProperty(value = "user")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@JsonIgnore
	@JsonProperty(value = "Users")
	public List<User> getUsers() {
		return Users;
	}
	public void setUsers(List<User> users) {
		Users = users;
	}
	@JsonIgnore
	@JsonProperty(value = "Notes")
	public List<Note> getNotes() {
		return Notes;
	}
	public void setNotes(List<Note> notes) {
		Notes = notes;
	}
	@JsonIgnore
	@JsonProperty(value = "Quizes")
	public List<Quiz> getQuizes() {
		return Quizes;
	}
	public void setQuizes(List<Quiz> quizes) {
		Quizes = quizes;
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
		return "Cours [cours_id=" + cours_id + ", cours_nom=" + cours_nom + ", cours_description=" + cours_description
				+ ", enr_nbr=" + enr_nbr +", cours_status=" + cours_status + ", sujet=" + sujet.getSujet_nom() + ", user=" + user.getUser_nom() + "]";
	}
		
	
	
	
}
