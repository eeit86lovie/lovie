package com.kidscodetw.eeit.dao;

import java.util.List;

import com.kidscodetw.eeit.entity.MemberBean;

public interface MemberDAO {

	public abstract void updatePhoto(String link, int id);

	public abstract List<MemberBean> select();

	public abstract MemberBean select(String account);

	public abstract MemberBean select(int id);

	public abstract MemberBean insert(MemberBean mb);

	public abstract boolean delete(int id);

	public abstract boolean delete(String account);

	public abstract MemberBean update(MemberBean bean);

}