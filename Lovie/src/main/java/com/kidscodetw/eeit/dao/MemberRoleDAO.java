package com.kidscodetw.eeit.dao;

import java.util.List;

import org.hibernate.Session;

import com.kidscodetw.eeit.entity.MemberRoleBean;

public interface MemberRoleDAO {

	public abstract List<MemberRoleBean> select();

	public abstract MemberRoleBean select(Integer privilege);

	public abstract MemberRoleBean select(String role);

}