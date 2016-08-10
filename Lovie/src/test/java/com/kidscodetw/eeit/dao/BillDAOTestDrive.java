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

import com.kidscodetw.eeit.dao.cart.BillDAO;
import com.kidscodetw.eeit.entity.cart.BillBean;




@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BillDAOTestDrive {

	@Autowired
	private BillDAO billDAO;

	
	@Test
	@Transactional
	@Rollback(true)
	public void select_ALL() {
		List<BillBean> all = billDAO.select_ALL();
		Assert.notEmpty(all, "FindAllTest fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_ID() {
		BillBean bb = billDAO.select_id(29);
		Assert.isTrue(bb.getMemberid().equals(1), "select_ID fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_memberid(){
		List<BillBean> lpb = billDAO.select_memberid(1);
		Assert.notEmpty(lpb, "FindAllTest fail");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void insert() {

		BillBean bb = new BillBean();
		bb.setMemberid(2);
		bb.setTradeTime(new java.sql.Timestamp(new java.util.Date().getTime()));
	    bb.setStatus(0);
	    bb.setCreditnum("111111111");
		BillBean result = billDAO.insert(bb);
		Assert.isTrue(result.getMemberid().equals(2), "insert fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void update() {
		BillBean bb = billDAO.select_id(29);
		bb.setCreditnum("123456789");
		billDAO.update(bb);
		String result = billDAO.select_id(29).getCreditnum();
		Assert.isTrue(result.equals("123456789"), "update fail");

	}

	@Test
	@Transactional
	@Rollback(true)
	public void delete() {
		billDAO.delete(31);
		Assert.isNull(billDAO.select_id(31), "delete fail");
	}

}
