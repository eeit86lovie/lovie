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

import com.kidscodetw.eeit.dao.appoint.AppointmentDAO;
import com.kidscodetw.eeit.entity.appoint.AppointmentBean;
 

 
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AppointmentDAOTestDrive 
{
     
    @Autowired
    private AppointmentDAO appointmentDAO;
     
    @Test
    @Transactional
    @Rollback(true)
    public void InsertTest(){
        AppointmentBean bean = new AppointmentBean();
        bean.setMemberId(101);
        bean.setShowtimeId(102);
        bean.setContent("gg");
        bean.setType(1);
        bean.setStatus(1);
        AppointmentBean result = appointmentDAO.insert(bean);
        Assert.isTrue(result.getMemberId().equals(101),"insert fail");
    }
     

    
    @Test
    @Transactional
    @Rollback(true)
    public void findOneByIdTest(){
       AppointmentBean bean = appointmentDAO.select(1);
       Assert.isTrue(bean.getMemberId().equals(3),"FindOneByIdTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findAllTest(){
       List<AppointmentBean> beans = appointmentDAO.select();
       Assert.notEmpty(beans,"FindAllTest fail");
    }
    
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByShowtimeId(){
       List<AppointmentBean> beans = appointmentDAO.selectByShowtimeId(5);
       Assert.notEmpty(beans ,"FindByShowtimeId fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByMemberId(){
       List<AppointmentBean> beans = appointmentDAO.selectByMemberId(3);
       Assert.notEmpty(beans ,"FindByMemberId fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void deleteById(){
       Assert.isTrue(appointmentDAO.delete(1),"deleteById fail");
    }
    
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void update(){
    	AppointmentBean bean = appointmentDAO.select(1);
    	bean.setMemberId(10);
    	appointmentDAO.update(bean);
    	Integer result = appointmentDAO.select(1).getMemberId();
       Assert.isTrue(result.equals(10),"update fail");
    }
    
    
    
    
    
}