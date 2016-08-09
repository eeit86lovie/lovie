package com.kidscodetw.eeit.admin.controller.broadcast;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kidscodetw.eeit.entity.member.MemberBean;

@Service
public class OnlineUserRepo {
	
	private static List<MemberBean> ONLINE_USER = new ArrayList<MemberBean>();
	
	public static List<MemberBean> getOnlineUser(){
		return OnlineUserRepo.ONLINE_USER;
	}
}
