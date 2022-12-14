package com.women.empowerment.entites;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private LocalDateTime dateSent;
    private LocalDateTime dateRemoved;
    private boolean banned; // when in group chat

    @ManyToOne
    @JoinColumn(name = "user_id")
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

	public LocalDateTime getDateSent() {
		return dateSent;
	}

	public void setDateSent(LocalDateTime dateSent) {
		this.dateSent = dateSent;
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
    
    
}
