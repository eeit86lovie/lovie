package com.kidscodetw.eeit.dao.custservice;

import java.util.List;

import org.hibernate.Session;

import com.kidscodetw.eeit.entity.custservice.CustServiceBean;



public interface CustServiceDAO {

	List<CustServiceBean> select();

	CustServiceBean select(Integer id);

	List<CustServiceBean> select(String memberAccount);

	boolean delete(Integer id);

	CustServiceBean insert(CustServiceBean bean);

	CustServiceBean update(CustServiceBean bean);

}