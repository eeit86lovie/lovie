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
import java.sql.Timestamp;

@Entity
@Table(name = "AppointmentRequest")
public class AppointmentRequestBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Integer appointmentID;
	@Id
	private Integer requestMemberId;
	private Timestamp requestAppointmentTime;
	private String content;
	private Integer status;
	public Integer getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(Integer appointmentID) {
		this.appointmentID = appointmentID;
	}
	public Integer getRequestMemberId() {
		return requestMemberId;
	}
	public void setRequestMemberId(Integer requestMemberId) {
		this.requestMemberId = requestMemberId;
	}
	public Timestamp getRequestAppointmentTime() {
		return requestAppointmentTime;
	}
	public void setRequestAppointmentTime(Timestamp requestAppointmentTime) {
		this.requestAppointmentTime = requestAppointmentTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AppointmentRequestBean [appointmentID=" + appointmentID + ", requestMemberId=" + requestMemberId
				+ ", requestAppointmentTime=" + requestAppointmentTime + ", content=" + content + ", status=" + status
				+ "]";
	}
}
