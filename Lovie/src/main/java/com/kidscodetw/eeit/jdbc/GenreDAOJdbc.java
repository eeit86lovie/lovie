package com.kidscodetw.eeit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kidscodetw.eeit.dao.movie.GenreDAO;
import com.kidscodetw.eeit.entity.movie.GenreBean;
import com.kidscodetw.eeit.util.CommonUtil;

public class GenreDAOJdbc implements GenreDAO {
	private static final String SELECT_BY_ID = "SELECT * from Genre WHERE id = ?";
	private static final String SELECT_BY_NAME = "SELECT * from Genre WHERE name = ?";
	private static final String SELECT_ALL = "SELECT * from Genre";

	public List<GenreBean> select() {
		List<GenreBean> gb_list = null;

		try (Connection conn = CommonUtil.connectMysql();
				PreparedStatement pstat = conn.prepareStatement(SELECT_ALL);
				ResultSet rs = pstat.executeQuery();) {

			gb_list = new ArrayList<GenreBean>();
			while (rs.next()) {
				GenreBean gb = new GenreBean();
				gb.setId(rs.getInt("id"));
				gb.setName(rs.getString("name"));
				gb_list.add(gb);
			}
			return gb_list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gb_list;
	}

	public GenreBean select(Integer id) {
		GenreBean gb = null;

		try (Connection conn = CommonUtil.connectMysql();
				PreparedStatement pstat = conn.prepareStatement(SELECT_BY_ID);) {
			pstat.setInt(1, id);
			ResultSet rs = pstat.executeQuery();

			gb = new GenreBean();
			if (rs.next()) {
				gb.setId(rs.getInt("id"));
				gb.setName(rs.getString("name"));
			}
			return gb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gb;
	}
	
	public GenreBean select(String name) {
		GenreBean gb = null;

		try (Connection conn = CommonUtil.connectMysql();
				PreparedStatement pstat = conn.prepareStatement(SELECT_BY_NAME);) {
			pstat.setString(1, name);
			ResultSet rs = pstat.executeQuery();

			gb = new GenreBean();
			if (rs.next()) {
				gb.setId(rs.getInt("id"));
				gb.setName(rs.getString("name"));
			}
			return gb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gb;
	}

}
