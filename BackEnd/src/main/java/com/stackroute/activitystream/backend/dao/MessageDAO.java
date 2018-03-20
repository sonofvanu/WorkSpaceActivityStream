package com.stackroute.activitystream.backend.dao;

import java.util.List;

import com.stackroute.activitystream.backend.model.MessageModel;

public interface MessageDAO {
	
	public boolean addMessageAndRemoveMessage(MessageModel messageModel);
	
	public List<MessageModel> allMessageInCircle(int circleId,int workspaceId);
	
	public List<MessageModel> allMessageBetweenUsers(int workspaceId,String UserIdOne,String UserIdTwo);
	
	

}
