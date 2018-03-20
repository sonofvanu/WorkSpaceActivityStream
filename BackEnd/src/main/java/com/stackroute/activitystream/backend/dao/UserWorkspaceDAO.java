package com.stackroute.activitystream.backend.dao;

import java.util.List;

import com.stackroute.activitystream.backend.model.UserWorkspaceModel;

public interface UserWorkspaceDAO {

	public boolean addUserToWorkspace(UserWorkspaceModel userWorkSpace);
	
	public List<UserWorkspaceModel> allWorkspaceOfUser(String userEmail); 
	
	public boolean leaveWorkspace(int userWorkspaceId);
	
	public UserWorkspaceModel singleUserWorkspace(int userWorkspaceId);
}
