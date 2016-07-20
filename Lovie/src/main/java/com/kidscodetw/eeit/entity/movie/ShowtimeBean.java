package com.kidscodetw.eeit.entity.movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;



public class ShowtimeBean {
	private Integer id;
	private String movieName;
	private String theaterName;
	private java.util.Date showtimeDate;
	private String showtimeTime;
	private Integer online;
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMovieName() {
		return movieName;
	}



	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}



	public String getTheaterName() {
		return theaterName;
	}



	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}



	public String getShowtimeDate() {
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    return simpleDateFormat.format(showtimeDate);
	}
	public void setShowtimeDate(String date) {
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    try {
			this.showtimeDate = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}



	public String getShowtimeTime() {
		return showtimeTime;
	}



	public void setShowtimeTime(String showtimeTime) {
		this.showtimeTime = showtimeTime;
	}



	@Override
	public String toString(){
		return "model.ShowtimeBean[" +id + "," +
				movieName+ ","+ theaterName + ","+ getShowtimeDate()+ ","+ showtimeTime+ ","+ online+ "]";
	}



	public Integer getOnline() {
		return online;
	}



	public void setOnline(Integer online) {
		this.online = online;
	}
	
}
