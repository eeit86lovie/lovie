package com.kidscodetw.eeit.entity.appointment;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.entity.movie.ShowtimeBean;



//@Component("AppointmentBean2")
@Entity
@Table(name = "Appointment")
public class AppointmentBean2 implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;

	//private Integer memberId;
	@ManyToOne(targetEntity=MemberBean.class,fetch=FetchType.EAGER)
	@JoinColumn(name="memberId",referencedColumnName="id",nullable=true)
	@NotFound(action=NotFoundAction.IGNORE)
	private MemberBean memberBean;
	
	//private Integer showtimeId;
	@ManyToOne(targetEntity=ShowtimeBean.class,fetch=FetchType.EAGER)
	@JoinColumn(name="showtimeId",referencedColumnName="id",nullable=true)
	@NotFound(action=NotFoundAction.IGNORE)
	private ShowtimeBean showtimeBean;

	private java.util.Date pubTime;
	private String content;
	
	//private Integer acceptedMemberId;
	@ManyToOne(targetEntity=MemberBean.class,fetch=FetchType.EAGER)
	@JoinColumn(name="acceptedMemberId",referencedColumnName="id",nullable=true)
	@NotFound(action=NotFoundAction.IGNORE)
	private MemberBean acceptedmemberBean;
	
	private java.util.Date acceptedTime;
	private Integer type;
	private Integer status;
	
	public String toString(){
		return "model.AppointmentBean [id:"+id +" , "+"memberId:"+ //memberId + 
				", showtimeId:"+ //showtimeId+ 
				", pubTime:"
				+ pubTime+ ", content:"+ content +", acceptedMemberId:"+ //acceptedMemberId+ 
				", acceptedTime:"+ acceptedTime +", status:"+ status+"]";
	}
	public java.util.Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(java.util.Date pubTime) {
		this.pubTime = pubTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.util.Date getAcceptedTime() {
		return acceptedTime;
	}
	public void setAcceptedTime(java.util.Date acceptedTime) {
		this.acceptedTime = acceptedTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/*
	public Integer getMemberId() {
		return memberId();
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	*/
	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	/*
	public Integer getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}*/
	public ShowtimeBean getShowtimeBean() {
		return showtimeBean;
	}
	public void setShowtimeBean(ShowtimeBean showtimeBean) {
		this.showtimeBean = showtimeBean;
	}

	/*
	public Integer getAcceptedMemberId() {
		return acceptedMemberId;
	}
	public void setAcceptedMemberId(Integer acceptedMemberId) {
		this.acceptedMemberId = acceptedMemberId;
	}
	*/
	public MemberBean getAcceptedmemberBean() {
		return acceptedmemberBean;
	}
	public void setAcceptedmemberBean(MemberBean acceptedmemberBean) {
		this.acceptedmemberBean = acceptedmemberBean;
	}
}
