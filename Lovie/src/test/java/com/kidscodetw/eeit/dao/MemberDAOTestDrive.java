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

import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;
 

 
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberDAOTestDrive 
{
     
    @Autowired
    private MemberDAO memberDAO;
     
    @Test
    @Transactional
    @Rollback(true)
    public void InsertTest(){
        MemberBean bean = new MemberBean();
        bean.setAccount("abc123");
        bean.setPassword("123");
        bean.setGender(1);
        bean.setEmail("abc@123.com");
        bean.setNickname("小可愛");
        bean.setCity("台北市");
        bean.setDistrict("中山區");
        bean.setPhone("0953214857");
        bean.setPrivilege(1);
        bean.setPhotoUrl("http://teswt");
        bean.setBirthday("1982-01-02");
        bean.setFriendNum(1);
        bean.setCommentPoint(1);
        bean.setIntro("intro");
        bean.setConstellation("aqua");
        bean.setRegisteredTime("2016-01-06");
        bean.setLastOnTime("2016-01-03");
        MemberBean result = memberDAO.insert(bean);
        Assert.isTrue(bean.getAccount().equals(result.getAccount()),"insert fail");
    }
     

    
    @Test
    @Transactional
    @Rollback(true)
    public void findOneByIdTest(){
       MemberBean bean = memberDAO.select(103);
       Assert.isTrue(bean.getNickname().equals("小閔"),"FindOneByIdTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findAllTest(){
       List<MemberBean> beans = memberDAO.select();
       Assert.notEmpty(beans,"FindAllTest fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void findByAccount(){
       MemberBean bean = memberDAO.select("3122379");
       Assert.isTrue(bean.getAccount().equals("3122379"),"FindByAccount fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void deleteById(){
       memberDAO.delete(1);
       Assert.isNull(memberDAO.select(1),"deleteById fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void deleteByAccount(){
       Assert.isTrue(memberDAO.delete("3122379"),"deleteByAccount fail");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void update(){
    	MemberBean bean = memberDAO.select(103);
    	bean.setNickname("haha");
    	memberDAO.update(bean);
    	String result = memberDAO.select(103).getNickname();
       Assert.isTrue(result.equals("haha"),"update fail");
    }
    
    
    
}