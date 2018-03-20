package com.stackroute.activitystream.backend.dao;

import com.stackroute.activitystream.backend.model.UserModel;

public interface UserDAO {
	
	public boolean createuser(UserModel userModel);
	
	public boolean removeUser(String userEmail);
	
	public UserModel singleUser(String userEmail);

}
