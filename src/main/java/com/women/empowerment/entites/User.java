package com.women.empowerment.entites;

import tn.dalhia.entities.enumerations.Job;
import tn.dalhia.entities.enumerations.Role;
import tn.dalhia.entities.enumerations.Speciality;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(nullable = false)
    private String first_name;
    private String last_name;
    @Column(unique = true)
    private String email;
    private String phone;
    @Column(nullable = false)
    private String password;
    private Date date_birth;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private LocalTime start_hour; //?? time ? e.g: 19:50
    private LocalTime end_hour; //?? time ? e.g: 19:50
    private Job job;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

 

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //bi
    private List<Topic> topics; //?? to ask about comments





}
