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
import java.util.List;

import com.kidscodetw.eeit.dao.MemberDAO;
import com.kidscodetw.eeit.entity.MemberBean;
import com.kidscodetw.eeit.util.CommonUtil;

public class MemberDAOJdbc implements MemberDAO {

	private final static String SELECT_ALL = "SELECT * FROM Member";
	private final static String SELECT_BY_ID = "SELECT * FROM Member WHERE id = ?";
	private final static String SELECT_BY_ACCOUNT = "SELECT * FROM Member WHERE account = ?";
	private final static String INSERT = "INSERT INTO Member (account, password, gender, email, nickname, city, district,"
			+ " phone, privilege,photoUrl, birthday, friendNum, commentPoint, intro, constellation, registeredTime, lastOnTime) values"
			+ " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?)";
	private final static String UPDATE = "UPDATE Member set password= COALESCE(?,password),"
			+ " gender= COALESCE(?,gender), email= COALESCE(?,email), nickname= COALESCE(?,nickname), city= COALESCE(?,city),"
			+ " district= COALESCE(?,district), privilege= COALESCE(?,privilege),photoUrl= COALESCE(?,photoUrl), birthday= COALESCE(?,birthday),"
			+ " friendNum= COALESCE(?,friendNum), commentPoint= COALESCE(?,commentPoint), intro= COALESCE(?,intro), constellation= COALESCE(?,constellation),"
			+ " lastOnTime= COALESCE(?,lastOnTime) WHERE id = ?";
			
	//update: 1.password 2.gender 3.email 4.nickname 5.city 6.district 7.privilege 8.birthday 9.friendNum 10.commentPoint 
	//        11.intro 12.constellation 13.lastOnTime 14.id
	
	private final static String DELETE_BY_ID = "DELETE FROM Member where id = ?";
	private final static String DELETE_BY_ACCOUNT = "DELETE FROM Member where account = ?";
	private static final String UPDATE_PHOTO = "UPDATE Member set photo = ? WHERE id = ?";
	
	/* (non-Javadoc)
	 * @see com.kidscodetw.eeit.member.model.dao.MemberDAO#updatePhoto(java.lang.String, int)
	 */
	@Override
	public void updatePhoto(String link, int id) {
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(UPDATE_PHOTO);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		FileInputStream fis = null;
		try {
			InputStream is = new java.net.URL(link).openStream();
			try {
				pstat.setBlob(1, is);
				pstat.setInt(2, id);
				int result = pstat.executeUpdate();
				System.out.println(result);
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
	

	/* (non-Javadoc)
	 * @see com.kidscodetw.eeit.member.model.dao.MemberDAO#select()
	 */
	@Override
	public List<MemberBean> select() {
		Connection conn = CommonUtil.connectMysql();
		MemberBean mb = null;
		List<MemberBean> list_mb = null;
		ResultSet rs = null;
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(SELECT_ALL);
			rs = pstat.executeQuery();
			list_mb = new ArrayList<MemberBean>();
			while (rs.next()) {
				mb = new MemberBean();
				mb.setId(rs.getInt(1));
				mb.setAccount(rs.getString(2));
				mb.setPassword(rs.getString(3));
				mb.setGender(rs.getInt(4));
				mb.setEmail(rs.getString(5));
				mb.setNickname(rs.getString(6));
				mb.setCity(rs.getString(7));
				mb.setDistrict(rs.getString(8));
				mb.setPhone(rs.getString(9));
				mb.setPrivilege(rs.getInt(10));
				mb.setPhotoUrl(rs.getString(11));
				mb.setBirthday(rs.getString(13));
				mb.setFriendNum(rs.getInt(14));
				mb.setCommentPoint(rs.getInt(15));
				mb.setIntro(rs.getString(16));
				mb.setConstellation(rs.getString(17));
				mb.setRegisteredTime(rs.getString(18));
				mb.setLastOnTime(rs.getString(19));
				list_mb.add(mb);
			}
			return list_mb;

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
		
		
		
		return list_mb;
	}
	

	/* (non-Javadoc)
	 * @see com.kidscodetw.eeit.member.model.dao.MemberDAO#select(java.lang.String)
	 */
	@Override
	public MemberBean select(String account) {
		Connection conn = CommonUtil.connectMysql();
		MemberBean mb = null;
		ResultSet rs = null;
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_ACCOUNT);
			pstat.setString(1, account);
			rs = pstat.executeQuery();
			while (rs.next()) {
				mb = new MemberBean();
				mb.setId(rs.getInt(1));
				mb.setAccount(rs.getString(2));
				mb.setPassword(rs.getString(3));
				mb.setGender(rs.getInt(4));
				mb.setEmail(rs.getString(5));
				mb.setNickname(rs.getString(6));
				mb.setCity(rs.getString(7));
				mb.setDistrict(rs.getString(8));
				mb.setPhone(rs.getString(9));
				mb.setPrivilege(rs.getInt(10));
				mb.setBirthday(rs.getString(12));
				mb.setFriendNum(rs.getInt(13));
				mb.setCommentPoint(rs.getInt(14));
				mb.setIntro(rs.getString(15));
				mb.setConstellation(rs.getString(16));
				mb.setRegisteredTime(rs.getString(17));
				mb.setLastOnTime(rs.getString(18));
			}
			return mb;

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
		return mb;
	}

	/* (non-Javadoc)
	 * @see com.kidscodetw.eeit.member.model.dao.MemberDAO#select(int)
	 */
	@Override
	public MemberBean select(int id) {
		Connection conn = CommonUtil.connectMysql();
		MemberBean mb = null;
		ResultSet rs = null;
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(SELECT_BY_ID);
			pstat.setInt(1, id);
			rs = pstat.executeQuery();
			while (rs.next()) {
				mb = new MemberBean();
				mb.setId(rs.getInt(1));
				mb.setAccount(rs.getString(2));
				mb.setPassword(rs.getString(3));
				mb.setGender(rs.getInt(4));
				mb.setEmail(rs.getString(5));
				mb.setNickname(rs.getString(6));
				mb.setCity(rs.getString(7));
				mb.setDistrict(rs.getString(8));
				mb.setPhone(rs.getString(9));
				mb.setPrivilege(rs.getInt(10));
				mb.setBirthday(rs.getString(12));
				mb.setFriendNum(rs.getInt(13));
				mb.setCommentPoint(rs.getInt(14));
				mb.setIntro(rs.getString(15));
				mb.setConstellation(rs.getString(16));
				mb.setRegisteredTime(rs.getString(17));
				mb.setLastOnTime(rs.getString(18));
			}
			return mb;

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
		return mb;
	}

	/* (non-Javadoc)
	 * @see com.kidscodetw.eeit.member.model.dao.MemberDAO#insert(com.kidscodetw.eeit.member.model.MemberBean)
	 */
	@Override
	public MemberBean insert(MemberBean mb) {
		Connection conn = CommonUtil.connectMysql();
		ResultSet rs = null;
		PreparedStatement pstat = null;
		PreparedStatement pstat2 = null;
		MemberBean mb2 = null;
		try {
			pstat = conn.prepareStatement(INSERT);
			pstat.setString(1, mb.getAccount());
			pstat.setString(2, mb.getPassword());
			pstat.setInt(3, mb.getGender());
			pstat.setString(4, mb.getEmail());
			pstat.setString(5, mb.getNickname());
			pstat.setString(6, mb.getCity());
			pstat.setString(7, mb.getDistrict());
			pstat.setString(8, mb.getPhone());
			pstat.setInt(9, mb.getPrivilege());
			pstat.setString(10, mb.getPhotoUrl());
			pstat.setString(11, mb.getBirthday());
			pstat.setInt(12, mb.getFriendNum());
			pstat.setInt(13, mb.getCommentPoint());
			pstat.setString(14, mb.getIntro());
			pstat.setString(15, mb.getConstellation());
			pstat.setString(16, mb.getLastOnTime());
			int result = pstat.executeUpdate();
			if(result ==1){
				pstat2 = conn.prepareStatement(SELECT_BY_ACCOUNT);
				pstat2.setString(1, mb.getAccount());
				rs = pstat2.executeQuery();
				while(rs.next()){
					mb2 = new MemberBean();
					mb2.setId(rs.getInt(1));
					mb2.setAccount(rs.getString(2));
					mb2.setPassword(rs.getString(3));
					mb2.setGender(rs.getInt(4));
					mb2.setEmail(rs.getString(5));
					mb2.setNickname(rs.getString(6));
					mb2.setCity(rs.getString(7));
					mb2.setDistrict(rs.getString(8));
					mb2.setPhone(rs.getString(9));
					mb2.setPrivilege(rs.getInt(10));
					mb2.setPhotoUrl(rs.getString(11));
					mb2.setBirthday(rs.getString(13));
					mb2.setFriendNum(rs.getInt(14));
					mb2.setCommentPoint(rs.getInt(15));
					mb2.setIntro(rs.getString(16));
					mb2.setConstellation(rs.getString(17));
					mb2.setRegisteredTime(rs.getString(18));
					mb2.setLastOnTime(rs.getString(19));
				}
				return mb2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if (pstat2 != null) {
				try {
					pstat2.close();
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
		return mb2;
	}

	/* (non-Javadoc)
	 * @see com.kidscodetw.eeit.member.model.dao.MemberDAO#delete(int)
	 */
	@Override
	public boolean delete(int id) {
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(DELETE_BY_ID);
			pstat.setInt(1, id);
			int result = pstat.executeUpdate();
			if(result==1){
				return true;
			}
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
		return false;
	}

	/* (non-Javadoc)
	 * @see com.kidscodetw.eeit.member.model.dao.MemberDAO#delete(java.lang.String)
	 */
	@Override
	public boolean delete(String account) {
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(DELETE_BY_ACCOUNT);
			pstat.setString(1, account);
			int result = pstat.executeUpdate();
			if(result==1){
				return true;
			}
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
		return false;
	}

	
//	public MemberBean update(String password, int gender, String email, String nickname, String city, String district, int privilege, String photoUrl, String birthday,
//			int friendNum, int commentPoint, String intro, String constellation, String lastOnTime, int id) {
//		Connection conn = CommonUtil.connectMysql();
//		PreparedStatement pstat = null;
//		PreparedStatement pstat2 = null;
//		ResultSet rs = null;
//		MemberBean mb = null;
//		try {
//			pstat = conn.prepareStatement(UPDATE);
//			pstat.setString(1,password);
//			pstat.setInt(2, gender);
//			pstat.setString(3, email);
//			pstat.setString(4, nickname);
//			pstat.setString(5, city);
//			pstat.setString(6, district);
//			pstat.setInt(7, privilege);
//			pstat.setString(8, photoUrl);
//			pstat.setString(9, birthday);
//			pstat.setInt(10, friendNum);
//			pstat.setInt(11, commentPoint);
//			pstat.setString(12, intro);
//			pstat.setString(13, constellation);
//			pstat.setString(14, lastOnTime);
//			pstat.setInt(15, id);
//			int result = pstat.executeUpdate();
//			if(result==1){
//				pstat2 = conn.prepareStatement(SELECT_BY_ID);
//				pstat2.setInt(1, id);
//				rs = pstat2.executeQuery();
//				while(rs.next()){
//					mb = new MemberBean();
//					mb.setId(rs.getInt(1));
//					mb.setAccount(rs.getString(2));
//					mb.setPassword(rs.getString(3));
//					mb.setGender(rs.getInt(4));
//					mb.setEmail(rs.getString(5));
//					mb.setNickname(rs.getString(6));
//					mb.setCity(rs.getString(7));
//					mb.setDistrict(rs.getString(8));
//					mb.setPhone(rs.getString(9));
//					mb.setPrivilege(rs.getInt(10));
//					mb.setPhotoUrl(rs.getString(11));
//					mb.setBirthday(rs.getString(13));
//					mb.setFriendNum(rs.getInt(14));
//					mb.setCommentPoint(rs.getInt(15));
//					mb.setIntro(rs.getString(16));
//					mb.setConstellation(rs.getString(17));
//					mb.setRegisteredTime(rs.getString(18));
//					mb.setLastOnTime(rs.getString(19));
//				}
//				return mb;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}if (pstat2 != null) {
//				try {
//					pstat2.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (pstat != null) {
//				try {
//					pstat.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return mb;
//	}


	@Override
	public MemberBean update(MemberBean bean) {
		Connection conn = CommonUtil.connectMysql();
		PreparedStatement pstat = null;
		PreparedStatement pstat2 = null;
		ResultSet rs = null;
		MemberBean mb = null;
		try {
			pstat = conn.prepareStatement(UPDATE);
			pstat.setString(1,bean.getPassword());
			pstat.setInt(2, bean.getGender());
			pstat.setString(3, bean.getEmail());
			pstat.setString(4, bean.getNickname());
			pstat.setString(5, bean.getCity());
			pstat.setString(6, bean.getDistrict());
			pstat.setInt(7, bean.getPrivilege());
			pstat.setString(8, bean.getPhotoUrl());
			pstat.setString(9, bean.getBirthday());
			pstat.setInt(10, bean.getFriendNum());
			pstat.setInt(11, bean.getCommentPoint());
			pstat.setString(12, bean.getIntro());
			pstat.setString(13, bean.getConstellation());
			pstat.setString(14, bean.getLastOnTime());
			pstat.setInt(15, bean.getId());
			int result = pstat.executeUpdate();
			if(result==1){
				pstat2 = conn.prepareStatement(SELECT_BY_ID);
				pstat2.setInt(1, bean.getId());
				rs = pstat2.executeQuery();
				while(rs.next()){
					mb = new MemberBean();
					mb.setId(rs.getInt(1));
					mb.setAccount(rs.getString(2));
					mb.setPassword(rs.getString(3));
					mb.setGender(rs.getInt(4));
					mb.setEmail(rs.getString(5));
					mb.setNickname(rs.getString(6));
					mb.setCity(rs.getString(7));
					mb.setDistrict(rs.getString(8));
					mb.setPhone(rs.getString(9));
					mb.setPrivilege(rs.getInt(10));
					mb.setPhotoUrl(rs.getString(11));
					mb.setBirthday(rs.getString(13));
					mb.setFriendNum(rs.getInt(14));
					mb.setCommentPoint(rs.getInt(15));
					mb.setIntro(rs.getString(16));
					mb.setConstellation(rs.getString(17));
					mb.setRegisteredTime(rs.getString(18));
					mb.setLastOnTime(rs.getString(19));
				}
				return mb;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if (pstat2 != null) {
				try {
					pstat2.close();
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
		return mb;
			
		
	}

}
