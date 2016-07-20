package com.kidscodetw.eeit.dao.member;

import java.util.List;

import com.kidscodetw.eeit.entity.member.MemberBean;

public interface MemberDAO {


	public abstract List<MemberBean> select();

	public abstract MemberBean select(String account);

	public abstract MemberBean select(Integer id);

	public abstract MemberBean insert(MemberBean mb);

	public abstract boolean delete(Integer id);

	public abstract boolean delete(String account);

	public abstract MemberBean update(MemberBean bean);

	public abstract void updatePhotos(String link, Integer id);
	

}