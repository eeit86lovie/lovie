package com.kidscodetw.eeit.entity.report;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chart3")
public class Chart3Bean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer age;
	private Integer cnt;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Chart1Bean [age=" + age + ", cnt=" + cnt + "]";
	}
}
