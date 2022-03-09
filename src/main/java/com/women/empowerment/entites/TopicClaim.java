package com.women.empowerment.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.dalhia.entities.enumerations.TopicClaimType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class TopicClaim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private LocalDateTime date_created;
    private boolean approved;
    @Enumerated(EnumType.STRING)
    private TopicClaimType topicClaimType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDate_created() {
		return date_created;
	}

	public void setDate_created(LocalDateTime date_created) {
		this.date_created = date_created;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public TopicClaimType getTopicClaimType() {
		return topicClaimType;
	}

	public void setTopicClaimType(TopicClaimType topicClaimType) {
		this.topicClaimType = topicClaimType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}
