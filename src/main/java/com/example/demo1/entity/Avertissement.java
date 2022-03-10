package com.example.demo1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Avertissement implements Serializable {

    @Id @GeneratedValue
    private Long av_id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Cours cours;


    public Long getAv_id() {
        return av_id;
    }

    @JsonIgnore
    @JsonProperty(value = "user")
    public User getUser() {
        return user;
    }
    @JsonIgnore
    @JsonProperty(value = "cours")
    public Cours getCours() {
        return cours;
    }

    public void setAv_id(Long av_id) {
        this.av_id = av_id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    @Override
    public String toString() {
        return "Avertissement{" +
                "av_id=" + av_id +
                ", user=" + user +
                ", cours=" + cours +
                '}';
    }
}
