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

import com.kidscodetw.eeit.dao.member.FriendDAO;
import com.kidscodetw.eeit.entity.forum.ForumBean;
import com.kidscodetw.eeit.entity.member.FriendBean;

@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FriendDAOTestDrive {
	@Autowired
	private FriendDAO friendDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void select_ALL() {
		List<FriendBean> all = friendDAO.selectAll();
		Assert.notEmpty(all, "FindAllTest fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_Part() {
		List<FriendBean> all = friendDAO.selectPart(15,1);
		Assert.notEmpty(all, "FindAllTest fail");
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void select_ID() {
		FriendBean fb = friendDAO.selectOne(15,28);
		Assert.isTrue(fb.getRelation().equals(1), "select_ID fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void insert() {
		FriendBean fb = new FriendBean();
		fb.setFriendId(75);
		fb.setMemberId(15);
		fb.setRelation(1);
		FriendBean result = friendDAO.insert(fb);
		Assert.isTrue(result.getRelation().equals(1), "insert fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void update() {
		FriendBean fb = friendDAO.selectOne(15,45);
		fb.setRelation(1);
		friendDAO.update(fb);
		FriendBean result = friendDAO.selectOne(15,45);
		System.out.println(result);
		Assert.isTrue(result.getRelation().equals(1), "update fail");

	}

	
}
