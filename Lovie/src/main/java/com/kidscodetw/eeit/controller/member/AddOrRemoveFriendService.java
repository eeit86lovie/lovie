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
			@RequestParam Integer friendId,
			Model model){
		Integer memberId=(((MemberBean)session.getAttribute("loginmember"))).getId();
		FriendBean myFBean=null;
		FriendBean otherFBean=null;
		MemberBean mb=null;
			myFBean=friendDAO.selectOne(memberId, friendId);
		if(myFBean==null){//代表兩人原本無關係
			myFBean=new FriendBean();
			otherFBean=new FriendBean();
			myFBean.setMemberId(memberId);
			myFBean.setFriendId(friendId);
			myFBean.setRelation(2);
			
			friendDAO.insert(myFBean);
			otherFBean.setMemberId(friendId);
			otherFBean.setFriendId(memberId);
			otherFBean.setRelation(3);
			friendDAO.insert(otherFBean);
			
			
			
		}else if(myFBean.getRelation()==3){
			myFBean.setRelation(1);
			otherFBean=friendDAO.selectOne(friendId, memberId);
			System.out.println(otherFBean);
			otherFBean.setRelation(1);
			friendDAO.update(myFBean);
			friendDAO.update(otherFBean);
			
			//更新memberBean
			mb=memberDAO.select(myFBean.getMemberId());
			mb.setFriendNum(friendDAO.selectPart(memberId, 1).size());
			memberDAO.update(mb);
			//////////////////////////////////////////////////////////////
		}
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/removeFriend", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public void removeFriend(HttpSession session,
			@RequestParam Integer friendId,
			Model model){
		MemberBean mb=null;
		Integer memberId=(((MemberBean)session.getAttribute("loginmember"))).getId();
		FriendBean myFBean=friendDAO.selectOne(memberId, friendId);
		FriendBean otherFBean=friendDAO.selectOne(friendId, memberId);
		if(myFBean.getRelation()==1){
			myFBean.setRelation(3);
			otherFBean.setRelation(2);
			friendDAO.update(myFBean);
			friendDAO.update(otherFBean);
			
			
		}else if(myFBean.getRelation()==2){
			friendDAO.delete(myFBean);
			friendDAO.delete(otherFBean);
		}
		//更新memberBean
		mb=memberDAO.select(myFBean.getMemberId());
		mb.setFriendNum(friendDAO.selectPart(memberId, 1).size());
		memberDAO.update(mb);
		//////////////////////////////////////////////////////////////
		
	}
	
}
