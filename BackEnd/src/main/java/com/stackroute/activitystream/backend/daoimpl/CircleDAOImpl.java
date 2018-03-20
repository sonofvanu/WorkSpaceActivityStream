package com.stackroute.activitystream.backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.activitystream.backend.dao.CircleDAO;
import com.stackroute.activitystream.backend.model.CircleModel;
import com.stackroute.activitystream.backend.model.UserWorkspace;

public class CircleDAOImpl implements CircleDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean createCircle(CircleModel circleModel) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.openSession().save(circleModel);
			} catch (Exception e) {
				sessionFactory.getCurrentSession().save(circleModel);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CircleModel> listOfCircleOfWorkspace(int workspaceId) {
		// TODO Auto-generated method stub
		List<CircleModel> allCirclesOfWorkspace = null;
		try {
			try {
				Criteria criteria = sessionFactory.openSession().createCriteria(CircleModel.class);
				criteria.add(Restrictions.eq("workSpaceId", workspaceId));
				allCirclesOfWorkspace = criteria.list();
			} catch (Exception e) {
				Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CircleModel.class);
				criteria.add(Restrictions.eq("workSpaceId", workspaceId));
				allCirclesOfWorkspace = criteria.list();
			}
			return allCirclesOfWorkspace;
		} catch (Exception e) {
			return allCirclesOfWorkspace;
		}
	}

}
