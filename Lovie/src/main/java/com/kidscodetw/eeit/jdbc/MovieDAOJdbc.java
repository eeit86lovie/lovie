package com.kidscodetw.eeit.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kidscodetw.eeit.dao.MovieDAO;
import com.kidscodetw.eeit.entity.MovieBean;
import com.kidscodetw.eeit.util.CommonUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MovieDAOJdbc implements MovieDAO{

	private static final String SELECT_BY_ID = "SELECT * FROM Movie WHERE id = ?";
	private static final String SELECT_BY_NAME = "SELECT * FROM Movie WHERE name = ?";
	private static final String SELECT_ALL = "SELECT * FROM Movie order by startTime desc";
	private static final String DELETE_BY_ID = "DELETE FROM Movie WHERE id = ?";
	private static final String UPDATE = "UPDATE Movie set name= COALESCE(?,name), rank= COALESCE(?,rank), startTime= COALESCE(?,startTime),"
			+ " intro= COALESCE(?,intro), photoUrl= COALESCE(?,photoUrl), trailer= COALESCE(?,trailer), filmLength= COALESCE(?,filmLength),online= COALESCE(?,online) WHERE id=? ";
	private static final String INSERT = "INSERT INTO Movie (name, rank, startTime, intro, photoUrl, trailer, filmLength)"
			+ " values (?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SELECT_BY_MOVIENAMES = "SELECT distinct Name FROM Movie";
	private static final String UPDATE_PHOTO = "UPDATE Movie set photo = ? WHERE id = ?";
	private static final String SELECT_PHOTO = "SELECT id, photo FROM Movie";
	
	
	
	public Map selectPhotos(){
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		Map<Integer, byte[]> photos = new HashMap<Integer, byte[]>();
		try{
			pstat = conn.prepareStatement(SELECT_PHOTO);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				photos.put((Integer)rs.getInt(1), rs.getBytes(2));
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			
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
		return photos;
	}
	
	
	@Override
	public void updatePhotos(String link, Integer id) {
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(UPDATE_PHOTO);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			InputStream is = new java.net.URL(link).openStream();
			try {
				pstat.setBlob(1, is);
				pstat.setInt(2, id);
				int result = pstat.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
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

	}
	
	public List<String> select_movienames() {
		List<String> movienames = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_MOVIENAMES);
			rs = pstat.executeQuery();
			movienames = new ArrayList<String>();
			while (rs.next()) {
				movienames.add(rs.getString(1));
			}
			return movienames;

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

	

	@Override
	public MovieBean select(Integer ID) {
		MovieBean bean = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_ID); // "SELECT * FROM Movie
															// WHERE mID = ?"
			pstat.setInt(1, ID);
			rs = pstat.executeQuery();
			bean = new MovieBean();
			while (rs.next()) {
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setRank(rs.getString(3));
				bean.setStartTime(rs.getString(4));
				bean.setFilmLength(rs.getString(5));
				bean.setIntro(rs.getString(6));
				bean.setPhotoUrl(rs.getString(7));
				bean.setTrailer(rs.getString(9));
				bean.setOnline(rs.getInt(10));
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
		return null;
	}

	@Override
	public MovieBean select(String Name) {
		MovieBean bean = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_NAME); // "SELECT * FROM
															// Movie WHERE mName
															// = ?"
			pstat.setString(1, Name);
			rs = pstat.executeQuery();
			if (rs.next()) {
				bean = new MovieBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setRank(rs.getString(3));
				bean.setStartTime(rs.getString(4));
				bean.setFilmLength(rs.getString(5));
				bean.setIntro(rs.getString(6));
				bean.setPhotoUrl(rs.getString(7));
				bean.setTrailer(rs.getString(9));
				bean.setOnline(rs.getInt(10));
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


	@Override
	public List<MovieBean> select() {
		List<MovieBean> listBean;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_ALL); // "SELECT * FROM Movie"
			rs = pstat.executeQuery();
			listBean = new ArrayList<MovieBean>();
			while (rs.next()) {
				MovieBean bean = new MovieBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setRank(rs.getString(3));
				bean.setStartTime(rs.getString(4));
				bean.setFilmLength(rs.getString(5));
				bean.setIntro(rs.getString(6));
				bean.setPhotoUrl(rs.getString(7));
				bean.setTrailer(rs.getString(9));
				bean.setOnline(rs.getInt(10));
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

	
	@Override
	public boolean delete(Integer ID) {
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(DELETE_BY_ID); // "DELETE FROM Movie
															// WHERE mID = ?"
			pstat.setInt(1, ID);
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


	@Override
	public MovieBean insert(MovieBean bean) {
		MovieBean result = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(INSERT);
			pstat.setString(1, bean.getName());
			pstat.setString(2, bean.getRank());
			pstat.setString(3, bean.getStartTime());
			pstat.setString(4, bean.getIntro());
			pstat.setString(5, bean.getPhotoUrl());
			pstat.setString(6, bean.getTrailer());
			pstat.setString(7, bean.getFilmLength());
			int insertResult = pstat.executeUpdate();
			if (insertResult == 1) {
				PreparedStatement pstat2 = conn.prepareStatement(SELECT_BY_NAME);
				pstat2.setString(1, bean.getName());
				rs = pstat2.executeQuery();
				result = new MovieBean();
				if (rs.next()) {
					result.setId(rs.getInt("id"));
					result.setName(rs.getString("name"));
					result.setRank(rs.getString("rank"));
					result.setStartTime(rs.getString("startTime"));
					result.setIntro(rs.getString("intro"));
					result.setPhotoUrl(rs.getString("photoUrl"));
					result.setTrailer(rs.getString("trailer"));
					result.setFilmLength(rs.getString("filmLength"));
					result.setOnline(rs.getInt("online"));
				}
				return result;
			}

		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println("Primary Key重複");
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
		return result;
	}


	@Override
	public MovieBean update(MovieBean bean) {
		MovieBean result = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(UPDATE);
			
			pstat.setString(1, bean.getName());
			pstat.setString(2, bean.getRank());
			pstat.setString(3, bean.getStartTime());
			pstat.setString(4, bean.getIntro());
			pstat.setString(5, bean.getPhotoUrl());
			pstat.setString(6, bean.getTrailer());
			pstat.setString(7, bean.getFilmLength());
			pstat.setInt(8, bean.getOnline());
			pstat.setInt(9, bean.getId());
			int updateResult = pstat.executeUpdate();
			if (updateResult == 1) {
				pstat = conn.prepareStatement(SELECT_BY_NAME);
				pstat.setString(1, bean.getName());
				rs = pstat.executeQuery();
				result = new MovieBean();
				if (rs.next()) {
					result.setId(bean.getId());
					result.setName(rs.getString("name"));
					result.setRank(rs.getString("rank"));
					result.setStartTime(rs.getString("startTime"));
					result.setIntro(rs.getString("intro"));
					result.setPhotoUrl(rs.getString("photoUrl"));
					result.setTrailer(rs.getString("trailer"));
					result.setFilmLength(rs.getString("filmLength"));
					result.setOnline(rs.getInt("online"));
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
