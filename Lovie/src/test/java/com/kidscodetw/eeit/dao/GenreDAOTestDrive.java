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

import com.kidscodetw.eeit.dao.movie.GenreDAO;
import com.kidscodetw.eeit.entity.movie.GenreBean;
 

 
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GenreDAOTestDrive 
{
    @Autowired
    private GenreDAO genreDAO;
    
    @Test
    @Transactional
    @Rollback(true)
    public void findOneByIdTest(){
       GenreBean bean = genreDAO.select(1);
       Assert.isTrue(bean.getName().equals("劇情"),"FindOneByIdTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findAllTest(){
       List<GenreBean> beans = genreDAO.select();
       Assert.notEmpty(beans,"FindAllTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByName(){
       GenreBean bean = genreDAO.select("劇情");
       Assert.isTrue(bean.getId()==1,"FindByName fail");
    }
    
   
    
    
    
  
    
    
    
}