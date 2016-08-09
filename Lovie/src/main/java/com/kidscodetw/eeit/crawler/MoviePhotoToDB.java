package com.kidscodetw.eeit.crawler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kidscodetw.eeit.dao.movie.MovieDAO;
import com.kidscodetw.eeit.entity.movie.MovieBean;
import com.kidscodetw.eeit.jdbc.MovieDAOJdbc;

public class MoviePhotoToDB {

//	public static void main(String[] args) {
//		new MoviePhotoToDB().getLink();
//
//	}

	public static void getLink() {
		MovieDAOJdbc movieDAO = new MovieDAOJdbc();
		MovieBean tempBean = null;
		List<Integer> photo_null = movieDAO.checkPhotoNull();
		for(Integer i: photo_null){
			tempBean = movieDAO.select(i);
			movieDAO.updatePhotos(tempBean.getPhotoUrl(), tempBean.getId());
		}
	}

}
