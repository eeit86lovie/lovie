package com.kidscodetw.eeit.dao.message;

import java.util.List;

import com.kidscodetw.eeit.entity.message.MessageBean;

public interface MessageDAO {

	public abstract List<MessageBean> selectSender(String sender);

	public abstract List<MessageBean> selectReceiver(String receiver);
	
	public abstract MessageBean insert(MessageBean bean);

}