package com.kidscodetw.eeit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.kidscodetw.eeit.dao.movie.ShowtimeDAO;
import com.kidscodetw.eeit.entity.movie.ShowtimeBean;
import com.kidscodetw.eeit.util.CommonUtil;

public class ShowtimeDAOJdbc implements ShowtimeDAO{
	
	private static final String SELECT_BY_ID = "SELECT * FROM Showtime WHERE id = ?";
	private static final String SELECT_BY_MOVIE = "SELECT * FROM Showtime WHERE movieName = ?";
	private static final String SELECT_BY_THEATER = "SELECT * FROM Showtime WHERE theaterName = ?";
	private static final String SELECT_BY_BOTH = "SELECT * FROM Showtime WHERE movieName = ? AND theaterName = ? order by showtimeDate";
	private static final String DELETE = "DELETE FROM Showtime WHERE showtimeDate < ?";
	private static final String INSERT = "INSERT INTO Showtime (movieName, theaterName, showtimeDate, showtimeTime, online) VALUES(?,?,?,?,?)";
	private static final String UPDATE = "UPDATE Showtime set movieName= COALESCE(?,movieName), theaterName= COALESCE(?,theaterName), showtimeDate= COALESCE(?,showtimeDate),"
			+ " showtimeTime= COALESCE(?,showtimeTime), online= COALESCE(?,online) WHERE id=? ";
	
	
	public ShowtimeBean select(Integer id){
		ShowtimeBean bean = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_ID);
			pstat.setInt(1, id);
			rs = pstat.executeQuery();
			bean = new ShowtimeBean();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setMovieName(rs.getString(2));
				bean.setTheaterName(rs.getString(3));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				bean.setShowtimeDate(sdf.format(new java.util.Date(rs.getDate(4).getTime())));
				bean.setShowtimeTime(rs.getString(5));
				bean.setOnline(rs.getInt(6));
			}
			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	
	public List<ShowtimeBean> selectBoth(String movieName, String theaterName) {
		List<ShowtimeBean> listbean = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_BOTH);
			pstat.setString(1, movieName);
			pstat.setString(2, theaterName);
			rs = pstat.executeQuery();
			listbean = new ArrayList<ShowtimeBean>();
			while (rs.next()) {
				ShowtimeBean bean = new ShowtimeBean();
				bean.setId(rs.getInt("id"));
				bean.setMovieName(rs.getString("movieName"));
				bean.setTheaterName(rs.getString("theaterName"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				bean.setShowtimeDate(sdf.format(new java.util.Date(rs.getDate(4).getTime())));
				bean.setShowtimeTime(rs.getString("showtimeTime"));
				bean.setOnline(rs.getInt("online"));
				listbean.add(bean);
			}
			return listbean;
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
		return listbean;
	}
	
	
	public List<ShowtimeBean> selectMovie(String movieName) {
		List<ShowtimeBean> listbean = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_MOVIE);
			pstat.setString(1, movieName);
			rs = pstat.executeQuery();
			listbean = new ArrayList<ShowtimeBean>();
			while (rs.next()) {
				ShowtimeBean bean = new ShowtimeBean();
				bean.setId(rs.getInt("id"));
				bean.setMovieName(rs.getString("movieName"));
				bean.setTheaterName(rs.getString("theaterName"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				bean.setShowtimeDate(sdf.format(new java.util.Date(rs.getDate(4).getTime())));
				bean.setShowtimeTime(rs.getString("showtimeTime"));
				bean.setOnline(rs.getInt("online"));
				listbean.add(bean);
			}
			return listbean;
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
		return listbean;
	}

	
	public List<ShowtimeBean> selectTheater(String theaterName) {
		List<ShowtimeBean> listbean = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_THEATER);
			pstat.setString(1,theaterName );
			rs = pstat.executeQuery();
			listbean = new ArrayList<ShowtimeBean>();
			while (rs.next()) {
				ShowtimeBean bean = new ShowtimeBean();
				bean.setId(rs.getInt("id"));
				bean.setMovieName(rs.getString("movieName"));
				bean.setTheaterName(rs.getString("theaterName"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				bean.setShowtimeDate(sdf.format(new java.util.Date(rs.getDate("ShowtimeDate").getTime())));
				bean.setShowtimeTime(rs.getString("showtimeTime"));
				listbean.add(bean);
			}
			return listbean;
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
		return listbean;
	}

	

	
	public Integer deleteDateBefore(String showtimeDate) {
		showtimeDate.replace("/", "-").trim();
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(DELETE);
			pstat.setString(1, showtimeDate);
			int result = pstat.executeUpdate();
			return result;
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
		return 0;
	}

	
	public ShowtimeBean insert(ShowtimeBean bean) {
		//showtimeDate.replace("/", "-").trim();
		ShowtimeBean result = null;
		Integer generatedId = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			pstat.setString(1, bean.getMovieName());
			pstat.setString(2, bean.getTheaterName());
			pstat.setString(3, bean.getShowtimeDate());
			pstat.setString(4, bean.getShowtimeTime());
			pstat.setInt(5, bean.getOnline());
			pstat.executeUpdate();
			ResultSet rs2 = pstat.getGeneratedKeys();
			if(rs2.next()){
				generatedId = rs2.getInt(1);
			}
			result = select(generatedId);
			return result;
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
		return result;
	}
	
	public ShowtimeBean update(ShowtimeBean bean) {
		//showtimeDate.replace("/", "-").trim();
		ShowtimeBean result = null;
		Integer generatedId = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(UPDATE);
			pstat.setString(1, bean.getMovieName());
			pstat.setString(2, bean.getTheaterName());
			pstat.setString(3, bean.getShowtimeDate());
			pstat.setString(4, bean.getShowtimeTime());
			pstat.setInt(5, bean.getOnline());
			pstat.setInt(6, bean.getId());
			pstat.executeUpdate();
			result = select(bean.getId());
			return result;
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
		return result;
	}

}
