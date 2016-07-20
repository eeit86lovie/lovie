package com.kidscodetw.eeit.service.cart;

import java.util.List;

import com.kidscodetw.eeit.dao.cart.ProductDAO;
import com.kidscodetw.eeit.entity.cart.ProductBean;




public class ProductService {

	//private ProductDAO productDao = new ProductDAOjdbc();
	//private ProductDAOHibernate productDao = new ProductDAOHibernate();

	private ProductDAO productDAO;
	public ProductService(ProductDAO productDAOHibernate){
		this.productDAO = productDAOHibernate;
	}
	
	
	public List<ProductBean> select_ALL(){
		List<ProductBean> result =null;
		result=productDAO.select_ALL();
	    return result;
	}
		
	public ProductBean select_id(int productid){
		ProductBean result = null;
		if(productid!=0){
			result = productDAO.select_id(productid);
		}
		return result;
	}
	public List<ProductBean> select_category(int category){
		List<ProductBean> result=null;
		if(category!=0){
			result=productDAO.select_category(category);
		}
		return result;
	}

	public ProductBean insert(ProductBean pb){
		ProductBean result = null;
		if(pb!=null){
			result = productDAO.insert(pb);
		}
		return result;
	}

	public int delete(int productid){
		int result = 0;
		if(productid!=0){
			result = productDAO.delet(productid);
		}
		return result;
	}

	
	public ProductBean update(ProductBean pb){
		ProductBean result = null;
		if(pb!=null && pb.getProductid()!=0){
			result = productDAO.update(pb);
		}
		return result;
	}

}

