package com.kidscodetw.eeit.entity.appointment;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppointmentsBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String title;
	private String color;
	private String tooltip;
	@Id
	private String start;
	private String url;
	@Id
	private Integer mId;
	@Id
	private Integer showtimeId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTooltip() {
		return tooltip;
	}
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public Integer getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}
	@Override
	public String toString() {
		return "AppointmentsBean [id=" + id + ", title=" + title + ", color=" + color + ", tooltip=" + tooltip
				+ ", start=" + start + ", url=" + url + ", mId=" + mId + ", showtimeId=" + showtimeId + "]";
	}
	
}
