package com.stackroute.activitystream.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

@Entity
@Table(name = "WORKSPACEMODEL")
public class WorkspaceModel implements Serializable {

	private static final long serialVersionUID = 1L;

	public WorkspaceModel(int workSpaceId, String workSpaceName, String workSpaceAdminName, String workSpaceAdminPassword,
			Date workSpaceCreatedOn, boolean isWorkSpaceActive, String workSpaceUrl) {
		super();
		this.workSpaceId = workSpaceId;
		this.workSpaceName = workSpaceName;
		this.workSpaceAdminEmailId = workSpaceAdminName;
		this.workSpaceAdminPassword = workSpaceAdminPassword;
		this.workSpaceCreatedOn = workSpaceCreatedOn;
		this.isWorkSpaceActive = isWorkSpaceActive;
		this.workSpaceUrl = workSpaceUrl;
	}

	public WorkspaceModel() {
		super();
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int workSpaceId;
	@Column
	@Max(value = 50)
	private String workSpaceName;
	@Column
	@Max(value = 30)
	private String workSpaceAdminEmailId;
	@Column
	@Max(value = 15)
	private String workSpaceAdminPassword;
	@Column
	private Date workSpaceCreatedOn;
	@Column
	private boolean isWorkSpaceActive;
	@Max(value = 25)
	@Column(unique = true)
	private String workSpaceUrl;

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

	public String getworkSpaceAdminEmailId() {
		return workSpaceAdminEmailId;
	}

	public void setworkSpaceAdminEmailId(String workSpaceAdminEmailId) {
		this.workSpaceAdminEmailId = workSpaceAdminEmailId;
	}

	public String getWorkSpaceAdminPassword() {
		return workSpaceAdminPassword;
	}

	public void setWorkSpaceAdminPassword(String workSpaceAdminPassword) {
		this.workSpaceAdminPassword = workSpaceAdminPassword;
	}

	public Date getWorkSpaceCreatedOn() {
		return workSpaceCreatedOn;
	}

	public void setWorkSpaceCreatedOn(Date workSpaceCreatedOn) {
		this.workSpaceCreatedOn = workSpaceCreatedOn;
	}

	public boolean isWorkSpaceActive() {
		return isWorkSpaceActive;
	}

	public void setWorkSpaceActive(boolean isWorkSpaceActive) {
		this.isWorkSpaceActive = isWorkSpaceActive;
	}

	public String getWorkSpaceUrl() {
		return workSpaceUrl;
	}

	public void setWorkSpaceUrl(String workSpaceUrl) {
		this.workSpaceUrl = workSpaceUrl;
	}

}
