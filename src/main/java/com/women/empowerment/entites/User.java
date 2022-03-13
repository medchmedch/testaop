package com.women.empowerment.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;



	@Entity
	@Data
	public class User {

		public enum Role {
			ROLE_ADMIN,
			ROLE_ORGANIZATION,
			ROLE_WOMAN,
			ROLE_TEACHER,
			ROLE_CANDIDATE,
			ROLE_EXPERT,
			ROLE_GUEST
		}
		public enum Level {
			High_School, Bachelor, Associate_Degree
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idUser;
		private String name;
		private String email;
		private int phone;
		private Date birthday;
		private String address;
		private String picture;
		private String login;
		private String password;
		private Role role;
		
		@OneToMany(mappedBy = "user")
		private List<Appointment> usersAppointments;
		@OneToMany(mappedBy = "user")
		private List<Claim> claims;
}
