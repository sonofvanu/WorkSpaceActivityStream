package com.stackroute.activitystream.backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.activitystream.backend.dao.MessageDAO;
import com.stackroute.activitystream.backend.model.MessageModel;
import com.stackroute.activitystream.backend.model.UserWorkspace;

public class MessageDAOImpl implements MessageDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addMessageAndRemoveMessage(MessageModel messageModel) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(messageModel);
			} catch (Exception e) {
				sessionFactory.openSession().saveOrUpdate(messageModel);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<MessageModel> allMessageInCircle(int circleId, int workspaceId) {
		// TODO Auto-generated method stub
		List<MessageModel> allMessageInACircle = null;
		try {
			try {
				Criteria criteria = sessionFactory.openSession().createCriteria(UserWorkspace.class);
				criteria.add(Restrictions.eq("workSpaceId", workspaceId));
				criteria.add(Restrictions.eq("circleId", circleId));
				criteria.addOrder(Order.asc("messageId"));
				allMessageInACircle = criteria.list();
			} catch (Exception e) {
				Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserWorkspace.class);
				criteria.add(Restrictions.eq("workSpaceId", workspaceId));
				criteria.add(Restrictions.eq("circleId", circleId));
				criteria.addOrder(Order.asc("messageId"));
				allMessageInACircle = criteria.list();
			}
			return allMessageInACircle;
		} catch (Exception e) {
			return allMessageInACircle;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageModel> allMessageBetweenUsers(int workspaceId, String UserIdOne, String UserIdTwo) {
		// TODO Auto-generated method stub
		List<MessageModel> allMessageInACircle = null;
		try {
			try {
				Criteria criteria = sessionFactory.openSession().createCriteria(UserWorkspace.class);
				Criterion conditionOne = Restrictions.and(Restrictions.eq("senderId", UserIdOne),
						Restrictions.eq("receiverId", UserIdTwo));
				Criterion conditionTwo = Restrictions.and(Restrictions.eq("receiverId", UserIdOne),
						Restrictions.eq("senderId", UserIdTwo));
				criteria.addOrder(Order.asc("messageId"));
				allMessageInACircle = criteria.add(Restrictions.or(conditionOne, conditionTwo)).list();
			} catch (Exception e) {
				Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserWorkspace.class);
				Criterion conditionOne = Restrictions.and(Restrictions.eq("senderId", UserIdOne),
						Restrictions.eq("receiverId", UserIdTwo));
				Criterion conditionTwo = Restrictions.and(Restrictions.eq("receiverId", UserIdOne),
						Restrictions.eq("senderId", UserIdTwo));
				criteria.addOrder(Order.asc("messageId"));

			}
			return allMessageInACircle;
		} catch (Exception e) {
			return allMessageInACircle;
		}
	}

}
