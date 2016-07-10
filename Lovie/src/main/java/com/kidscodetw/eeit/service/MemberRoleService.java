package com.kidscodetw.eeit.service;

import java.util.List;

import org.hibernate.Session;

import com.kidscodetw.eeit.dao.MemberRoleDAO;
import com.kidscodetw.eeit.entity.MemberRoleBean;

public class MemberRoleService implements MemberRoleDAO{
	
	private MemberRoleDAO memberRoleDao;
	public MemberRoleService(MemberRoleDAO memberRoleDAOHibernate){
		this.memberRoleDao = memberRoleDAOHibernate;
	}
	
	public List<MemberRoleBean> select(){
		List<MemberRoleBean> result = null;
		result = memberRoleDao.select();
		return result;
	}

	public MemberRoleBean select(Integer privilege){
		MemberRoleBean result = null;
		if(privilege!=null && privilege!=0){
			result = memberRoleDao.select(privilege);
		}
		return result;
	}

	public MemberRoleBean select(String role){
		MemberRoleBean result = null;
		if(role!=null && role.length()!=0){
			result = memberRoleDao.select(role);
		}
		return result;
	}

	

}
