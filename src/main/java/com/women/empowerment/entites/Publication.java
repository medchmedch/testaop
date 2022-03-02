package com.women.empowerment.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Publication implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String contenu;
	@Temporal (TemporalType.DATE)
	private Date date_pub;
	
	@ManyToOne
	User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publication")
	private Set<Commentaire> commentaire;
	
	public Set<Commentaire> getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(Set<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}


	public Publication() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public Date getDate_pub() {
		return date_pub;
	}


	public void setDate_pub(Date date_pub) {
		this.date_pub = date_pub;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	
}
