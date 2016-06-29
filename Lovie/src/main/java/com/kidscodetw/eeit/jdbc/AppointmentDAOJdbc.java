package com.kidscodetw.eeit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kidscodetw.eeit.dao.AppointmentDAO;
import com.kidscodetw.eeit.entity.AppointmentBean;
import com.kidscodetw.eeit.util.CommonUtil;


public class AppointmentDAOJdbc implements AppointmentDAO {
	
	private static final String SELECT_ALL="SELECT * FROM Appointment";
	private static final String SELECT_BY_KEY = "SELECT * FROM Appointment where id = ?";
	private static final String SELECT_BY_SHOWTIMEID = "SELECT * FROM Appointment where showtimeId = ?";
	private static final String SELECT_BY_MEMBERID="SELECT * FROM Appointment where memberId = ?";
	private static final String INSERT ="INSERT INTO Appointment (memberId, showtimeId, pubTime, content, acceptedMemberId, acceptedTime, type, status) VALUES(?,?,now(),?,?,?,?,?) ";
	private static final String UPDATE="UPDATE Appointment set memberId = COALESCE(?,memberId), showtimeId = COALESCE(?,showtimeId), content= COALESCE(?,content),"
			+ " acceptedMemberId= COALESCE(?,acceptedMemberId), acceptedTime= COALESCE(?,acceptedTime), type= COALESCE(?,type), status= COALESCE(?,status) WHERE id = ? ";
	private static final String DELETE = "DELETE FROM Appointment where id =? ";
	
	public AppointmentBean select(Integer id){
		
		AppointmentBean result = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_KEY);
			pstat.setInt(1, id);
			rs = pstat.executeQuery();
			if(rs.next()){
				Timestamp timestamp = rs.getTimestamp(6);
				result = new AppointmentBean();
				result.setId(rs.getInt(1));
				result.setMemberId(rs.getInt(2));
				result.setShowtimeId(rs.getInt(3));
				result.setPubTime(new java.util.Date(rs.getDate(4).getTime()));
				result.setContent(rs.getString(5));
				result.setAcceptedMemberId(rs.getInt(6));
				if(timestamp!=null)
				result.setAcceptedTime(new java.util.Date(rs.getDate(7).getTime()));
				result.setType(rs.getInt(8));
				result.setStatus(rs.getInt(9));
			}
			return result;
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
		return result;
	}
	
	
	@Override
	public List<AppointmentBean> select(){
		List<AppointmentBean> listBean = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_ALL);
			rs = pstat.executeQuery();
			listBean = new ArrayList<AppointmentBean>();
			while(rs.next()){
				Timestamp timestamp = rs.getTimestamp(6);
				AppointmentBean bean = new AppointmentBean();
				bean.setId(rs.getInt(1));
				bean.setMemberId(rs.getInt(2));
				bean.setShowtimeId(rs.getInt(3));
				bean.setPubTime(new java.util.Date(rs.getDate(4).getTime()));
				bean.setContent(rs.getString(5));
				bean.setAcceptedMemberId(rs.getInt(6));
				if(timestamp!=null)
				bean.setAcceptedTime(new java.util.Date(rs.getDate(7).getTime()));
				bean.setType(rs.getInt(8));
				bean.setStatus(rs.getInt(9));
				listBean.add(bean);
			}
			return listBean;
			
			
		} catch (SQLException e) {
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
		return listBean;
	}
	

	@Override
	public List<AppointmentBean> selectByMemberId(Integer memberId){
		List<AppointmentBean> listBean = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_MEMBERID);
			pstat.setInt(1 , memberId);
			rs = pstat.executeQuery();
			listBean = new ArrayList<AppointmentBean>();
			while(rs.next()){
				Timestamp timestamp = rs.getTimestamp(6);
				AppointmentBean bean = new AppointmentBean();
				bean.setId(rs.getInt(1));
				bean.setMemberId(rs.getInt(2));
				bean.setShowtimeId(rs.getInt(3));
				bean.setPubTime(new java.util.Date(rs.getDate(4).getTime()));
				bean.setContent(rs.getString(5));
				bean.setAcceptedMemberId(rs.getInt(6));
				if(timestamp!=null)
				bean.setAcceptedTime(new java.util.Date(rs.getDate(7).getTime()));
				bean.setType(rs.getInt(8));
				bean.setStatus(rs.getInt(9));
				listBean.add(bean);
			}
			return listBean;
			
			
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
		return listBean;
	}
	
	@Override
	public List<AppointmentBean> selectByShowtimeId(Integer showtimeId){
		List<AppointmentBean> listBean = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_SHOWTIMEID);
			pstat.setInt(1 , showtimeId);
			rs = pstat.executeQuery();
			listBean = new ArrayList<AppointmentBean>();
			while(rs.next()){
				Timestamp timestamp = rs.getTimestamp(6);
				AppointmentBean bean = new AppointmentBean();
				bean.setId(rs.getInt(1));
				bean.setMemberId(rs.getInt(2));
				bean.setShowtimeId(rs.getInt(3));
				bean.setPubTime(new java.util.Date(rs.getDate(4).getTime()));
				bean.setContent(rs.getString(5));
				bean.setAcceptedMemberId(rs.getInt(6));
				if(timestamp!=null)
				bean.setAcceptedTime(new java.util.Date(rs.getDate(7).getTime()));
				bean.setType(rs.getInt(8));
				bean.setStatus(rs.getInt(9));
				listBean.add(bean);
			}
			return listBean;
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
		return listBean;
	}
	
	
	@Override
	public AppointmentBean insert(AppointmentBean bean) {
		int generatedId=0;
		AppointmentBean result = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			
			pstat.setInt(1, bean.getMemberId());
			pstat.setInt(2, bean.getShowtimeId());
			pstat.setString(3, bean.getContent());
			if(bean.getAcceptedMemberId()!=null){
				pstat.setInt(4, bean.getAcceptedMemberId());
			}else{
				pstat.setObject(4, null);
			}
			if(bean.getAcceptedTime()!=null){
				pstat.setDate(5, new java.sql.Date(bean.getAcceptedTime().getTime()));
			}else{
				pstat.setObject(5, null);
			}
			pstat.setInt(6, bean.getType());
			pstat.setInt(7, bean.getStatus());
			
			int insertResult = pstat.executeUpdate();
			if (insertResult == 1) {
				rs = pstat.getGeneratedKeys();
				rs.next();
				generatedId = rs.getInt(1);
				if(generatedId!=0){
					result = select(generatedId);
				}
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
	
	
	@Override
	public AppointmentBean update(AppointmentBean bean) {
		AppointmentBean result = null;
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(UPDATE);
			
			
			pstat.setInt(1, bean.getMemberId());
			pstat.setInt(2, bean.getShowtimeId());
			pstat.setString(3, bean.getContent());
			if(bean.getAcceptedMemberId()!=null){
				pstat.setInt(4, bean.getAcceptedMemberId());
			}else{
				pstat.setObject(4, null);
			}
			if(bean.getAcceptedTime()!=null){
				pstat.setDate(5, new java.sql.Date(bean.getAcceptedTime().getTime()));
			}else{
				pstat.setObject(5, null);
			}
			pstat.setInt(6, bean.getType());
			pstat.setInt(7, bean.getStatus());
			pstat.setInt(8, bean.getId());
			
			int insertResult = pstat.executeUpdate();
			if (insertResult == 1) {
				result = select(bean.getId());
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


	public boolean delete(Integer id){
		boolean result = false;
		Connection conn = CommonUtil.connectMysql();
		try {
			PreparedStatement pstat = conn.prepareStatement(DELETE);
			pstat.setInt(1, id);
			int deleteResult = pstat.executeUpdate();
			if(deleteResult == 1){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
