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
@Table(name = "MESSAGEMODEL")
public class MessageModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	public MessageModel(int messageId, int workSpaceId, int circleId, String messageContent, String senderId,
			String receiverId, boolean messageVisibility, Date messageSentOn) {
		super();
		this.messageId = messageId;
		this.workSpaceId = workSpaceId;
		this.circleId = circleId;
		this.messageContent = messageContent;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.messageVisibility = messageVisibility;
		this.messageSentOn = messageSentOn;
	}
	
	

	public MessageModel() {
		super();
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int messageId;
	@Column
	private int workSpaceId;
	@Column
	private int circleId;
	@Column
	private String messageContent;
	@Max(value = 30)
	@Column
	private String senderId;
	@Max(value = 30)
	@Column
	private String receiverId;
	@Column
	private boolean messageVisibility;
	@Column
	private Date messageSentOn;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getWorkSpaceId() {
		return workSpaceId;
	}

	public void setWorkSpaceId(int workSpaceId) {
		this.workSpaceId = workSpaceId;
	}

	public int getCircleId() {
		return circleId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public boolean isMessageVisibility() {
		return messageVisibility;
	}

	public void setMessageVisibility(boolean messageVisibility) {
		this.messageVisibility = messageVisibility;
	}

	public Date getMessageSentOn() {
		return messageSentOn;
	}

	public void setMessageSentOn() {
		this.messageSentOn = new Date();
	}

}
