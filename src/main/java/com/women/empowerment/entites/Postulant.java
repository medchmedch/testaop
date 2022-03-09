package com.women.empowerment.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "postulant")
public class Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private int age;
    private boolean answer;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Offers offers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Cv cv;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

    public boolean getAnswer() {
        return this.answer;
    }
}
