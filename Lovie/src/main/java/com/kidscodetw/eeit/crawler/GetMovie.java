package com.kidscodetw.eeit.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kidscodetw.eeit.dao.movie.MovieDAO;
import com.kidscodetw.eeit.entity.movie.MovieBean;
import com.kidscodetw.eeit.service.movie.MovieService;

public class GetMovie {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		MovieDAO movieDAO = (MovieDAO)context.getBean("movieDAO");

		GetMovie gm = new GetMovie();
		Map<String,String> movie_map = gm.getMovieMap();
		List<MovieBean> list_mb = movieDAO.select();
		for(MovieBean mb: list_mb){
			if(movie_map.containsKey(mb.getName())){
				movie_map.remove(mb.getName());
			}
		}
		
		System.out.println("準備新增:"+movie_map.size()+"部電影");
		
		Iterator iter = movie_map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
			System.out.println(entry.getKey());
		}
		
	}



	// Get all movie link from "http://www.atmovies.com.tw/movie/now/" to an
	// ArrayList
	public Map<String, String> getMovieMap() {
		Map<String, String> movie_map = null;
		String movieListUrl = "http://www.atmovies.com.tw/movie/now/";
		try {

			Document doc = Jsoup.connect(movieListUrl).timeout(5000).get();
			Elements links = doc.select("ul.FilmListAll2 >li>a");
			movie_map = new HashMap<String, String>();
			for (Element link : links) {
				movie_map.put(link.text(), link.attr("href"));
			}
			return movie_map;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return movie_map;

	}

	
	public MovieBean getMovieContext(String movieLink) {
		
		MovieBean mb = null;
		String movieUrl = "http://www.atmovies.com.tw"+movieLink;
		String mTrailer;

		try {
			Document doc = Jsoup.connect(movieUrl).timeout(5000).get();
			// get mName
			Elements mName_row = doc.select("div.filmTitle");
			String mName = mName_row.get(0).toString().split("--> ")[1].split("\n")[0].split(" ")[0];

			// get mIntro
			Elements mIntro_row = doc.select("div#filmTagBlock>span:eq(2)");
			String mIntro = mIntro_row.get(0).toString().split("\n")[0].substring(7);

			// get mStartTime
			Elements mStartTime_row = doc.select("div#filmTagBlock>span:eq(2)>ul>li:eq(1)");
			Pattern p = Pattern.compile("(\\d\\d\\d\\d/\\d\\d/\\d\\d)");
			Matcher m = p.matcher(mStartTime_row.html());
			String mStartTime = "";
			if (m.find()) {
				mStartTime = m.group();
			} else {
				mStartTime_row = doc.select("div#filmTagBlock>span:eq(2)>ul>li:eq(1)");
				Pattern p2 = Pattern.compile("(\\d\\d\\d\\d/\\d\\d/\\d\\d)");
				Matcher m2 = p2.matcher(mStartTime_row.html());
				if (m.find()) {
					mStartTime = m.group();
				}
			}
			// get mFilmLength
			Elements mFilmLength_row = doc.select("div#filmTagBlock>span:eq(2)>ul>li:eq(0)");
			String mFilmLength = mFilmLength_row.get(0).toString().split("：")[1].split("<")[0];

			// get mPhotoUrl
			Elements mPhotoUrl_row = doc.select("div#filmTagBlock>span>a>img");
			String mPhotoUrl = mPhotoUrl_row.get(0).attr("src");

			// get mTrailer
			Elements mTrailer_row = doc.select("DIV.video_view>iframe");
			try {
				mTrailer = mTrailer_row.get(0).attr("src");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("mTrailer Null");
				mTrailer = null;
				// e.printStackTrace();
			}

			// get mRank
			String mRank = "";
			Elements rankUrl = doc.select("div.filmTitle>img");
			try {
				String mRank_row = rankUrl.get(0).attr("src");
				mRank = parseRank(mRank_row);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("mRank Null");
				// e.printStackTrace();
			}
			mb = new MovieBean();
			mb.setName(mName);
			mb.setRank(mRank);
			mb.setStartTime(mStartTime.replace("/", "-"));
			mb.setFilmLength(mFilmLength);
			mb.setPhotoUrl(mPhotoUrl);
			mb.setTrailer(mTrailer);
			mb.setIntro(mIntro);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mb;

	}

	public String parseRank(String img) {
		switch (img) {
		case "/images/cer_G.gif":
			return "0";
		case "/images/cer_P.gif":
			return "6";
		case "/images/cer_F2.gif":
			return "12";
		case "/images/cer_F5.gif":
			return "15";
		case "/images/cer_R.gif":
			return "18";
		}

		return null;
	}

}
