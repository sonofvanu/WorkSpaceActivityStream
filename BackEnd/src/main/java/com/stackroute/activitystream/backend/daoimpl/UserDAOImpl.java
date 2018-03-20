package com.stackroute.activitystream.backend.daoimpl;

import org.hibernate.SessionFactory;

import com.stackroute.activitystream.backend.dao.UserDAO;
import com.stackroute.activitystream.backend.model.UserModel;

public class UserDAOImpl implements UserDAO {

	SessionFactory sessionFactory;

	@Override
	public boolean createuser(UserModel userModel) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.openSession().save(userModel);
			} catch (Exception e) {
				sessionFactory.getCurrentSession().save(userModel);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
