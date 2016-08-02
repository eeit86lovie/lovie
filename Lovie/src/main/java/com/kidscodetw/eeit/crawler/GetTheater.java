package com.kidscodetw.eeit.crawler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.kidscodetw.eeit.util.CommonUtil;

public class GetTheater {
	public static void main(String[] args) {
		GetTheater a = new GetTheater();
		String[] theaters = { "a01", "a02", "a03", "a04", "a05", "a06", "a07", "a35", "a37", "a39", "a45", "a47", "a49",
				"a38", "a68", "a69", "a87", "a89" };
		for (String theater : theaters) {
			a.getTheater("mysql", "http://www.atmovies.com.tw/showtime/" + theater + "/");
		}
	}


	public void getTheater(String sqlType, String url) {
		Document doc;
		try {
			doc = Jsoup.connect(url).get();

			String a = doc.select("ul#theaterList>li").html();
			// System.out.println(a);

			Pattern p = Pattern.compile(
					"<a href=\"/(.*)/.*【(.*)】.*\\n.*\\n.*<li>(.*)</li>\\n.*<li>.*weblink=(.*)\".*target.*\\n.*<li>(.*)</li>");
			Matcher m = p.matcher(a);

			Connection conn = null;
			conn = CommonUtil.connectMysql();
			String sqlString = "INSERT INTO Theater (link,name,phone,websiteUrl,address) VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sqlString);
			while (m.find()) {
				ps.setString(1, m.group(1));
				ps.setString(2, m.group(2));
				ps.setString(3, m.group(3));
				ps.setString(4, m.group(4));
				ps.setString(5, m.group(5));
				ps.executeUpdate();
			}

		} catch (IllegalStateException e) {
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
