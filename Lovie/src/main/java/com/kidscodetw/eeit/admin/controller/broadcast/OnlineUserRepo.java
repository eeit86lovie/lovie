package com.kidscodetw.eeit.admin.controller.broadcast;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kidscodetw.eeit.entity.member.MemberBean;

@Service
public class OnlineUserRepo {
	
	private static Map<String,MemberBean> ONLINE_USER = new HashMap<String,MemberBean>();
	
	public static Map<String,MemberBean> getOnlineUser(){
		return OnlineUserRepo.ONLINE_USER;
	}
}
