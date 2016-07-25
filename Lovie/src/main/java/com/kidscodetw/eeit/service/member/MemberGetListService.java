package com.kidscodetw.eeit.service.member;

import java.util.ArrayList;
import java.util.List;

import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;

public class MemberGetListService {
	private static List<MemberBean> allMembers = new ArrayList<MemberBean>();
	private static List<MemberBean> allGirls = new ArrayList<MemberBean>();
	private static List<MemberBean> allBoys = new ArrayList<MemberBean>();
	private MemberDAO memberDAO;

	public MemberGetListService(MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
		if (allMembers.isEmpty()) {
			allMembers = memberDAO.select();
			for (MemberBean bean : allMembers) {
				if (bean.getGender() == 0) {
					allGirls.add(bean);
				} else if (bean.getGender() == 1) {
					allBoys.add(bean);
				}
			}

		}
	}

	public MemberBean checkAccountPassword(String account, String password) {
		
		for (MemberBean bean : allMembers) {
			if (bean.getAccount().equals(account) && bean.getPassword().equals(password)) {
				return bean;
			}
		}
		return null;
	}

	public static List<MemberBean> getAllMembers() {
		return allMembers;
	}

	public static List<MemberBean> getAllGirls() {
		return allGirls;
	}

	public static List<MemberBean> getAllBoys() {
		return allBoys;
	}

	public void addNewMember(MemberBean bean) {
		allMembers.add(bean);
		if (bean.getGender() == 0) {
			allGirls.add(bean);
		} else if (bean.getGender() == 1) {
			allBoys.add(bean);
		}
	}
}
