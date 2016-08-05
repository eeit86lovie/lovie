package com.kidscodetw.eeit.controller.member;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.member.FriendDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.FriendBean;
import com.kidscodetw.eeit.entity.member.MemberBean;

@Controller
@RequestMapping("/member/AddOrRemoveFriendService")
public class AddOrRemoveFriendService {
	@Autowired
	private FriendDAO friendDAO;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(method = RequestMethod.POST, value="/addFriend", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public void addFriend(HttpSession session,
//			@RequestParam Integer memberId,
			@RequestParam Integer friendId,
			Model model){
		System.out.println("進來啦!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Integer memberId=(((MemberBean)session.getAttribute("loginmember"))).getId();
		FriendBean myFBean=null;
		FriendBean otherFBean=null;
		myFBean=friendDAO.selectOne(memberId, friendId);
		if(myFBean==null){//代表兩人原本無關係
			myFBean.setMemberId(memberId);
			myFBean.setFriendId(friendId);
			myFBean.setRelation(3);
			friendDAO.insert(myFBean);
			otherFBean.setMemberId(friendId);
			otherFBean.setFriendId(memberId);
			otherFBean.setRelation(2);
			friendDAO.insert(otherFBean);
		}else if(myFBean.getRelation()==3){
			myFBean.setRelation(1);
			otherFBean=friendDAO.selectOne(friendId, memberId);
			otherFBean.setRelation(1);
			friendDAO.update(myFBean);
			friendDAO.update(otherFBean);
		}
		
	}
	
}
