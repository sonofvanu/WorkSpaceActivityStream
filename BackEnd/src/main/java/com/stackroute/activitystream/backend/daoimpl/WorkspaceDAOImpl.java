package com.stackroute.activitystream.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.activitystream.backend.dao.WorkspaceDAO;
import com.stackroute.activitystream.backend.model.WorkspaceModel;

public class WorkspaceDAOImpl implements WorkspaceDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean createWorkspace(WorkspaceModel workspaceModel) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.getCurrentSession().save(workspaceModel);
			} catch (Exception e) {
				sessionFactory.openSession().save(workspaceModel);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean hideWorkspace(WorkspaceModel workspaceModel) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(workspaceModel);
			} catch (Exception e) {
				sessionFactory.openSession().saveOrUpdate(workspaceModel);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;

		}
	}

	@Override
	public WorkspaceModel singleWorkspace(int workSpaceId) {
		WorkspaceModel singleWorkSpace = null;
		try {
			try {
				singleWorkSpace = sessionFactory.getCurrentSession().get(WorkspaceModel.class, workSpaceId);
			} catch (Exception e) {
				singleWorkSpace = sessionFactory.openSession().get(WorkspaceModel.class, workSpaceId);
			}
			return singleWorkSpace;
		} catch (Exception e) {
			// TODO: handle exception
			return singleWorkSpace;

		}

	}

	@Override
	public boolean deleteWorkspace(int workSpaceId) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.getCurrentSession().delete(this.singleWorkspace(workSpaceId));
			} catch (Exception e) {
				sessionFactory.openSession().delete(this.singleWorkspace(workSpaceId));
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<WorkspaceModel> listOfAllWorkSpaces() {
		// TODO Auto-generated method stub
		List<WorkspaceModel> allWorkspaces = null;

		try {
			try {
				allWorkspaces = sessionFactory.getCurrentSession().createQuery("From WorkspaceModel").list();
			} catch (Exception e) {
				allWorkspaces = sessionFactory.openSession().createQuery("From WorkspaceModel").list();
			}
			return allWorkspaces;
		} catch (Exception e) {
			// TODO: handle exception
			return allWorkspaces;
		}
	}

}
