package com.kidscodetw.eeit.admin.controller.broadcast;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.kidscodetw.eeit.entity.member.MemberBean;

@Service
public class OnlineUserRepo {
	
	private static Set<MemberBean> ONLINE_USER = new HashSet<MemberBean>();
	
	public static Set<MemberBean> getOnlineUser(){
		return OnlineUserRepo.ONLINE_USER;
	}
}
