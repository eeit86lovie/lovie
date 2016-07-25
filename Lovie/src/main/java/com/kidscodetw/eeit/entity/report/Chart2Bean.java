package com.kidscodetw.eeit.entity.report;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chart2")
public class Chart2Bean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer gender;
	private Integer cnt;
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Chart1Bean [gender=" + gender + ", cnt=" + cnt + "]";
	}
}
