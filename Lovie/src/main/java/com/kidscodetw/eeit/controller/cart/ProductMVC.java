package com.kidscodetw.eeit.controller.cart;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("products")
public class ProductMVC {

		@RequestMapping(method = RequestMethod.GET)
		public String productJsp() {
			return "product/product.jsp";
		}
	
}



