package com.stackroute.activitystream.backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.activitystream.backend.dao.CircleDAO;
import com.stackroute.activitystream.backend.model.CircleModel;
import com.stackroute.activitystream.backend.model.UserWorkspaceModel;

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

	@Override
	public CircleModel singleCircle(int circleId) {
		// TODO Auto-generated method stub
		CircleModel singleCircleModel = null;
		try {
			try {
				singleCircleModel = sessionFactory.getCurrentSession().get(CircleModel.class, circleId);
			} catch (Exception e) {
				// TODO: handle exception
				singleCircleModel = sessionFactory.openSession().get(CircleModel.class, circleId);
			}
			return singleCircleModel;
		} catch (Exception e) {
			// TODO: handle exception
			return singleCircleModel;
		}

	}

	@Override
	public boolean removecircle(int circleId) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.openSession().delete(this.singleCircle(circleId));
			} catch (Exception e) {
				sessionFactory.getCurrentSession().delete(this.singleCircle(circleId));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
