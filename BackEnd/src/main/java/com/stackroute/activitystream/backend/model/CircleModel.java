package com.stackroute.activitystream.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

@Entity
@Table(name = "CIRCLEMODEL")
public class CircleModel implements Serializable {

	private static final long serialVersionUID = 1L;

	public CircleModel(int circleId, int workSpaceId, String workSpaceName, String userEmailId, String circleName,
			boolean isCircleExist, Date circleCreatedOn) {
		super();
		this.circleId = circleId;
		this.workSpaceId = workSpaceId;
		this.workSpaceName = workSpaceName;
		this.userEmailId = userEmailId;
		this.circleName = circleName;
		this.isCircleExist = isCircleExist;
		this.circleCreatedOn = circleCreatedOn;
	}

	public CircleModel() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(mappedBy = "circlemodel", cascade = CascadeType.ALL)
	private int circleId;
	@ManyToOne
	@JoinColumn(name = "WORKSPACE_WORKSPACEID")
	private int workSpaceId;
	@Max(value = 50)
	@Column
	private String workSpaceName;
	@ManyToOne
	@JoinColumn(name = "USERMODEL_USEREMAIL")
	private String userEmailId;
	@Max(value = 20)
	@Column
	@OneToMany(mappedBy = "circlemodel", cascade = CascadeType.ALL)
	private String circleName;
	@Column
	private boolean isCircleExist;
	@Column
	private Date circleCreatedOn;

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

	public String getWorkSpaceName() {
		return workSpaceName;
	}

	public void setWorkSpaceName(String workSpaceName) {
		this.workSpaceName = workSpaceName;
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

	public boolean isCircleExist() {
		return isCircleExist;
	}

	public void setCircleExist(boolean isCircleExist) {
		this.isCircleExist = isCircleExist;
	}

	public Date getCircleCreatedOn() {
		return circleCreatedOn;
	}

	public void setCircleCreatedOn() {
		this.circleCreatedOn = new Date();
	}

}
