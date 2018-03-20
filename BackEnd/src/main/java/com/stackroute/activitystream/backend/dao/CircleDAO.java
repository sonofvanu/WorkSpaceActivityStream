package com.stackroute.activitystream.backend.dao;

import java.util.List;

import com.stackroute.activitystream.backend.model.CircleModel;

public interface CircleDAO {
	
	public boolean createCircle(CircleModel circleModel);
	
	public List<CircleModel> listOfCircleOfWorkspace(int workspaceId);
	

}
