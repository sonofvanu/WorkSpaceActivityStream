package com.stackroute.activitystream.backend.dao;

import java.util.List;

import com.stackroute.activitystream.backend.model.UserCircleModel;

public interface UserCircleDAO {

	public boolean addUserToCircle(UserCircleModel userCircleModel);

	public List<UserCircleModel> allCircleOfAnUserinWorkspace(int workspaceId, String userEmailId);

}
