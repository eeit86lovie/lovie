package com.kidscodetw.eeit.crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.jdbc.MemberDAOJdbc;

public class MemberPhotoToDB {

	public static void main(String[] args) {
		new MemberPhotoToDB().getLink();

	}

	public void getLink() {
		MemberDAOJdbc memberDAO = new MemberDAOJdbc();
		MemberBean tempBean = null;
		Map<Integer, byte[]> photos = memberDAO.selectPhotos();
		
		
//		List<Integer> tempList = new ArrayList<Integer>();
//		Set<Integer> photosKeys = photos.keySet();
//		for(Integer key: photosKeys){
//			if(photos.get(key)!=null){
//				tempList.add(key);
//			}
//		}
//		for(Integer key2: tempList){
//			photos.remove(key2);
//		}
		

		
		Set<Integer> photo_null = photos.keySet();
		for(Integer i: photo_null){
			tempBean = memberDAO.select(i);
			System.out.println("select "+i+" : " +tempBean.getPhotoUrl());
			System.out.println(tempBean.getPhotoUrl());
			memberDAO.updatePhotos(tempBean.getPhotoUrl(), tempBean.getId());
		}
	}

}
