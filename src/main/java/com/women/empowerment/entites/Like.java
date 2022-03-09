package com.women.empowerment.entites;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="likes")
public class Like implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idL")
	private int id;
	
	private int nbrLike;
	private int nbDisLike;
	
	@ManyToOne
	Commentaire commentaire;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbrLike() {
		return nbrLike;
	}

	public void setNbrLike(int nbrLike) {
		this.nbrLike = nbrLike;
	}

	public int getNbDisLike() {
		return nbDisLike;
	}

	public void setNbDisLike(int nbDisLike) {
		this.nbDisLike = nbDisLike;
	}

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}



}
