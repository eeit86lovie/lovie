package com.kidscodetw.eeit.security;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.dao.member.MemberRoleDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.entity.member.MemberRoleBean;


public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	HttpServletRequest request;
	
	private MemberDAO memberDAO;
	private MemberRoleDAO memberRoleDAO;
	
	public void setMemberDAO(MemberDAO memberDAO){
		this.memberDAO = memberDAO;
	}
	
	public void setMemberRoleDAO(MemberRoleDAO memberRoleDAO){
		this.memberRoleDAO = memberRoleDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String account)
			throws UsernameNotFoundException {
		UserDetails userDetails = null;
		MemberBean memberBean = memberDAO.select(account);
		if (memberBean != null) {
			Collection<GrantedAuthority> authList = getAuthorities(memberBean.getPrivilege());
			userDetails = new User(account, memberBean.getPassword(), true,
					true, true, true, authList);
		}
		SecurityContextImple context = new SecurityContextImple();
		context.setMemberBean(memberBean);
		SecurityContextHolder.setContext(context);
		
		return userDetails;
	}

	private Collection<GrantedAuthority> getAuthorities(Integer privilege) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		while(privilege>0){
			MemberRoleBean roleBean = memberRoleDAO.select(privilege);
			String role = roleBean.getRole();
			authList.add(new SimpleGrantedAuthority(role));
			privilege = privilege-1;
		}
		return authList;
	}
	
	

}
