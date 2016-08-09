package com.kidscodetw.eeit.dao.custservice;
import java.util.List;


import com.kidscodetw.eeit.entity.custservice.CustServiceCatagoryBean;
public interface CustServiceCatagoryDAO {
	
	List<CustServiceCatagoryBean> select();
	
	CustServiceCatagoryBean select(Integer id);
	
	CustServiceCatagoryBean select(String category);
	
	CustServiceCatagoryBean insert(CustServiceCatagoryBean bean);
	
	CustServiceCatagoryBean delet(Integer id);
	
}
