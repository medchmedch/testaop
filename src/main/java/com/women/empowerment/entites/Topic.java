package com.women.empowerment.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.dalhia.entities.enumerations.Tag;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String text;
    @Enumerated(EnumType.STRING)
    private Tag tag;
    private int score;
    private LocalDateTime datePublished;
    private LocalDateTime dateRemoved;
    private boolean banned;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TopicRate> topicRateList;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ForumComment> forumComments;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TopicClaim> topicClaims;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public LocalDateTime getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(LocalDateTime datePublished) {
		this.datePublished = datePublished;
	}

	public LocalDateTime getDateRemoved() {
		return dateRemoved;
	}

	public void setDateRemoved(LocalDateTime dateRemoved) {
		this.dateRemoved = dateRemoved;
	}

	public boolean isBanned() {
		return banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	public List<TopicRate> getTopicRateList() {
		return topicRateList;
	}

	public void setTopicRateList(List<TopicRate> topicRateList) {
		this.topicRateList = topicRateList;
	}

	public List<ForumComment> getForumComments() {
		return forumComments;
	}

	public void setForumComments(List<ForumComment> forumComments) {
		this.forumComments = forumComments;
	}

	public List<TopicClaim> getTopicClaims() {
		return topicClaims;
	}

	public void setTopicClaims(List<TopicClaim> topicClaims) {
		this.topicClaims = topicClaims;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    
}
