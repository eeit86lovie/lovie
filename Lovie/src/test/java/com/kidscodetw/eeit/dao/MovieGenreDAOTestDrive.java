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

import com.kidscodetw.eeit.entity.MovieGenreBean;
 

 
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieGenreDAOTestDrive 
{
     
    @Autowired
    private MovieGenreDAO movieGenreDAO;
     
    @Test
    @Transactional
    @Rollback(true)
    public void InsertTest(){
        MovieGenreBean bean = new MovieGenreBean();
        bean.setGenreId(2);
        bean.setMovieId(2);
        MovieGenreBean result = movieGenreDAO.insert(bean);
        Assert.isTrue(result.getGenreId()==2 && result.getMovieId()==2,"insert fail");
    }
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void findAllTest(){
       List<MovieGenreBean> beans = movieGenreDAO.select();
       Assert.notEmpty(beans,"FindAllTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByMovieId(){
       List<MovieGenreBean> beans = movieGenreDAO.selectByMovieId(1);
       Assert.notEmpty(beans, "FindByMovieId fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByGenreId(){
       List<MovieGenreBean> beans = movieGenreDAO.selectByGenreId(1);
       Assert.notEmpty(beans, "FindByGenreId fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void delete(){
       MovieGenreBean bean = new MovieGenreBean();
       bean.setGenreId(1);
       bean.setMovieId(1);
       Assert.isTrue( movieGenreDAO.delete(bean),"delete fail");
    }
      
}