package com.women.empowerment.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity

public class ForumComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private LocalDateTime datePublished;
    private LocalDateTime dateRemoved;
    private boolean banned;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CommentReaction> commentReactionList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ForumComment> replies;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CommentReaction> getCommentReactionList() {
		return commentReactionList;
	}

	public void setCommentReactionList(List<CommentReaction> commentReactionList) {
		this.commentReactionList = commentReactionList;
	}

	public List<ForumComment> getReplies() {
		return replies;
	}

	public void setReplies(List<ForumComment> replies) {
		this.replies = replies;
	}
    
    
}
