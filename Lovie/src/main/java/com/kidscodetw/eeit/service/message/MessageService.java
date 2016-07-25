package com.kidscodetw.eeit.service.message;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kidscodetw.eeit.dao.message.MessageDAO;
import com.kidscodetw.eeit.entity.message.MessageBean;
import com.kidscodetw.eeit.entity.movie.MovieBean;

public class MessageService implements MessageDAO{
	
	private MessageDAO messageDAO;
	public MessageService(MessageDAO messageDAOHibernate){
		this.messageDAO = messageDAOHibernate;
	}
	
	
	
	public List<MessageBean> selectSender(String sender) {
		List<MessageBean> result = null;
		result = messageDAO.selectSender(sender);
		return result;
	}
	
	public List<MessageBean> selectReceiver(String receiver) {
		List<MessageBean> result = null;
		result = messageDAO.selectReceiver(receiver);
		return result;
	}
	
	public MessageBean insert(MessageBean bean){
		return messageDAO.insert(bean);
	}

	
	
	
	
	

}
