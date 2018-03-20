package com.stackroute.activitystream.backend.dao;

import java.util.List;

import com.stackroute.activitystream.backend.model.WorkspaceModel;

public interface WorkspaceDAO {
	
	public boolean createWorkspace(WorkspaceModel workspaceModel);
	
	public boolean hideWorkspace(WorkspaceModel workspaceModel);
	
	public WorkspaceModel singleWorkspace(int workSpaceId);
	
	public boolean deleteWorkspace(int workSpaceId);
	
	public List<WorkspaceModel> listOfAllWorkSpaces();

}
