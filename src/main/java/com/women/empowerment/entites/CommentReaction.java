package com.women.empowerment.entites;


import tn.dalhia.entities.enumerations.ReactionType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class CommentReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public ReactionType getReactionType() {
		return reactionType;
	}
	public void setReactionType(ReactionType reactionType) {
		this.reactionType = reactionType;
	}
    
    
}
