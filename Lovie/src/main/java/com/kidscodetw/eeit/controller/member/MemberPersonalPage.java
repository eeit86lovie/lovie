package com.kidscodetw.eeit.controller.member;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.dao.member.FriendDAO;
import com.kidscodetw.eeit.dao.member.InterestedMoviesDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.dao.movie.GenreDAO;
import com.kidscodetw.eeit.entity.member.InterestedMoviesBean;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.entity.movie.MovieGenreBean;
import com.kidscodetw.eeit.util.DataTransfer;

@Controller
public class MemberPersonalPage {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private ForumDAO forumDAO;
	@Autowired
	private FriendDAO friendDAO;
	@Autowired
	private InterestedMoviesDAO interestedMoviesDAO;
	
	@Autowired
	private GenreDAO genreDAO;
	
	@RequestMapping(value="/member/profile/{id}", produces=MediaType.APPLICATION_JSON)
	public String getMemberById(@PathVariable("id")Integer memberId, Model model){
		MemberBean memberBean=memberDAO.select(memberId);
		
		List<InterestedMoviesBean> listMovieGenre = interestedMoviesDAO.selectByMemberId(memberId);//回傳喜歡的電影類型
		List<String> listGenre = new ArrayList<String>();
		for(InterestedMoviesBean interestedMoviesBean : listMovieGenre){
			String genreName = (genreDAO.select(interestedMoviesBean.getGenreId())).getName();
			listGenre.add(genreName);
		}
		model.addAttribute("genre_list", listGenre);
		model.addAttribute("memberPrivilege",DataTransfer.changeNumToPrivilege(memberBean));
		model.addAttribute("gender",DataTransfer.genderTransfer(memberBean));
		model.addAttribute("oneMember",memberBean);
		model.addAttribute("article",forumDAO.select_memberAccount(memberBean.getAccount()).size());

		return "member/memberPersonalPage.jsp";
	}
	
}
