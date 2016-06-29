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

import com.kidscodetw.eeit.entity.ShowtimeBean;
 

 
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ShowtimeDAOTestDrive 
{
     
    @Autowired
    private ShowtimeDAO showtimeDAO;
     
    @Test
    @Transactional
    @Rollback(true)
    public void InsertTest(){
        ShowtimeBean bean = new ShowtimeBean();
        bean.setMovieName("測試電影321");
        bean.setTheaterName("測試戲院321");
        bean.setShowtimeDate("2016-02-05");
        bean.setShowtimeTime("05:30");
        bean.setOnline(1);
        ShowtimeBean result = showtimeDAO.insert(bean);
        Assert.isTrue(result.getMovieName().equals("測試電影321"),"insert fail");
    }
     

    
    @Test
    @Transactional
    @Rollback(true)
    public void findOneByIdTest(){
       ShowtimeBean bean = showtimeDAO.select(1);
       Assert.isTrue(bean.getMovieName().equals("魔境夢遊：時光怪客"),"FindOneByIdTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findOneByBoth(){
       List<ShowtimeBean> beans = showtimeDAO.selectBoth("魔境夢遊：時光怪客","基隆秀泰影城");
       Assert.notEmpty(beans,"FindOneByBoth fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByMovieName(){
       List<ShowtimeBean> beans = showtimeDAO.selectMovie("魔境夢遊：時光怪客");
       Assert.notEmpty(beans,"FindByMovieName fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByTheaterName(){
       List<ShowtimeBean> beans = showtimeDAO.selectTheater("基隆秀泰影城");
       Assert.notEmpty(beans,"FindByTheaterName fail");
    }
    
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void update(){
    	ShowtimeBean bean = showtimeDAO.select(1);
    	bean.setMovieName("haha");
    	showtimeDAO.update(bean);
    	String result = showtimeDAO.select(1).getMovieName();
       Assert.isTrue(result.equals("haha"),"update fail");
    }
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void deleteDateBefore() {
    	showtimeDAO.deleteDateBefore("2016-06-03");
    	Assert.isNull(showtimeDAO.select(1), "deleteDateBefore fail");
    }
    
    
}