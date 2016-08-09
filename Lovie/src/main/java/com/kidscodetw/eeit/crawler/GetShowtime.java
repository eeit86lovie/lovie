package com.kidscodetw.eeit.crawler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.kidscodetw.eeit.util.CommonUtil;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class GetShowtime {

	public static void main(String[] args) {

		Connection conn = CommonUtil.connectMysql();
		GetShowtime gs = new GetShowtime(conn);
	}

	public GetShowtime() {
	}

	public GetShowtime(Connection conn) {
		Document doc = null;
		List allTheaterLink = getAllTheaterLink(conn);
		String url = "";
		ArrayList fullInfoShowtimes = new ArrayList();
		for (int i = 0; i < allTheaterLink.size(); i++) {
			try {
				url = allTheaterLink.get(i).toString();
				doc = Jsoup.connect(url).get();
				try {
				    TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
				}
				fullInfoShowtimes = getFullInfoShowtimes(doc);
				for (int j = 0; j < fullInfoShowtimes.size(); j++)
					setShowtimeToTable(conn, fullInfoShowtimes.get(j).toString().split(" "));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// return [http://www.atmovies.com.tw/showtime/t02a01/a02/] .....
	public List<String> getAllTheaterLink(Connection conn) {
		List<String> theaterLink = new ArrayList<String>();
		try {
			PreparedStatement pstat = conn.prepareStatement("SELECT link from Theater");
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				theaterLink.add("http://www.atmovies.com.tw/" + rs.getString(1) + "/");
			}
			int tSize = theaterLink.size();
			for (int i = 0; i < tSize; i++) {
				try {
					Document doc = Jsoup.connect(theaterLink.get(i)).get();
					try {
					    TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
					}
					Elements e = doc.getElementsContainingOwnText("選擇日期");
					Pattern p = Pattern.compile("a href=\"/(.*).\"");
					Matcher m = p.matcher(e.html());
					while (m.find()) {
						if (!theaterLink.contains("http://www.atmovies.com.tw/" + m.group(1) + "/")) {
							theaterLink.add("http://www.atmovies.com.tw/" + m.group(1) + "/");
							System.out.println("add " + m.group(1));
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("return");
		return theaterLink;
	}

	// [蝙蝠俠 台北威秀影城 03/12(四) 13:00],....
	public ArrayList<String> getFullInfoShowtimes(Document doc) {
		ArrayList<String> fullInfoShowtimes = new ArrayList<String>();
		List allShowtimeList = getOneTheaterAllShowtimes(doc);
		String[] mName = getMoiveName(doc);
		String tName = getTheaterName(doc);
		String showtimeDate = getDate(doc);
		int roomid = 1;
		for (int i = 0; i < allShowtimeList.size(); i++) {
			ArrayList temp = (ArrayList) allShowtimeList.get(i);
			for (int j = 0; j < temp.size(); j++) {
				fullInfoShowtimes.add(mName[i] + " " + tName + " " + showtimeDate + " " + temp.get(j));
			}

		}
		return fullInfoShowtimes;
	}

	// return [03:10,04:25],[18:50],...
	public List<ArrayList> getOneTheaterAllShowtimes(Document doc) {
		List<ArrayList> allShowtimeTime = new ArrayList<ArrayList>();
		ArrayList<String> showtimesTime = null;

		int i = 0;
		Pattern p = Pattern.compile("(\\d\\d：\\d\\d)", Pattern.DOTALL);
		while (i < 60) {
			Matcher m = p.matcher(getShowtimeElements(doc, i));
			showtimesTime = new ArrayList<String>();
			while (m.find()) {
				showtimesTime.add(m.group());
			}
			if (!showtimesTime.isEmpty()) {
				allShowtimeTime.add(showtimesTime);
			}
			i++;
		}
		return allShowtimeTime;
	}

	public static void setShowtimeToTable(Connection conn, String[] sqlList) {
		String sqlString = "INSERT INTO Showtime (MovieName, TheaterName, ShowtimeDate, ShowtimeTime) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sqlString);
			ps.setString(1, sqlList[0]);
			ps.setString(2, sqlList[1]);
			String date1 = sqlList[2].replace("/", "-");
			ps.setDate(3, java.sql.Date.valueOf(date1));
			ps.setString(4, sqlList[3]);
			ps.executeUpdate();
			System.out.println(sqlList[0]+" "+sqlList[1]+" "+sqlList[2]+" "+sqlList[3]);

		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getDate(Document doc) {
		return doc.select("h3").html().split(" ")[0]; // 2016/03/31
	}

	public String getTheaterName(Document doc) {
		return doc.select("h2").html();
	}

	public String[] getMoiveName(Document doc) {
		Elements mName_row = doc.select("li.filmTitle>a[href]");
		String[] mName = mName_row.text().split(" ");
		return mName;
	}

	public String getShowtimeElements(Document doc, int i) {
		Elements showtime_row = doc.select("div#theaterShowtimeBlock>ul#theaterShowtimeTable:eq(" + i + ")>li>ul>li");
		return showtime_row.html();
	}

}
