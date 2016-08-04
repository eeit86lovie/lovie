package com.kidscodetw.eeit.entity.member;

import java.io.Serializable;

public class InterestedMoviesBean implements Serializable {
 private Integer memberId;
 private Integer genreId;
public Integer getMemberId() {
	return memberId;
}
public void setMemberId(Integer memberId) {
	this.memberId = memberId;
}
public Integer getGenreId() {
	return genreId;
}
public void setGenreId(Integer genreId) {
	this.genreId = genreId;
}
 
}
