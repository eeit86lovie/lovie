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
import com.kidscodetw.eeit.entity.forum.ArticleReplyBean;




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
	public void select_Rank_Primarykey() {
		List<ArticleRankBean> primarykey = articleRankDAO.select_Rank_Primarykey(337, "3122161");
		Assert.notEmpty(primarykey, "Findprimarykey fail");
		
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
	public void select_totle_good() {
		List<ArticleRankBean> ab = articleRankDAO.select_totle_good(341,1);
		Assert.notEmpty(ab, "Find good Test fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_totle_bad() {
		List<ArticleRankBean> ab = articleRankDAO.select_totle_bad(339,1);
		Assert.notEmpty(ab, "Find bad Test fail");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void select_report() {
		List<ArticleRankBean> arb = articleRankDAO.select_report(1);
		Assert.notEmpty(arb,"select report fail");
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
	
	@Test
	@Transactional
	@Rollback(true)
	public void update() {
		List<ArticleRankBean> ab = articleRankDAO.select_Rank_Primarykey(338, "3122131");
		ab.get(0).setBad(0);
		ab.get(0).setGood(1);
		articleRankDAO.update(ab.get(0));
		String result = String.valueOf(articleRankDAO.select_Rank_Primarykey(338, "3122131").get(0).getGood());
		Assert.isTrue(result.equals(result), "update fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void delete() {
		String deleteCount = String.valueOf(articleRankDAO.delete(337));
	    Assert.isTrue(deleteCount.equals("1"),"delete fail");
	}
}