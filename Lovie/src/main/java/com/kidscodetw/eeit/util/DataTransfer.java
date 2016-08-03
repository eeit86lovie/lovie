package com.kidscodetw.eeit.util;

import java.util.Calendar;
import java.util.Date;

import com.kidscodetw.eeit.entity.member.MemberBean;

public class DataTransfer {
//	public static int changeBirthdayToAge(MemberBean memberBean) {
//			int intValue = Integer.parseInt(memberBean.getBirthday().substring(
//					0, 4));
//			Date today = Calendar.getInstance().getTime();
//			return today.getYear() + 1900 - intValue;
//	}
	public static String genderTransfer(MemberBean memberBean){
		String gender=null;
		if(memberBean.getGender()==0)
			gender="女";
		else if(memberBean.getGender()==1)
			gender="男";
		return gender;
	}

	public static String changeBirthdayToConstellations(MemberBean memberBean) {
		String result = "";
		Integer month = Integer.parseInt(memberBean.getBirthday().substring(5,7));
		Integer day = Integer.parseInt(memberBean.getBirthday().substring(8,10));
		switch (month) {
		case 1:
			if (day >= 1 && day <= 20)
				result = "魔羯座";
			else if (day >= 21 && day <= 31)
				result = "水瓶座";
			break;
		case 2:
			if (day >= 1 && day <= 19)
				result = "水瓶座";
			else if (day >= 20 && day <= 29)
				result = "雙魚座";
			break;
		case 3:
			if (day >= 1 && day <= 20)
				result = "雙魚座";
			else if (day >= 21 && day <= 31)
				result = "牡羊座";
			break;
		case 4:
			if (day >= 1 && day <= 20)
				result = "牡羊座";
			else if (day >= 21 && day <= 30)
				result = "金牛座";
			break;
		case 5:
			if (day >= 1 && day <= 21)
				result = "金牛座";
			else if (day >= 22 && day <= 31)
				result = "雙子座";
			break;
		case 6:
			if (day >= 1 && day <= 21)
				result = "雙子座";
			else if (day >= 22 && day <= 30)
				result = "巨蟹座";
			break;
		case 7:
			if (day >= 1 && day <= 23)
				result = "巨蟹座";
			else if (day >= 24 && day <= 31)
				result = "獅子座";
			break;
		case 8:
			if (day >= 1 && day <= 23)
				result = "獅子座";
			else if (day >= 24 && day <= 31)
				result = "處女座";
			break;
		case 9:
			if (day >= 1 && day <= 23)
				result = "處女座";
			else if (day >= 24 && day <= 30)
				result = "天秤座";
			break;
		case 10:
			if (day >= 1 && day <= 23)
				result = "天秤座";
			else if (day >= 24 && day <= 31)
				result = "天蠍座";
			break;
		case 11:
			if (day >= 1 && day <= 22)
				result = "天蠍座";
			else if (day >= 23 && day <= 30)
				result = "射手座";
			break;
		case 12:
			if (day >= 1 && day <= 22)
				result = "射手座";
			else if (day >= 23 && day <= 31)
				result = "魔羯座";
			break;
		}

		return result;
	}
}
