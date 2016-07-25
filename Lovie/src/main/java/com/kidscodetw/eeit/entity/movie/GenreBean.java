package com.kidscodetw.eeit.entity.movie;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class GenreBean {
	
	private Integer id;
	private String name;
	
	
	


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





	public String toString(){
		return "model.GenreBean["+
				"GenreID: " +id+ ", GenreName: "+ name+"]";
	}
	

	

}
