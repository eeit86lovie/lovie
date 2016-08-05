package com.kidscodetw.eeit.dao.member;

import java.util.List;

import org.hibernate.Session;

import com.kidscodetw.eeit.entity.member.InterestedMoviesBean;

public interface InterestedMoviesDAO {

	public abstract Session getSession();

	public abstract List<InterestedMoviesBean> select();

	public abstract List<InterestedMoviesBean> selectByMemberId(Integer memberId);

	public abstract List<InterestedMoviesBean> selectByGenreId(Integer genreId);

	public abstract InterestedMoviesBean insert(InterestedMoviesBean bean);

	public abstract boolean delete(InterestedMoviesBean bean);

}