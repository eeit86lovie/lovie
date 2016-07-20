package com.kidscodetw.eeit.service.movie;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.movie.ShowtimeDAO;
import com.kidscodetw.eeit.entity.movie.ShowtimeBean;


@Controller
public class ShowtimeJson {
	
	@Autowired
	private ShowtimeDAO showtimeDAO;
	
	@RequestMapping(value="showtimeJsonByMovie/{movieName}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public List<ShowtimeBean> showtimeJsonByMovie(@PathVariable("movieName") String movieName){
		return showtimeDAO.selectMovie(movieName);
	}
	
	@RequestMapping(value="showtimeJsonByTheater/{theaterName}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public List<ShowtimeBean> showtimeJsonByTheater(@PathVariable("theaterName") String theaterName){
		return showtimeDAO.selectTheater(theaterName);
	}

}
