package com.kidscodetw.eeit.admin.service.movie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kidscodetw.eeit.dao.movie.MovieDAO;

@Controller
public class MovieDeleteService {
	
	@Autowired
	MovieDAO movieDAO;
	
	@RequestMapping("admin/movie/delete/{id}")
	public void deleteMovie(@PathVariable Integer id, HttpServletResponse response){
		boolean result = movieDAO.delete(id);
		PrintWriter out = null;
		String result2 = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(result==true){
			result2 = "yes";
		}else{
			result2 = "no";
		}
		out.write(result2);
	}
}
