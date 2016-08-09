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

import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.entity.forum.ForumBean;


@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ForumDAOTestDrive {

	@Autowired
	private ForumDAO forumDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void select_ALL() {
		List<ForumBean> all = forumDAO.select_ALL();
		Assert.notEmpty(all, "FindAllTest fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_ID() {
		ForumBean fb = forumDAO.select_id(70);
		Assert.isTrue(fb.getMemberAccount().equals("3122131"), "select_ID fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_Account() {
		List<ForumBean> fb = forumDAO.select_memberAccount("3122663");
		Assert.notEmpty(fb, "select_Account fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void insert() {

		ForumBean fb = new ForumBean();
		fb.setMemberAccount("測試新增帳號");
		fb.setTitle("測試新增Title");
		fb.setContent("測試新增內容");
		fb.setGenre("新增好雷222");
		fb.setPubTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		fb.setEditTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		ForumBean result = forumDAO.insert(fb);
		Assert.isTrue(result.getMemberAccount().equals("測試新增帳號"), "insert fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void update() {
		ForumBean fb = forumDAO.select_id(70);
		fb.setContent("haha");
		forumDAO.update(fb);
		String result = forumDAO.select_id(70).getContent();
		Assert.isTrue(result.equals("haha"), "update fail");

	}

	@Test
	@Transactional
	@Rollback(true)
	public void delete() {
		forumDAO.delete(70);
		Assert.isNull(forumDAO.select_id(70), "delete fail");
	}

	
	@Test
	@Transactional
	@Rollback(true)
	public void select_genre() {
		List<ForumBean> fb = forumDAO.select_genre("負雷");
		Assert.notEmpty(fb, "select_genre fail");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void select_title() {
		List<ForumBean> fb = forumDAO.select_title("c");
		Assert.notEmpty(fb, "select_title fail");
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void select_content() {
		List<ForumBean> fb = forumDAO.select_content("哈哈哈");
		Assert.notEmpty(fb, "select_content fail");
	}
	
}
