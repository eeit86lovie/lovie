package com.kidscodetw.eeit.dao;


import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import com.kidscodetw.eeit.dao.cart.TradeDetailDAO;
import com.kidscodetw.eeit.entity.cart.TradeDetailBean;





@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TradeDetailDAOTestDrive {

	@Autowired
	private TradeDetailDAO tradeDetailDAO;

	
	@Test
	@Transactional
	@Rollback(true)
	public void select_ALL() {
		List<TradeDetailBean> all = tradeDetailDAO.select_ALL();
		Assert.notEmpty(all, "FindAllTest fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_ID() {
		TradeDetailBean tdb = tradeDetailDAO.select_id(10);
		Assert.isTrue(tdb.getProductid().equals(1), "select_ID fail");
	}

	
	@Test
	@Transactional
	@Rollback(true)
	public void insert() {

		TradeDetailBean tdb = new TradeDetailBean();
		tdb.setProductid(2);
		tdb.setAmount(10);
		tdb.setTitle(5000);
		TradeDetailBean result = tradeDetailDAO.insert(tdb);
		Assert.isTrue(result.getProductid().equals(2), "insert fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void update() {
		TradeDetailBean tdb = tradeDetailDAO.select_id(10);
		tdb.setTitle(1);
		tradeDetailDAO.update(tdb);
		Integer result = tradeDetailDAO.select_id(10).getTitle();
		Assert.isTrue(result.equals(1), "update fail");

	}

	@Test
	@Transactional
	@Rollback(true)
	public void delete() {
		tradeDetailDAO.delete(12);
		Assert.isNull(tradeDetailDAO.select_id(12), "delete fail");
	}

}
