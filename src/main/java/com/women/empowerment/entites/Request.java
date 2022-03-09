package com.women.empowerment.entites;


import tn.dalhia.entities.enumerations.RequestStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RequestId;
    private String RequestBody;
    private String RequestHeader;

    @Temporal(TemporalType.DATE)
    private Date RequestDate;

    @Enumerated(EnumType.STRING)
    private RequestStatus Status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public Integer getRequestId() {
		return RequestId;
	}

	public void setRequestId(Integer requestId) {
		RequestId = requestId;
	}

	public String getRequestBody() {
		return RequestBody;
	}

	public void setRequestBody(String requestBody) {
		RequestBody = requestBody;
	}

	public String getRequestHeader() {
		return RequestHeader;
	}

	public void setRequestHeader(String requestHeader) {
		RequestHeader = requestHeader;
	}

	public Date getRequestDate() {
		return RequestDate;
	}

	public void setRequestDate(Date requestDate) {
		RequestDate = requestDate;
	}

	public RequestStatus getStatus() {
		return Status;
	}

	public void setStatus(RequestStatus status) {
		Status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    

}