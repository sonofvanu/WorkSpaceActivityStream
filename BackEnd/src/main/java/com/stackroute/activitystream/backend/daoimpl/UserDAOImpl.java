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

	@Override
	public boolean removeUser(String userEmail) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.openSession().delete(this.singleUser(userEmail));
			} catch (Exception e) {
				sessionFactory.getCurrentSession().delete(this.singleUser(userEmail));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public UserModel singleUser(String userEmail) {
		// TODO Auto-generated method stub
		UserModel singleUserModel=null;
		try {
			try {
				singleUserModel=sessionFactory.getCurrentSession().get(UserModel.class, userEmail);
			} catch (Exception e) {
				// TODO: handle exception
				singleUserModel=sessionFactory.openSession().get(UserModel.class, userEmail);
			}
			return singleUserModel;
		} catch (Exception e) {
			// TODO: handle exception
			return singleUserModel;
		}
	}

}
