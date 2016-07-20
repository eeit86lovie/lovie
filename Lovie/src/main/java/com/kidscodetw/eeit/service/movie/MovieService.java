package com.kidscodetw.eeit.service.movie;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kidscodetw.eeit.dao.movie.MovieDAO;
import com.kidscodetw.eeit.entity.movie.MovieBean;

@Path("/movies")
public class MovieService implements MovieDAO{
	
	private MovieDAO movieDao;
	public MovieService(MovieDAO movieDAOHibernate){
		this.movieDao = movieDAOHibernate;
	}
	
	public Map<Integer, byte[]> selectPhotos(){
		@SuppressWarnings("unchecked")
		Map<Integer, byte[]> photos = movieDao.selectPhotos();
		return photos;
	}
	
	
	public void updatePhotos(String link, Integer id) {
		if(link!=null && link.length()!=0 && id!=0){
			movieDao.updatePhotos(link, id);
		}
	}
	
	public List<String> select_movienames() {
		List<String> result = null;
		result = movieDao.select_movienames();
		return result;
	}

	
	
	public MovieBean select(Integer ID){
		MovieBean result = null;
		if(ID!=0){
			result = movieDao.select(ID);
		}
		return result;
	}

	public MovieBean select(String Name){
		MovieBean result = null;
		if(Name!=null && Name.length()!=0){
			result = movieDao.select(Name);
		}
		return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON+" ;charset=UTF-8")
	public List<MovieBean> select(){
		List<MovieBean> result = null;
		result = movieDao.select();
		return result;
	}

	public boolean delete(Integer ID){
		boolean result = false;
		if(ID!=0){
			result = movieDao.delete(ID);
		}
		return result;
	}

	public MovieBean insert(MovieBean bean){
		MovieBean result = null;
		if(bean!=null){
			try{
			result = movieDao.insert(bean);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	public MovieBean update(MovieBean bean){
		MovieBean result = null;
		if(bean!=null){
			result = movieDao.update(bean);
		}
		return result;
	}
	
	

}
