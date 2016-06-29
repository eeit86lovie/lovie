package com.kidscodetw.eeit.crawler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kidscodetw.eeit.util.CommonUtil;

public class TestMember {

	public static void main(String[] args) {
		Connection conn = CommonUtil.connectMysql();
		try {
			PreparedStatement pstat = conn.prepareStatement("insert into Member (pAccount)Values(?)");
			pstat.setString(1, "3434223");
			pstat.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
