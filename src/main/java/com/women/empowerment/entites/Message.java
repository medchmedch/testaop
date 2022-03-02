package com.women.empowerment.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class Message implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private int id_dest;
	private int id_resp;
	private String contenu;
	@Temporal (TemporalType.DATE)
	private Date date_envoi;
	
	
	public Message() {
		super();
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_dest() {
		return id_dest;
	}
	public void setId_dest(int id_dest) {
		this.id_dest = id_dest;
	}
	public int getId_resp() {
		return id_resp;
	}
	public void setId_resp(int id_resp) {
		this.id_resp = id_resp;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDate_envoi() {
		return date_envoi;
	}
	public void setDate_envoi(Date date_envoi) {
		this.date_envoi = date_envoi;
	}
	
	

}
