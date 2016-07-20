package com.kidscodetw.eeit.entity.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kidscodetw.eeit.dao.member.MemberDAO;

public class MemberDB {
	
	private static List<MemberBean> allMembers = new ArrayList<MemberBean>();
	private static List<MemberBean> allGirls = new ArrayList<MemberBean>();
	private static List<MemberBean> allBoys = new ArrayList<MemberBean>();
	

	@SuppressWarnings("resource")
	public MemberDB(){
		if(allMembers.isEmpty()){
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
			MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAO");
			allMembers = memberDAO.select();
			for(MemberBean bean :allMembers){
				if(bean.getGender()==0){
					allGirls.add(bean);
				}else if(bean.getGender()==1){
					allBoys.add(bean);
				}
			}
			
		}
	}
	
	public MemberBean checkAccountPassword(String account, String password){
		 for(MemberBean bean: allMembers){
			 if(bean.getAccount().equals(account) && bean.getPassword().equals(password)){
				 return bean;
			 }
		 }
		 return null;
	}
	
	public List<MemberBean> getAllMembers(){
		return allMembers;
	}
	
	public List<MemberBean> getAllGirls(){
		return allGirls;
	}
	
	public List<MemberBean> getAllBoys(){
		return allBoys;
	}
	
	public void addNewMember(MemberBean bean){
		allMembers.add(bean);
		if(bean.getGender()==0){
			allGirls.add(bean);
		}else if(bean.getGender()==1){
			allBoys.add(bean);
		}
	}

}
