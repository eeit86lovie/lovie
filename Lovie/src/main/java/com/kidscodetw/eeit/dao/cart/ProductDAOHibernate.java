package com.kidscodetw.eeit.dao.cart;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.kidscodetw.eeit.entity.cart.ProductBean;


public class ProductDAOHibernate implements ProductDAO {

	private static final String SELECT_ALL = "FROM ProductBean";
	private static final String SELECT_ID = "FROM ProductBean WHERE productid = ?";
	private static final String SELECT_NAME = "FROM ProductBean WHERE name = ?";
	private static final String SELECT_CATEGORY = "FROM ProductBean WHERE category=?";
	private static final String INSERT = "INSERT INTO ProductBean(name,cost,discount,productphoto,inventory,category,content) VALUES (?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE ProductBean SET name=COALESCE(?,name),cost =COALESCE(?, cost),productphoto =COALESCE(?, productphoto), discount = COALESCE(?, discount),inventory = COALESCE(?, inventory),category = COALESCE(?, category),content = COALESCE(?, content)WHERE productid=?";
	private static final String DELETE = "DELETE FROM ProductBean WHERE productid=?";
	private SessionFactory sessionFactory;

	public ProductDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<ProductBean> select_ALL() {
		List<ProductBean> lpb = null;
		Query query = getSession().createQuery(SELECT_ALL);			 		
	    lpb = query.setMaxResults(6).list();
	    //lpb = query.setFirstResult(6).list();
	    //lpb = query.list();
	
		return lpb;
	}

	
	

	public List<ProductBean> select_NEXT(int next_count) {
		
			List<ProductBean> lpb = null;
				 Query query = getSession().createQuery(SELECT_CATEGORY);			 		
				 //lpb = query.setMaxResults(6).list();
				 //lpb = query.setFirstResult(next_count).list();
				  query.setFirstResult(next_count);
			      query.setMaxResults(next_count + 6 );
			      lpb = query.list();
				 //lpb = query.list();
				 return lpb;	
	}
	@Override
	public ProductBean select_id(Integer productid) {
		ProductBean pb = null;
		pb = (ProductBean) getSession().get(ProductBean.class, productid);
		
		return pb;
	}


	@Override
	public ProductBean select_name(String name) {
		ProductBean pb = null;
		Query query = getSession().createQuery(SELECT_NAME);
		query.setParameter(0, name);
		List<ProductBean> pbs = query.list();
		for(ProductBean productbean :pbs){
			pb = productbean;
			}
		return pb;
	}

	@Override
	public List<ProductBean> select_category(Integer category) {
		List<ProductBean> lpb = null;
		Query query = getSession().createQuery(SELECT_CATEGORY);
		query.setParameter(0,category);
		lpb = query.list();
		return lpb;
		
	}

	@Override
	public ProductBean insert(ProductBean bean) {
		getSession().save(bean);
		return bean;
	}
	@Override
	public ProductBean update(ProductBean bean) {
		getSession().update(bean);
		return bean;
	}
	@Override
	public int delet(Integer productid) {
		int count = 0;
		Query query = getSession().createQuery(DELETE);
		query.setParameter(0, productid);
		count = query.executeUpdate();
			
		return count;
	}

}
