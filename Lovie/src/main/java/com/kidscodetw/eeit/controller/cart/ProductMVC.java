package com.kidscodetw.eeit.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kidscodetw.eeit.dao.cart.ProductDAO;





@Controller
@RequestMapping("products")
public class ProductMVC {

		@Autowired
		private ProductDAO productDAO;

		@RequestMapping(method = RequestMethod.GET)
		public String productJsp() {
			return "product/product.jsp";
		}
	

		

}



