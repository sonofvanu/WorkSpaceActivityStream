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
import com.stackroute.activitystream.backend.model.UserWorkspaceModel;

public class MessageDAOImpl implements MessageDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addMessage(MessageModel messageModel) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.getCurrentSession().save(messageModel);
			} catch (Exception e) {
				sessionFactory.openSession().save(messageModel);
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
				Criteria criteria = sessionFactory.openSession().createCriteria(UserWorkspaceModel.class);
				criteria.add(Restrictions.eq("workSpaceId", workspaceId));
				criteria.add(Restrictions.eq("circleId", circleId));
				criteria.addOrder(Order.asc("messageId"));
				allMessageInACircle = criteria.list();
			} catch (Exception e) {
				Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserWorkspaceModel.class);
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
				Criteria criteria = sessionFactory.openSession().createCriteria(UserWorkspaceModel.class);
				Criterion conditionOne = Restrictions.and(Restrictions.eq("senderId", UserIdOne),
						Restrictions.eq("receiverId", UserIdTwo));
				Criterion conditionTwo = Restrictions.and(Restrictions.eq("receiverId", UserIdOne),
						Restrictions.eq("senderId", UserIdTwo));
				criteria.addOrder(Order.asc("messageId"));
				allMessageInACircle = criteria.add(Restrictions.or(conditionOne, conditionTwo)).list();
			} catch (Exception e) {
				Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserWorkspaceModel.class);
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

	@Override
	public boolean hideMessage(MessageModel messageModel) {
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
	public boolean removeMessage(int messageId) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.getCurrentSession().delete(this.singleMessage(messageId));
			} catch (Exception e) {
				sessionFactory.openSession().delete(this.singleMessage(messageId));
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public MessageModel singleMessage(int messageId) {
		// TODO Auto-generated method stub
		MessageModel singleMessage = null;
		try {
			try {
				singleMessage = sessionFactory.getCurrentSession().get(MessageModel.class, messageId);
			} catch (Exception e) {
				// TODO: handle exception
				singleMessage = sessionFactory.openSession().get(MessageModel.class, messageId);
			}
			return singleMessage;
		} catch (Exception e) {
			// TODO: handle exception
			return singleMessage;
		}
	}

}
