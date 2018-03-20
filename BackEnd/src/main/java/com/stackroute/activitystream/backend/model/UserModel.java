package com.stackroute.activitystream.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

@Entity
@Table(name = "USERMODEL")
public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserModel(String userEmail, String userName, String userPassWord, String userFullName, String userStatus,
			boolean isUserActive, Date userJoinedOn) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassWord = userPassWord;
		this.userFullName = userFullName;
		this.userStatus = userStatus;
		this.isUserActive = isUserActive;
		this.userJoinedOn = userJoinedOn;
	}

	public UserModel() {
		super();
	}

	@Id
	@Max(value = 30)
	@Column
	@OneToMany(mappedBy = "usermodel", cascade = CascadeType.ALL)
	private String userEmail;
	@Max(value = 30)
	@Column
	private String userName;
	@Max(value = 15)
	@Column
	private String userPassWord;
	@Max(value = 30)
	@Column
	private String userFullName;
	@Max(value = 10)
	@Column
	private String userStatus;
	@Column
	private boolean isUserActive;
	@Column
	private Date userJoinedOn;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassWord() {
		return userPassWord;
	}

	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public boolean isUserActive() {
		return isUserActive;
	}

	public void setUserActive(boolean isUserActive) {
		this.isUserActive = isUserActive;
	}

	public Date getUserJoinedOn() {
		return userJoinedOn;
	}

	public void setUserJoinedOn() {
		this.userJoinedOn = new Date();
	}

}
