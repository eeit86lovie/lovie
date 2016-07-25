package com.kidscodetw.eeit.crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kidscodetw.eeit.dao.movie.MovieDAO;
import com.kidscodetw.eeit.entity.movie.MovieBean;
import com.kidscodetw.eeit.jdbc.MovieDAOJdbc;

public class MoviePhotoToDB {

	public static void main(String[] args) {
		new MoviePhotoToDB().getLink();

	}

	public void getLink() {
		MovieDAO movieDAO = new MovieDAOJdbc();
		MovieBean tempBean = null;
		Map<Integer, byte[]> photos = movieDAO.selectPhotos();
		List<Integer> tempList = new ArrayList<Integer>();
//		Set<Integer> photosKeys = photos.keySet();
//		for(Integer key: photosKeys){
//			if(photos.get(key)!=null){
//				tempList.add(key);
//			}
//		}
//		for(Integer key2: tempList){
//			photos.remove(key2);
//		}
		
		Set<Integer> photo_null = photos.keySet();
		for(Integer i: photo_null){
			tempBean = movieDAO.select(i);
			movieDAO.updatePhotos(tempBean.getPhotoUrl(), tempBean.getId());
		}
	}

}
