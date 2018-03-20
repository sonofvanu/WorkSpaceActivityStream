package com.stackroute.activitystream.backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.activitystream.backend.dao.UserWorkspaceDAO;
import com.stackroute.activitystream.backend.model.UserWorkspaceModel;

public class UserWorkspaceDAOImpl implements UserWorkspaceDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUserToWorkspace(UserWorkspaceModel userWorkSpace) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.openSession().save(userWorkSpace);
			} catch (Exception e) {
				sessionFactory.getCurrentSession().save(userWorkSpace);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserWorkspaceModel> allWorkspaceOfUser(String userEmail) {
		// TODO Auto-generated method stub
		List<UserWorkspaceModel> allWorkspaceOfAnUser = null;
		try {
			try {
				Criteria criteria = sessionFactory.openSession().createCriteria(UserWorkspaceModel.class);
				criteria.add(Restrictions.eq("userEmailId", userEmail));
				allWorkspaceOfAnUser = criteria.list();
			} catch (Exception e) {
				Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserWorkspaceModel.class);
				criteria.add(Restrictions.eq("userEmailId", userEmail));
				allWorkspaceOfAnUser = criteria.list();
			}
			return allWorkspaceOfAnUser;
		} catch (Exception e) {
			return allWorkspaceOfAnUser;
		}
	}

	@Override
	public boolean leaveWorkspace(int userWorkspaceId) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.openSession().delete(this.singleUserWorkspace(userWorkspaceId));
			} catch (Exception e) {
				sessionFactory.getCurrentSession().delete(this.singleUserWorkspace(userWorkspaceId));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public UserWorkspaceModel singleUserWorkspace(int userWorkspaceId) {
		// TODO Auto-generated method stub
		UserWorkspaceModel singleWorkspaceOfUser = null;
		try {
			try {
				singleWorkspaceOfUser = sessionFactory.openSession().get(UserWorkspaceModel.class, userWorkspaceId);
			} catch (Exception e) {
				singleWorkspaceOfUser = sessionFactory.getCurrentSession().get(UserWorkspaceModel.class,
						userWorkspaceId);
			}
			return singleWorkspaceOfUser;
		} catch (Exception e) {
			return singleWorkspaceOfUser;
		}

	}

}
