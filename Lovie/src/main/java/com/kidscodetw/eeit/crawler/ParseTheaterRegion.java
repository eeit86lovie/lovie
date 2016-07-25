package com.kidscodetw.eeit.crawler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kidscodetw.eeit.util.CommonUtil;

public class ParseTheaterRegion {
	

	public static void main(String[] args) {
		Connection conn = CommonUtil.connectMysql();
		new ParseTheaterRegion(conn);
	}
	
	public ParseTheaterRegion(Connection conn){
		
		String sqlString = "SELECT tAddress From Theater";
		try {
			PreparedStatement pstat = conn.prepareStatement(sqlString);
			ResultSet rs = pstat.executeQuery();
			Pattern p = Pattern.compile("(..市|..縣)(.+區|.+鎮|.+市|.+里|.+鄉)");
			PreparedStatement pstat2 = conn.prepareStatement("UPDATE Theater set tCity=?,tRegion=? where tAddress=?");
			
			while(rs.next()){
				System.out.println(rs.getString(1));
				try{
				Matcher m = p.matcher(rs.getString(1));
				m.find();
				pstat2.setString(1, m.group(1));
				pstat2.setString(2, m.group(2));				
				pstat2.setString(3, rs.getString(1));
				pstat2.addBatch();
				}catch(IllegalStateException e){
					e.printStackTrace();
				}
			}
			pstat2.executeBatch();
			
		} catch (SQLException e) {
		}
	}

}
