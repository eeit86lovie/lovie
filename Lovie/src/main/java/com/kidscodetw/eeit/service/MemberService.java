package com.kidscodetw.eeit.service;

import java.util.List;

import com.kidscodetw.eeit.dao.MemberDAO;
import com.kidscodetw.eeit.entity.MemberBean;

public class MemberService implements MemberDAO{
	
	private MemberDAO memberDAO;
	public MemberService(MemberDAO memberDAOHibernate){
		this.memberDAO = memberDAOHibernate;
	}
	
	public void updatePhoto(String link, int id){
		memberDAO.updatePhoto(link, id);
	}

	public List<MemberBean> select(){
		List<MemberBean> result = null;
		result = memberDAO.select();
		return result;
	}

	public MemberBean select(String account){
		MemberBean result = null;
		if(account!=null && account.length()!=0){
			result = memberDAO.select(account);
		}
		return result;
	}

	public MemberBean select(int id){
		MemberBean result = null;
		if(id!=0){
			result = memberDAO.select(id);
		}
		return result;
	}

	public MemberBean insert(MemberBean bean){
		MemberBean result = null;
		if(bean!=null){
			result = memberDAO.insert(bean);
		}
		return result;
	}

	public boolean delete(int id){
		boolean result = false;
		if(id!=0){
			result = memberDAO.delete(id);
		}
		return result;
	}

	public boolean delete(String account){
		boolean result = false;
		if(account!=null && account.length()!=0){
			result = memberDAO.delete(account);
		}
		return result;
	}

//	public MemberBean update(MemberBean bean){
//		MemberBean result = null;
//		if(bean!=null && bean.getId()!=0){
//			String password = bean.getPassword();
//			int gender = bean.getGender();
//			String email = bean.getEmail();
//			String nickname = bean.getNickname();
//			String city = bean.getCity();
//			String district = bean.getDistrict();
//			int privilege = bean.getPrivilege();
//			String photoUrl = bean.getPhotoUrl();
//			String birthday = bean.getBirthday();
//			int friendNum = bean.getFriendNum();
//			int commentPoint = bean.getCommentPoint();
//			String intro = bean.getIntro();
//			String constellation = bean.getConstellation();
//			String lastOnTime = bean.getLastOnTime();
//			int id = bean.getId();
//			result = memberDao.update(password, gender, email, nickname, city, district, privilege, photoUrl
//					, birthday, friendNum, commentPoint, intro, constellation, lastOnTime, id);
//		}
//		return result;
//	}
	
	public MemberBean update(MemberBean bean){
		if(bean !=null){
			return memberDAO.update(bean);
		}
		return null;
	}

}
