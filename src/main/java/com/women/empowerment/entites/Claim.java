package com.women.empowerment.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.Data;



@Entity
@Data
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClaim;
	
	public enum Categories {
		Technical, Account, Security
	}

	private String subject;

	private String description;
	private Categories category;
	private String file;
	@Temporal(TemporalType.DATE)
	private Date date;

	
	@ManyToOne
	private User user;
}
