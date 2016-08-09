package com.kidscodetw.eeit.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kidscodetw.eeit.dao.movie.GenreDAO;
import com.kidscodetw.eeit.dao.movie.MovieDAO;
import com.kidscodetw.eeit.dao.movie.MovieGenreDAO;
import com.kidscodetw.eeit.entity.movie.MovieBean;
import com.kidscodetw.eeit.entity.movie.MovieGenreBean;
import com.kidscodetw.eeit.service.movie.GenreService;
import com.kidscodetw.eeit.service.movie.MovieService;

public class GetMovieGenre {

	public static void main(String[] args) {
		Integer genreID = null;
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		MovieDAO movieDAO = (MovieDAO)context.getBean("movieDAO");
		GenreDAO genreDAO = (GenreDAO)context.getBean("genreDAO");
		MovieGenreDAO movieGenreDAO = (MovieGenreDAO)context.getBean("movieGenreDAO");
		
		GetMovieGenre getmovie_dao = new GetMovieGenre();
		List<MovieBean> mb_list = movieDAO.select();
		List<String> genreList = new ArrayList<String>();

		for(MovieBean mb : mb_list){
			genreList = getmovie_dao.getGenreList(mb.getName());
			for(String genreName: genreList){
				MovieGenreBean mgb = new MovieGenreBean();
				mgb.setMovieId(mb.getId());
				try{
				genreID = genreDAO.select(genreName).getId();
				}catch(Exception e){
					e.printStackTrace();
				}
				if(genreID.equals(null)){
					genreID = 19;
				}
				mgb.setGenreId(genreID);
				movieGenreDAO.insert(mgb);
				System.out.println("新增 "+mb.getName()+"("+mb.getId()+")"+": "+genreName);
			}
		}	
	}

	public String getMovieLink(String s) {
		Document doc = null;
		HashMap<String, String> payload = new HashMap<String, String>();
		try {
			payload.put("type", "keyword");
			payload.put("keyword", s);
			payload.put("imageField2.x", "0");
			payload.put("imageField2.y", "0");
			payload.put("act", "movie");
			try{
			doc = Jsoup.connect("http://movie.kingmedia.com.tw/search/search.php")
					.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.86 Safari/537.36")
					.data(payload)
					.postDataCharset("Big5")
					.post();
			}catch(java.net.SocketTimeoutException e){
				System.out.println(e.getMessage());
			}
			String result = doc.select("tr.textblue>td>a").attr("href");
			return result;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<String> getGenreList(String movieName){
		String movieLink = getMovieLink(movieName);
		String link = "http://movie.kingmedia.com.tw/search/"+movieLink;
		try {
			Document doc = Jsoup.connect(link).get();
			String result = doc.select("td:eq(1)>table>tbody>tr>td:eq(1)").html();
			String genre_row = result.split("\n")[0];
			Pattern p = Pattern.compile(">(..)</a>");
			Matcher m = p.matcher(genre_row);
			List<String> genre_list = new ArrayList<String>();
			while(m.find()){
				genre_list.add(m.group(1));
			}
			return genre_list;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
