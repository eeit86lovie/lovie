package com.kidscodetw.eeit.entity;



public class MovieBean {
	private Integer id;
	private String name;
	private String rank;
	private String startTime;
	private String intro;
	private String photoUrl;
	private byte[] photo;
	private String trailer;
	private String filmLength;
	private Integer online;


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getRank() {
		return rank;
	}



	public void setRank(String rank) {
		this.rank = rank;
	}



	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getIntro() {
		return intro;
	}



	public void setIntro(String intro) {
		this.intro = intro;
	}



	public String getPhotoUrl() {
		return photoUrl;
	}



	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}



	public byte[] getPhoto() {
		return photo;
	}



	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}



	public String getTrailer() {
		return trailer;
	}



	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}



	public String getFilmLength() {
		return filmLength;
	}



	public void setFilmLength(String filmLength) {
		this.filmLength = filmLength;
	}



	@Override
	public String toString(){
		return "model.MovieBean [id:"+
				id+ ", name:"+ name + ", rank:"+ rank+ ", startTime:"+ startTime+ ", filmLength:"+ filmLength +", intro:"+ intro+ ", photoUrl:"+ 
				photoUrl+", trailer:"+trailer+", online:"+online+"]";
	}
	

	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && (obj instanceof MovieBean)) {
			MovieBean temp = (MovieBean) obj;
			if(this.id == temp.id) {
				return true;
			}
		}
		return false;
	}



	public Integer getOnline() {
		return online;
	}



	public void setOnline(Integer online) {
		this.online = online;
	}
	
	

}
