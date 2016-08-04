package com.kidscodetw.eeit.dao.member;

import java.util.List;

import org.hibernate.Session;

import com.kidscodetw.eeit.entity.member.FriendBean;

public interface FriendDAO {

	// 取得所有名單
	public abstract List<FriendBean> selectAll();

	// 條件查詢好友(1)、誰對自己感興趣(2)、對誰感興趣(3)
	public abstract List<FriendBean> selectPart(Integer memberId,
			Integer relation);

	// 查詢單一帳號對自己的狀態
	public abstract FriendBean selectOne(Integer memberId, Integer friendId);

	public abstract FriendBean insert(FriendBean bean);

	public abstract FriendBean update(FriendBean bean);

}