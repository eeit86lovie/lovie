package com.kidscodetw.eeit.entity.report;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chart1")
public class Chart1Bean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String age;
	@Id
	private Integer gender;
	private Integer sumcnt;
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getSumcnt() {
		return sumcnt;
	}
	public void setSumcnt(Integer sumcnt) {
		this.sumcnt = sumcnt;
	}
	@Override
	public String toString() {
		return "Chart1Bean [age=" + age + ", gender=" + gender + ", sumcnt=" + sumcnt + "]";
	}
}
