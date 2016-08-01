package com.kidscodetw.eeit.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidscodetw.eeit.admin.service.movie.MovieCrawler;
import com.kidscodetw.eeit.dao.movie.GenreDAO;
import com.kidscodetw.eeit.dao.movie.MovieDAO;
import com.kidscodetw.eeit.dao.movie.MovieGenreDAO;
import com.kidscodetw.eeit.entity.movie.MovieBean;
import com.kidscodetw.eeit.entity.movie.MovieGenreBean;

@Service
public class MovieMapGetMovieGenre {
	
	@Autowired
	private MovieDAO movieDAO;
	
	@Autowired
	private GenreDAO genreDAO;
	
	@Autowired
	private MovieGenreDAO movieGenreDAO;
	
	public void getMovieGenres() {
		Integer genreID = null;
		MovieMapGetMovieGenre getmovie_dao = new MovieMapGetMovieGenre();
		Map<String, String>MOVIE_MAP = MovieCrawler.getMOVIE_MAP();
		List<String> genreList = new ArrayList<String>();
		Iterator iter = MOVIE_MAP.entrySet().iterator();
		List<MovieBean> mb_list = new ArrayList<MovieBean>();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
			mb_list.add(movieDAO.select(entry.getKey()));
		}
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
	
	public String getMovieLink(String movieName) {
		Document doc = null;
		HashMap<String, String> payload = new HashMap<String, String>();
		try {
			payload.put("type", "keyword");
			payload.put("keyword", movieName);
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

}
