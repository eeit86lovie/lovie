package com.kidscodetw.eeit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.kidscodetw.eeit.dao.TheaterDAO;
import com.kidscodetw.eeit.entity.TheaterBean;


@Controller
@RequestMapping("theaters.mvc")
public class TheaterFindAllMVC {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getTheaters(WebApplicationContext context,Model model){
		TheaterDAO dao = (TheaterDAO)context.getBean("theaterDAO");
		List<TheaterBean> theater_list = dao.select();
		model.addAttribute("theaters", theater_list);
		List<String> city_list = new ArrayList<String>();
		for(TheaterBean theater: theater_list){
			if(!city_list.contains(theater.getCity())){
				city_list.add(theater.getCity());
			}
		}
		model.addAttribute("citys", city_list);
		return "theater/alltheaters.jsp";
	}

}
