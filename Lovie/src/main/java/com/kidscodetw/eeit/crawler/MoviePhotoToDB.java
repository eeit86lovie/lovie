package com.kidscodetw.eeit.crawler;

import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kidscodetw.eeit.dao.MovieDAO;
import com.kidscodetw.eeit.entity.MovieBean;
import com.kidscodetw.eeit.service.MovieService;

public class MoviePhotoToDB {

	public static void main(String[] args) {
		new MoviePhotoToDB().getLink();

	}

	public void getLink() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		MovieDAO movieDAO = (MovieDAO)context.getBean("movieDAO");
		MovieBean tempBean = null;
		Map<Integer, byte[]> photos = movieDAO.selectPhotos();
		for (Map.Entry<Integer, byte[]> entry : photos.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue());
			if(entry.getValue()!=null){
				photos.remove(entry.getKey());
			}
		}
		Set<Integer> photo_null = photos.keySet();
		for(Integer i: photo_null){
			tempBean = movieDAO.select(i);
			movieDAO.updatePhotos(tempBean.getPhotoUrl(), tempBean.getId());
		}
	}

}
