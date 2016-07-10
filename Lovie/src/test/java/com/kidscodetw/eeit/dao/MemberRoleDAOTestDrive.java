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

import com.kidscodetw.eeit.entity.MemberRoleBean;
 

 
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberRoleDAOTestDrive 
{
    @Autowired
    private MemberRoleDAO memberRoleDAO;
    
    @Test
    @Transactional
    @Rollback(true)
    public void findOneByIdTest(){
       MemberRoleBean bean = memberRoleDAO.select(1);
       Assert.isTrue(bean.getRole().equals("ROLE_USER"),"FindOneByIdTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findAllTest(){
       List<MemberRoleBean> beans = memberRoleDAO.select();
       Assert.notEmpty(beans,"FindAllTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByName(){
       MemberRoleBean bean = memberRoleDAO.select("ROLE_USER");
       Assert.isTrue(bean.getPrivilege()==1,"FindByName fail");
    }
    
   
    
    
    
  
    
    
    
}