package com.kidscodetw.eeit.crawler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.kidscodetw.eeit.util.CommonUtil;

public class GetMember {

	String pAccount;
	String pEmail;
	String pPhoto;
	String pNickname;
	String pCity;
	String pRegion;
	String pPhone;
	int pPrivilege;
	int pGender;
	String pBirthday;
	String pStar;
	String pIntro;

	public static void main(String[] args) {
		GetMember td = new GetMember();
		Connection conn = CommonUtil.connectMysql();
		int memberNum = 2853140;
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(300);
				td = getMemberProfile(memberNum);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			if (td != null) {
				try {
					PreparedStatement pstat = conn
							.prepareStatement("INSERT INTO Member (pAccount, pPassword, pGender, pEmail,"
									+ "pNickname, pCity, pRegion, pPhone, pPhoto, pBirthday, pIntro, pStar) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

					pstat.setString(1, td.pAccount);
					pstat.setString(2, "123");
					pstat.setInt(3, td.pGender);
					pstat.setString(4, td.pEmail);
					pstat.setString(5, td.pNickname);
					pstat.setString(6, td.pCity);
					pstat.setString(7, td.pRegion);
					pstat.setString(8, td.pPhone);
					pstat.setString(9, td.pPhoto);
					pstat.setString(10, td.pBirthday);
					pstat.setString(11, td.pIntro);
					pstat.setString(12, td.pStar);
					pstat.executeUpdate();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			memberNum++;
		}

	}

	public static GetMember getMemberProfile(int memberNum) {
		GetMember td = null;
		String memberUrl = "http://www.i-part.com.tw/file/file_viewfile.php?u=" + memberNum;

		try {
			Document doc = Jsoup.connect(memberUrl).get();
			Elements elePic = doc.select("div>a.photobiger");
			String picUrl = elePic.attr("href");
			if (!picUrl.equals("http://img.ipimg.com/images/space.gif") && !picUrl.equals("")) {
				td = new GetMember();
				System.out.println("Account:" + memberNum);
				td.pAccount = memberNum + "";
				System.out.println(memberNum + "@yahoo.com.tw");
				td.pEmail = memberNum + "@yahoo.com.tw";
				System.out.println(picUrl);
				td.pPhoto = picUrl;
				Elements el = doc.select("table>tbody>tr>td>div>table>tbody>tr:eq(1)>td:eq(0)");
				String searchResult = el.text();
				Pattern p = Pattern.compile("暱　稱： (.*) 性　別： (.*)   年　齡： (.*) 歲 星　座： (.*) 身　高：.* > (.*) > (.*)   身高要求");
				Pattern p1 = Pattern.compile("暱　稱： (.*) 性　別：");
				Pattern p2 = Pattern.compile("性　別： (.*)   年　齡");
				Pattern p3 = Pattern.compile("年　齡： (.*) 歲 星　座");
				Pattern p4 = Pattern.compile("星　座： (.*) 身　高");
				Pattern p5 = Pattern.compile("> (.*) >");
				Pattern p6 = Pattern.compile("> (...|..)   身高要求");
				Matcher m1 = p1.matcher(searchResult);
				Matcher m2 = p2.matcher(searchResult);
				Matcher m3 = p3.matcher(searchResult);
				Matcher m4 = p4.matcher(searchResult);
				Matcher m5 = p5.matcher(searchResult);
				Matcher m6 = p6.matcher(searchResult);
				// System.out.println(searchResult);
				m1.find();
				m2.find();
				m3.find();
				m4.find();
				m5.find();
				m6.find();
				try {
					System.out.println(m1.group(1));
					td.pNickname = m1.group(1);
					System.out.println(m2.group(1));
					if (m2.group(1).equals("男生"))
						td.pGender = 1;
					else if (m2.group(1).equals("女生"))
						td.pGender = 0;
					System.out.println(m3.group(1));
					int age = Integer.valueOf(m3.group(1));
					td.pBirthday = (2016-age)+"-01-01";
					System.out.println(m4.group(1));
					td.pStar = m4.group(1);
					System.out.println(m5.group(1));
					td.pCity = m5.group(1);
					System.out.println(m6.group(1));
					td.pRegion = m6.group(1);
				} catch (java.lang.IllegalStateException e) {
				}

				Elements el2 = doc.select("div#MotherFrame>table>tbody>tr>td>div>div:eq(4)");
				System.out.println(el2.html());
				td.pIntro = el2.html();

				return td;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return td;
	}
}
