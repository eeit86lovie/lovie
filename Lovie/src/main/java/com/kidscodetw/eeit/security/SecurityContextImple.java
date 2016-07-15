package com.kidscodetw.eeit.security;

import org.springframework.security.core.context.SecurityContextImpl;

import com.kidscodetw.eeit.entity.MemberBean;

public class SecurityContextImple extends SecurityContextImpl{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MemberBean memberBean;

	public void setMemberBean(MemberBean memberBean){
		this.memberBean = memberBean;
	}
	
	public MemberBean getMemberBean(){
		return memberBean;
	}

}
