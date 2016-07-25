package com.kidscodetw.eeit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kidscodetw.eeit.dao.movie.TheaterDAO;
import com.kidscodetw.eeit.entity.movie.TheaterBean;
import com.kidscodetw.eeit.util.CommonUtil;

public class TheaterDAOJdbc implements TheaterDAO {
	
	private static final String SELECT_BY_ID = "SELECT * FROM Theater WHERE id = ?";
	private static final String SELECT_BY_NAME = "SELECT * FROM Theater WHERE name = ?";
	private static final String SELECT_ALL = "SELECT * FROM Theater";
	private static final String DELETE_BY_ID = "DELETE FROM Theater WHERE id = ?";
	private static final String UPDATE = "UPDATE Theater set name= COALESCE(?,name), city=COALESCE(?,city), district=COALESCE(?,district), address=COALESCE(?,address), phone=COALESCE(?,phone), websiteUrl=COALESCE(?,websiteUrl) WHERE id=?";
	private static final String INSERT = "INSERT INTO Theater (name, city, district, address, phone, websiteUrl)"
			+ " values (?, ?, ?, ?, ?, ?)";

	private static final String SELECT_BY_THEATERNAMES = "SELECT name FROM Theater";
	
	public List<String> select_theaternames(){
		List<String> theaternames = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_THEATERNAMES);
			rs = pstat.executeQuery();
			theaternames = new ArrayList<String>();
			while (rs.next()) {
				theaternames.add(rs.getString(1));
			}
			return theaternames;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
	public TheaterBean select(Integer ID) {
		TheaterBean bean = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_ID);  //"SELECT * FROM Theater WHERE tID = ?"
			pstat.setInt(1, ID);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				bean = new TheaterBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setCity(rs.getString(3));
				bean.setDistrict(rs.getString(4));
				bean.setAddress(rs.getString(5));
				bean.setPhone(rs.getString(6));
				bean.setWebsiteUrl(rs.getString(7));
			}
			return bean;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bean;
	}
	
	public TheaterBean select(String name) {
		TheaterBean bean = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_NAME);
			pstat.setString(1, name);
			rs = pstat.executeQuery();
			if (rs.next()) {
				bean = new TheaterBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setCity(rs.getString(3));
				bean.setDistrict(rs.getString(4));
				bean.setAddress(rs.getString(5));
				bean.setPhone(rs.getString(6));
				bean.setWebsiteUrl(rs.getString(7));
			}
			return bean;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bean;
	}

	public List<TheaterBean> select() {
		List<TheaterBean> listBean;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_ALL); //"SELECT * FROM Theater"
			rs = pstat.executeQuery();
			listBean = new ArrayList<TheaterBean>();
			while (rs.next()) {
				TheaterBean bean = new TheaterBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setCity(rs.getString(3));
				bean.setDistrict(rs.getString(4));
				bean.setAddress(rs.getString(5));
				bean.setPhone(rs.getString(6));
				bean.setWebsiteUrl(rs.getString(7));
				listBean.add(bean);
			}
			return listBean;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	
	
	public boolean delete(Integer id) {
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(DELETE_BY_ID); //"DELETE FROM Theater WHERE tID = ?"
			pstat.setInt(1, id);
			int result = pstat.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	
	
	public TheaterBean insert(TheaterBean bean) {
		TheaterBean result = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		PreparedStatement pstat2 = null;
		ResultSet rs = null;
		int generatedId = 0;
		try {
			pstat = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			//"INSERT INTO Theater (tName, tCity, tRegion, tAddress, tPhone, tWebsite)"
			pstat.setString(1, bean.getName());
			pstat.setString(2, bean.getCity());
			pstat.setString(3, bean.getDistrict());
			pstat.setString(4, bean.getAddress());
			pstat.setString(5, bean.getPhone());
			pstat.setString(6, bean.getWebsiteUrl());
			int insertResult = pstat.executeUpdate();
			ResultSet rs2 = pstat.getGeneratedKeys();
			if(rs2.next()){
				generatedId = rs2.getInt(1);
			}
			if (insertResult == 1) {
				pstat2 = conn.prepareStatement(SELECT_BY_ID);
				pstat2.setInt(1, generatedId);
				rs = pstat2.executeQuery();
				result = new TheaterBean();
				if (rs.next()) {
					result.setId(rs.getInt("id"));
					result.setName(rs.getString("name"));
					result.setCity(rs.getString("city"));
					result.setDistrict(rs.getString("district"));
					result.setAddress(rs.getString("address"));
					result.setPhone(rs.getString("phone"));
					result.setWebsiteUrl(rs.getString("websiteUrl"));
				}
				return result;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstat2 != null) {
				try {
					pstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	
	
	public TheaterBean update(TheaterBean bean) {
		TheaterBean result = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		PreparedStatement pstat2 = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(UPDATE);  
			//UPDATE = "UPDATE Theater set tName=?, tCity=?, tRegion=?, tAddress=?, tPhone=?, tWebsite=? WHERE tID=?";
			pstat.setString(1, bean.getName());
			pstat.setString(2, bean.getCity());
			pstat.setString(3, bean.getDistrict());
			pstat.setString(4, bean.getAddress());
			pstat.setString(5, bean.getPhone());
			pstat.setString(6, bean.getWebsiteUrl());
			pstat.setInt(7, bean.getId());
			int updateResult = pstat.executeUpdate();
			if (updateResult == 1) {
				pstat2 = conn.prepareStatement(SELECT_BY_ID);
				pstat2.setInt(1, bean.getId());
				rs = pstat2.executeQuery();
				result = new TheaterBean();
				if (rs.next()) {
					result.setId(rs.getInt("id"));
					result.setName(rs.getString("name"));
					result.setCity(rs.getString("city"));
					result.setDistrict(rs.getString("district"));
					result.setAddress(rs.getString("address"));
					result.setPhone(rs.getString("phone"));
					result.setWebsiteUrl(rs.getString("websiteUrl"));
				}
				return result;
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstat2 != null) {
				try {
					pstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstat != null) {
				try {
					pstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
