package com.stackroute.activitystream.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

@Entity
@Table(name = "USERCIRCLEMODEL")
public class UserCircleModel implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserCircleModel(int userCircleId, int circleId, int workSpaceId, String userEmailId, String circleName,
			boolean circleStatus, Date joinedOn) {
		super();
		this.userCircleId = userCircleId;
		this.circleId = circleId;
		this.workSpaceId = workSpaceId;
		this.userEmailId = userEmailId;
		this.circleName = circleName;
		this.circleStatus = circleStatus;
		this.joinedOn = joinedOn;
	}

	public UserCircleModel() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int userCircleId;
	@Column
	private int circleId;
	@Column
	private int workSpaceId;
	@Max(value = 30)
	private String userEmailId;
	@Column
	private String circleName;
	@Column
	private boolean circleStatus;
	@Column
	private Date joinedOn;

	public int getUserCircleId() {
		return userCircleId;
	}

	public void setUserCircleId(int userCircleId) {
		this.userCircleId = userCircleId;
	}

	public int getCircleId() {
		return circleId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}

	public int getWorkSpaceId() {
		return workSpaceId;
	}

	public void setWorkSpaceId(int workSpaceId) {
		this.workSpaceId = workSpaceId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public boolean isCircleStatus() {
		return circleStatus;
	}

	public void setCircleStatus(boolean circleStatus) {
		this.circleStatus = circleStatus;
	}

	public Date getJoinedOn() {
		return joinedOn;
	}

	public void setJoinedOn() {
		this.joinedOn = new Date();
	}

}
