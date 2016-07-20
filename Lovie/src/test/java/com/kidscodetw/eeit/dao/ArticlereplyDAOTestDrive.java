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

import com.kidscodetw.eeit.dao.forum.ArticleReplyDAO;
import com.kidscodetw.eeit.entity.forum.ArticleReplyBean;


@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticlereplyDAOTestDrive {

	@Autowired
	private ArticleReplyDAO articleReplyDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void select_ALL() {
		List<ArticleReplyBean> all = articleReplyDAO.select_ALL();
		Assert.notEmpty(all, "FindAllTest fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_ID() {
		ArticleReplyBean ab = articleReplyDAO.select_id(402);
		Assert.isTrue(ab.getContent().equals("成功"), "select_ID fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_Account() {
		List<ArticleReplyBean> ab = articleReplyDAO
				.select_memberAccount("3122208");
		Assert.notEmpty(ab, "FindAllTest fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_ArticleID() {
		List<ArticleReplyBean> ab = articleReplyDAO.select_articleID(70);
		Assert.notEmpty(ab, "FindAllTest fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void insert() {

		ArticleReplyBean ab = new ArticleReplyBean();
		ab.setArticleID(70);
		ab.setMemberAccount("aaa測試新增留言帳號");
		ab.setContent("aaa測試新增留言內容");
		ab.setPubTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		ab.setEditTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		ArticleReplyBean result = articleReplyDAO.insert(ab);
		Assert.isTrue(result.getMemberAccount().equals("aaa測試新增留言帳號"),
				"insert fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void update() {
		ArticleReplyBean ab = articleReplyDAO.select_id(402);
		ab.setContent("haha");
		articleReplyDAO.update(ab);
		String result = articleReplyDAO.select_id(402).getContent();
		Assert.isTrue(result.equals("haha"), "update fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void delete() {
		articleReplyDAO.delete(403);
	     Assert.isNull(articleReplyDAO.select_id(403),"delete fail");
	}

}
