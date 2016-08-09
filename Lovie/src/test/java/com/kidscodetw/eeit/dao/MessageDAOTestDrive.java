package com.kidscodetw.eeit.dao;
 
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.kidscodetw.eeit.dao.message.MessageDAO;
import com.kidscodetw.eeit.entity.message.MessageBean;
import com.kidscodetw.eeit.entity.movie.GenreBean;
 

 
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageDAOTestDrive 
{
    @Autowired
    private MessageDAO messageDAO;
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectSenderTest(){
       List<MessageBean> beans = messageDAO.selectSender("3122123");
       Assert.notEmpty(beans,"selectSenderTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectReceiverTest(){
       List<MessageBean> beans = messageDAO.selectReceiver("3122123");
       Assert.notEmpty(beans,"selectReceiverTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void insertTest(){
    	MessageBean bean = new MessageBean();
    	bean.setSender("3122123");
    	bean.setReceiver("3122123");
    	bean.setMessage("123456");
    	MessageBean result = messageDAO.insert(bean);
       Assert.isTrue(result.getMessage().equals("123456"),"insertTest fail");
    }
   
  
    
    
    
}