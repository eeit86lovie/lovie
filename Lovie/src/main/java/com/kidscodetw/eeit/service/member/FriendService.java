package com.kidscodetw.eeit.service.member;

import java.util.List;

import com.kidscodetw.eeit.dao.member.FriendDAO;
import com.kidscodetw.eeit.dao.member.FriendDAOHibernate;
import com.kidscodetw.eeit.entity.member.FriendBean;

public class FriendService implements FriendDAO{
	
	private FriendDAO friendDAO;
	
	public FriendService(FriendDAO friendDAOHibernate){
		this.friendDAO = friendDAOHibernate;
	}
	

	@Override
	public List<FriendBean> selectAll() {
		return friendDAO.selectAll();
	}

	@Override
	public List<FriendBean> selectPart(Integer memberId, Integer relation) {
		return friendDAO.selectPart(memberId, relation);
	}

	@Override
	public FriendBean selectOne(Integer memberId, Integer friendId) {
		return friendDAO.selectOne(memberId, friendId);
	}

	@Override
	public FriendBean insert(FriendBean bean) {
		return friendDAO.insert(bean);
	}

	@Override
	public FriendBean update(FriendBean bean) {
		return friendDAO.update(bean);
	}


	@Override
	public boolean delete(FriendBean bean) {
		return friendDAO.delete(bean);
	}

	

	

	

}
