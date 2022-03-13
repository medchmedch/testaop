package com.women.empowerment.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;




@Entity
@Data
public class Appointment {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idApp;
	private String title;
	private Date date;
	@ManyToOne
	private User user;
}
