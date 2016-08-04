package com.kidscodetw.eeit.dao.member;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.kidscodetw.eeit.entity.member.FriendBean;

public class FriendDAOHibernate implements FriendDAO {
	private SessionFactory sessionFactory;

	public FriendDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// 取得所有名單
	@Override
	public List<FriendBean> selectAll() {
		Query query = getSession().createQuery("from FriendBean");
		return query.list();
	}

	// 條件查詢好友(1)、對誰感興趣(2)、誰對自己感興趣(3)
	@Override
	public List<FriendBean> selectPart(Integer memberId, Integer relation) {
		Query query = getSession()
				.createQuery(
						"from FriendBean where memberId=:memberId and relation=:relation");
		query.setParameter("memberId", memberId);
		query.setParameter("relation", relation);
		return query.list();
	}

	// 查詢單一帳號對自己的狀態
	@Override
	public FriendBean selectOne(Integer memberId, Integer friendId) {
		Query query = getSession()
				.createQuery(
						"from FriendBean where memberId=:memberId and friendId=:friendId");
		query.setParameter("memberId", memberId);
		query.setParameter("friendId", friendId);
		return (FriendBean) query.list().get(0);
	}

	@Override
	public FriendBean insert(FriendBean bean) {
		this.getSession().save(bean);
		return bean;
	}

	//更新關係狀態
	@Override
	public FriendBean update(FriendBean bean) {
		if (bean != null && bean.getMemberId() != 0) {
			this.getSession().saveOrUpdate(bean);
		}
		return bean;
	}

}
