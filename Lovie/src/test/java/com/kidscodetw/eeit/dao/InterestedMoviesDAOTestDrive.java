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

import com.kidscodetw.eeit.dao.member.InterestedMoviesDAO;
import com.kidscodetw.eeit.entity.member.InterestedMoviesBean;

@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class InterestedMoviesDAOTestDrive {
    @Autowired
    private InterestedMoviesDAO interestedMoviesDAO;
     
    @Test
    @Transactional
    @Rollback(true)
    public void InsertTest(){
    	InterestedMoviesBean bean = new InterestedMoviesBean();
        bean.setGenreId(2);
        bean.setMemberId(15);
        InterestedMoviesBean result = interestedMoviesDAO.insert(bean);
        Assert.isTrue(result.getGenreId()==2 && result.getMemberId()==15,"insert fail");
    }
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void findAllTest(){
       List<InterestedMoviesBean> beans = interestedMoviesDAO.select();
       Assert.notEmpty(beans,"FindAllTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByMemberId(){
       List<InterestedMoviesBean> beans = interestedMoviesDAO.selectByMemberId(15);
       Assert.notEmpty(beans, "FindByMovieId fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByGenreId(){
       List<InterestedMoviesBean> beans = interestedMoviesDAO.selectByGenreId(1);
       Assert.notEmpty(beans, "FindByGenreId fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void delete(){
       InterestedMoviesBean bean = new InterestedMoviesBean();
       bean.setGenreId(2);
       bean.setMemberId(15);
       Assert.isTrue( interestedMoviesDAO.delete(bean),"delete fail");
    }
}
