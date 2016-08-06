package com.kidscodetw.eeit.service.member;

import java.util.List;

import com.kidscodetw.eeit.dao.member.InterestedMoviesDAO;
import com.kidscodetw.eeit.entity.member.InterestedMoviesBean;

public class InterestedMoviesSerivce implements InterestedMoviesDAO{
	private InterestedMoviesDAO interestedMoviesDAOHibernate;
	public InterestedMoviesSerivce(InterestedMoviesDAO interestedMoviesDAOHibernate){
		this.interestedMoviesDAOHibernate = interestedMoviesDAOHibernate;
	}
	@Override
	public List<InterestedMoviesBean> select() {
		return interestedMoviesDAOHibernate.select();
	}
	@Override
	public List<InterestedMoviesBean> selectByMemberId(Integer memberId) {
		return interestedMoviesDAOHibernate.selectByMemberId(memberId);
	}
	@Override
	public List<InterestedMoviesBean> selectByGenreId(Integer genreId) {
		return interestedMoviesDAOHibernate.selectByGenreId(genreId);
	}
	@Override
	public InterestedMoviesBean insert(InterestedMoviesBean bean) {
		return interestedMoviesDAOHibernate.insert(bean);
	}
	@Override
	public boolean delete(InterestedMoviesBean bean) {
		return interestedMoviesDAOHibernate.delete(bean);
	}

}
