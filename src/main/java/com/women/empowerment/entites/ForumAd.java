package com.women.empowerment.entites;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class ForumAd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int viewChannel;
    private LocalDateTime startDate;
    private Date endDate;
    private int expectedViews;
    private int actualViews; // the actual loads of the ad in a page for a user
    private float amount;
    private String imageUrl;
    private String videoUrl;
    private String text;
    private String redirectUrl;
    private int numClicks; // how many times the user clicked on the banned after loading

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_ad_id")
    private ForumAdTarget forumAdTarget;

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

	public int getViewChannel() {
		return viewChannel;
	}

	public void setViewChannel(int viewChannel) {
		this.viewChannel = viewChannel;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getExpectedViews() {
		return expectedViews;
	}

	public void setExpectedViews(int expectedViews) {
		this.expectedViews = expectedViews;
	}

	public int getActualViews() {
		return actualViews;
	}

	public void setActualViews(int actualViews) {
		this.actualViews = actualViews;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public int getNumClicks() {
		return numClicks;
	}

	public void setNumClicks(int numClicks) {
		this.numClicks = numClicks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ForumAdTarget getForumAdTarget() {
		return forumAdTarget;
	}

	public void setForumAdTarget(ForumAdTarget forumAdTarget) {
		this.forumAdTarget = forumAdTarget;
	}
    
    

}
