package com.kidscodetw.eeit.dao.message;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.message.MessageBean;

public class MessageDAOHibernate implements MessageDAO{

	private static final String SELECT_BY_SENDER = "FROM MessageBean where sender=:sender order by timestamp desc";
	private static final String SELECT_BY_RECEIVER = "FROM MessageBean where receiver=:receiver order by timestamp desc";



	private SessionFactory sessionFactory;

	public MessageDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	


	
	/* (non-Javadoc)
	 * @see com.kidscodetw.eeit.dao.message.MessageDAO#selectSender()
	 */
	@Override
	public List<MessageBean> selectSender(String sender) {
		Query query = this.getSession().createQuery(SELECT_BY_SENDER);
		query.setParameter("sender", sender);
		return query.list();
	}
	
	/* (non-Javadoc)
	 * @see com.kidscodetw.eeit.dao.message.MessageDAO#selectReceiver()
	 */
	@Override
	public List<MessageBean> selectReceiver(String receiver) {
		Query query = this.getSession().createQuery(SELECT_BY_RECEIVER);
		query.setParameter("receiver", receiver);
		return query.list();
	}
	
	public MessageBean insert(MessageBean bean){
		this.getSession().save(bean);
		return bean;
	}

	
	
}
