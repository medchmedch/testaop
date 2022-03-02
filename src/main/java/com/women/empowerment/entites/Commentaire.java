package com.women.empowerment.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Commentaire implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "idC")
	private int id;
	
	private String contenu;
	@Temporal (TemporalType.DATE)
	private Date date_pub;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commentaire")
	private Set<Like> likes;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
	User user;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
	Publication publication;
	
	public Set<Like> getLikes() {
		return likes;
	}

	

	public void setLikes(Set<Like> likes) {
		this.likes = likes;
	}


	public Commentaire() {
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



	public Publication getPublication() {
		return publication;
	}



	public void setPublication(Publication publication) {
		this.publication = publication;
	}


	
	

}
