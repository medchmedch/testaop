package com.women.empowerment.entites;


import javax.persistence.*;

@Entity
public class ForumAdTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int ageMax;
    private int ageMin;
    private int donationCount; // the donation made count
    private int applicationCount; // the ad shows to who has the application to offers
    private int certCount; // the ad shows to who has a certificate equal to that number or more
    private boolean any; // any criteria
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAgeMax() {
		return ageMax;
	}
	public void setAgeMax(int ageMax) {
		this.ageMax = ageMax;
	}
	public int getAgeMin() {
		return ageMin;
	}
	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}
	public int getDonationCount() {
		return donationCount;
	}
	public void setDonationCount(int donationCount) {
		this.donationCount = donationCount;
	}
	public int getApplicationCount() {
		return applicationCount;
	}
	public void setApplicationCount(int applicationCount) {
		this.applicationCount = applicationCount;
	}
	public int getCertCount() {
		return certCount;
	}
	public void setCertCount(int certCount) {
		this.certCount = certCount;
	}
	public boolean isAny() {
		return any;
	}
	public void setAny(boolean any) {
		this.any = any;
	}

    
}
