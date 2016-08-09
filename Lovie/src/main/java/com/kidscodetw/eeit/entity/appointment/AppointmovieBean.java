package com.kidscodetw.eeit.entity.appointment;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.kidscodetw.eeit.entity.movie.ShowtimeBean;

@Entity
public class AppointmovieBean implements Serializable {
	@Id
	private Integer id;
	private String name;
	private String rank;
	private String startTime;
	private String intro;
	@Transient
	private String genrelist;
	@Transient
	private Set<ShowtimeBean> showtimeBeans = new LinkedHashSet<ShowtimeBean>();
	
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

	public String getGenrelist() {
		return genrelist;
	}

	public void setGenrelist(String genrelist) {
		this.genrelist = genrelist;
	}

	public Set<ShowtimeBean> getShowtimeBeans() {
		return showtimeBeans;
	}

	public void setShowtimeBeans(Set<ShowtimeBean> showtimeBeans) {
		this.showtimeBeans = showtimeBeans;
	}

	@Override
	public String toString() {
		return "AppointmovieBean [id=" + id + ", name=" + name + ", rank=" + rank + ", startTime=" + startTime
				+ ", intro=" + intro + ", genrelist=" + genrelist + ", showtimeBeans="
				+ showtimeBeans + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj!=null && (obj instanceof AppointmovieBean)) {
			AppointmovieBean temp = (AppointmovieBean) obj;
			if(this.id == temp.id) {
				return true;
			}
		}
		return false;
	}
}
