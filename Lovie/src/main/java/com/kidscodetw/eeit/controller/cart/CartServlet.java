package com.kidscodetw.eeit.controller.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kidscodetw.eeit.dao.cart.ProductDAO;
import com.kidscodetw.eeit.entity.cart.ProductBean;
import com.kidscodetw.eeit.service.cart.ProductService;



@WebServlet("/product/cart.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	
	
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext(); 
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		productService =(ProductService) context.getBean("productService");
	}

	private List<Map<String, Object>> addcart ;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AAA");
		response.setContentType("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Integer productid = Integer.parseInt(request.getParameter("productId"));
		Integer amount =Integer.parseInt(request.getParameter("amount"));
		System.out.println(amount+"BBBB");
		System.out.println(productid);
		ProductBean pb=productService.select_id(productid);
		addcart= (List<Map<String, Object>>)session.getAttribute("addcartlist");
		if(addcart!=null && addcart.size()!=0){
			Iterator<Map<String, Object>> check = addcart.iterator();	
				while(check.hasNext()){
					Map<String, Object> m2= check.next();
					ProductBean bean1 = (ProductBean) m2.get("bean");
					if(bean1.getProductid().equals(productid)){
						m2.replace("amount", amount);
						out.print("modified");
						break;
					}else{
						if(check.hasNext()){
							continue;
						}else{
							Map<String, Object> m1 = new HashMap<String, Object>();
							m1.put("bean", pb);
							m1.put("amount", amount);
							addcart.add(m1);		
							session.setAttribute("addcartlist", addcart);
							out.print("success");
							break;
						}
					}					
				}
		}else{
			Map<String, Object> m1 = new HashMap<String, Object>();
			addcart = new ArrayList<Map<String, Object>>();
			m1.put("bean", pb);
			m1.put("amount", amount);
			addcart.add(m1);		
			session.setAttribute("addcartlist", addcart);	
			out.print("success");
	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Integer productid = Integer.parseInt(request.getParameter("productid"));
		String amount = request.getParameter("amount");
		ProductBean pb = productService.select_id(productid);
		addcart = (List<Map<String, Object>>)session.getAttribute("addcartlist");
		Iterator<Map<String, Object>> check = addcart.iterator();	
		while(check.hasNext()){
			Map<String, Object> m3 = check.next();
			ProductBean bean1 = (ProductBean) m3.get("bean");
			if(bean1.getProductid()==productid){
				addcart.remove(m3);
				out.print("success");
				break;
			}
		}
	}

}
