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

import com.kidscodetw.eeit.dao.forum.ArticleRankDAO;
import com.kidscodetw.eeit.entity.forum.ArticleRankBean;




@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleRankDAOTestDrive {

	@Autowired
	private ArticleRankDAO articleRankDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void select_ALL() {
		List<ArticleRankBean> all = articleRankDAO.select_ALL();
		Assert.notEmpty(all, "FindAllTest fail");
	}

	

	@Test
	@Transactional
	@Rollback(true)
	public void select_Account() {
		List<ArticleRankBean> arb = articleRankDAO
				.select_memberAccount("3122123");
		Assert.notEmpty(arb, "FindAllTest fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_ArticleID() {
		List<ArticleRankBean> ab = articleRankDAO.select_articleID(337);
		Assert.notEmpty(ab, "FindAllTest fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void insert() {

		ArticleRankBean arb = new ArticleRankBean();
		
		arb.setArticleID(336);
		arb.setMemberAccount("3122180");
		arb.setGood(1);
		
		ArticleRankBean result = articleRankDAO.insert(arb);
		Assert.isTrue(result.getMemberAccount().equals("3122180"),
				"insert fail");
	}

	

}