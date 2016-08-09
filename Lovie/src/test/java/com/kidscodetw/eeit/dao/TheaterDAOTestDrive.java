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

import com.kidscodetw.eeit.dao.movie.TheaterDAO;
import com.kidscodetw.eeit.entity.movie.TheaterBean;
 

 
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TheaterDAOTestDrive 
{
     
    @Autowired
    private TheaterDAO theaterDAO;
     
    @Test
    @Transactional
    @Rollback(true)
    public void InsertTest(){
        TheaterBean bean = new TheaterBean();
        
        bean.setName("測試戲院123");
        bean.setCity("台北市");
        bean.setDistrict("中山區");
        bean.setAddress("address");
        bean.setPhone("0953245874");
        bean.setWebsiteUrl("http://wwww");
        
       
        TheaterBean result = theaterDAO.insert(bean);
        Assert.isTrue(result.getName().equals("測試戲院123"),"insert fail");
    }
     

    
    @Test
    @Transactional
    @Rollback(true)
    public void findOneByIdTest(){
       TheaterBean bean = theaterDAO.select(1);
       Assert.isTrue(bean.getName().equals("基隆秀泰影城"),"FindOneByIdTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findAllTest(){
       List<TheaterBean> beans = theaterDAO.select();
       Assert.notEmpty(beans,"FindAllTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByName(){
       TheaterBean bean = theaterDAO.select("基隆秀泰影城");
       Assert.isTrue(bean.getName().equals("基隆秀泰影城"),"FindByName fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void deleteById(){
       theaterDAO.delete(1);
       Assert.isNull(theaterDAO.select(1),"deleteById fail");
    }
    
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void update(){
    	TheaterBean bean = theaterDAO.select(1);
    	bean.setName("haha");
    	theaterDAO.update(bean);
    	String result = theaterDAO.select(1).getName();
       Assert.isTrue(result.equals("haha"),"update fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void select_theaternames(){
    	List<String> beans = theaterDAO.select_theaternames();
    	Assert.notEmpty(beans, "select theaternames fail");
    }
    
    
    
}