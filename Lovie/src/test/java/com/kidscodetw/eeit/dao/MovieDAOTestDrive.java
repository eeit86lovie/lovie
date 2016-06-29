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

import com.kidscodetw.eeit.entity.MovieBean;
 

 
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieDAOTestDrive 
{
     
    @Autowired
    private MovieDAO movieDAO;
     
    @Test
    @Transactional
    @Rollback(true)
    public void InsertTest(){
        MovieBean bean = new MovieBean();
        byte[] b = new byte[128];
        bean.setName("測試電影123");
        bean.setRank("18");
        bean.setStartTime("2016-02-02");
        bean.setFilmLength("105分");
        bean.setIntro("電影簡介測試");
        bean.setPhotoUrl("http://www.lol.com.tw");
        bean.setPhoto(b);
        bean.setTrailer("123");
        bean.setOnline(1);
       
        MovieBean result = movieDAO.insert(bean);
        Assert.isTrue(result.getName().equals("測試電影123"),"insert fail");
    }
     

    
    @Test
    @Transactional
    @Rollback(true)
    public void findOneByIdTest(){
       MovieBean bean = movieDAO.select(1);
       Assert.isTrue(bean.getName().equals("瘋狂假面：變態危機"),"FindOneByIdTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findAllTest(){
       List<MovieBean> beans = movieDAO.select();
       Assert.notEmpty(beans,"FindAllTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByName(){
       MovieBean bean = movieDAO.select("瘋狂假面：變態危機");
       Assert.isTrue(bean.getName().equals("瘋狂假面：變態危機"),"FindByName fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void deleteById(){
       movieDAO.delete(1);
       Assert.isNull(movieDAO.select(1),"deleteById fail");
    }
    
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void update(){
    	MovieBean bean = movieDAO.select(1);
    	bean.setName("haha");
    	movieDAO.update(bean);
    	String result = movieDAO.select(1).getName();
       Assert.isTrue(result.equals("haha"),"update fail");
    }
    
    
    
}