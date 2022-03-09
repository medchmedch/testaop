package com.women.empowerment.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String FullName;
    private Double donation;
    @ManyToMany
    @JsonIgnore
    private List<Events> events;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;
}
