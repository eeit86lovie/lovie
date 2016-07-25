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
import com.kidscodetw.eeit.dao.cart.ProductDAO;
import com.kidscodetw.eeit.entity.cart.ProductBean;



@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDAOTestDrive {

	@Autowired
	private ProductDAO productDAO;

	
	@Test
	@Transactional
	@Rollback(true)
	public void select_ALL() {
		List<ProductBean> all = productDAO.select_ALL();
		Assert.notEmpty(all, "FindAllTest fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_ID() {
		ProductBean pb = productDAO.select_id(75);
		Assert.isTrue(pb.getName().equals("白銀會員"), "select_ID fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_name() {
		ProductBean pb = productDAO.select_name("白銀會員");
		Assert.isTrue(pb.getName().equals("白銀會員"),
				"select_Account fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void select_category() {
		List<ProductBean> lpb = productDAO.select_category(1);
		Assert.notEmpty(lpb, "FindAllTest fail");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void insert() {

		ProductBean pb = new ProductBean();
		pb.setName("黃金會員");
		pb.setCost(10);
		pb.setDiscount(0);
		pb.setCategory(3);
		pb.setInventory(50);
		pb.setContent("哈哈哈");
		ProductBean result = productDAO.insert(pb);
		Assert.isTrue(result.getName().equals("黃金會員"), "insert fail");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void update() {
		ProductBean pb = productDAO.select_id(75);
		pb.setName("鋼鐵人2");
		pb.setContent("haha");
		productDAO.update(pb);
		String result = productDAO.select_id(75).getContent();
		Assert.isTrue(result.equals("haha"), "update fail");

	}

	@Test
	@Transactional
	@Rollback(true)
	public void delete() {
		productDAO.delet(79);
		Assert.isNull(productDAO.select_id(79), "delete fail");
	}

}
