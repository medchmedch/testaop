package com.women.empowerment.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv")
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    private String proffession;
    private String skils;
    private String Education;
    private String Hobies;

    @OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Postulant> postulants;


}
