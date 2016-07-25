package com.kidscodetw.eeit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kidscodetw.eeit.dao.movie.MovieGenreDAO;
import com.kidscodetw.eeit.entity.movie.MovieGenreBean;
import com.kidscodetw.eeit.util.CommonUtil;

public class MovieGenreDAOJdbc implements MovieGenreDAO {

	private final static String SELECT_BY_MOVIEId = "SELECT * FROM MovieGenre WHERE movieId = ?";
	private final static String SELECT_BY_GENREId = "SELECT * FROM MovieGenre WHERE genreId = ?";
	private final static String SELECT_ALL = "SELECT * FROM MovieGenre";
	private final static String INSERT = "INSERT INTO MovieGenre (movieId, genreId) values (?,?)";
	private final static String DELETE = "DELETE FROM MovieGenre WHERE movieId = ? and genreId=?";
	private final static String CONFIRM = "SELECT * FROM MovieGenre WHERE movieId =? and genreId=?";
	
	
	public List<MovieGenreBean> select() {
		List<MovieGenreBean> lmgb = new ArrayList<MovieGenreBean>();
		try (Connection conn = CommonUtil.connectMysql();
				PreparedStatement pstat = conn.prepareStatement(SELECT_ALL);) {
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				MovieGenreBean mgb = new MovieGenreBean();
				mgb.setMovieId(rs.getInt("movieId"));
				mgb.setGenreId(rs.getInt("GenreId"));
				lmgb.add(mgb);
			}
			return lmgb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lmgb;
	}
	
	

	public MovieGenreBean confirm(Integer movieId, Integer genreId) {
		MovieGenreBean mgb = null;
		try (Connection conn = CommonUtil.connectMysql(); PreparedStatement pstat = conn.prepareStatement(CONFIRM);) {
			pstat.setInt(1, movieId);
			pstat.setInt(2, genreId);
			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
				mgb = new MovieGenreBean();
				mgb.setMovieId(rs.getInt("movieId"));
				mgb.setGenreId(rs.getInt("GenreId"));
			}
			return mgb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mgb;
	}

	public List<MovieGenreBean> selectByMovieId(Integer movieId) {
		List<MovieGenreBean> lmgb = new ArrayList<MovieGenreBean>();
		try (Connection conn = CommonUtil.connectMysql();
				PreparedStatement pstat = conn.prepareStatement(SELECT_BY_MOVIEId);) {
			pstat.setInt(1, movieId);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				MovieGenreBean mgb = new MovieGenreBean();
				mgb.setMovieId(rs.getInt("movieId"));
				mgb.setGenreId(rs.getInt("GenreId"));
				lmgb.add(mgb);
			}
			return lmgb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lmgb;
	}

	public List<MovieGenreBean> selectByGenreId(Integer genreId) {
		List<MovieGenreBean> lmgb = new ArrayList<MovieGenreBean>();

		try (Connection conn = CommonUtil.connectMysql();
				PreparedStatement pstat = conn.prepareStatement(SELECT_BY_GENREId);) {
			pstat.setInt(1, genreId);
			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {
				MovieGenreBean mgb = new MovieGenreBean();
				mgb.setMovieId(rs.getInt("movieId"));
				mgb.setGenreId(rs.getInt("GenreId"));
				lmgb.add(mgb);
			}
			return lmgb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lmgb;
	}

	public MovieGenreBean insert(MovieGenreBean bean) {
		MovieGenreBean mgb = null;
		try (Connection conn = CommonUtil.connectMysql(); PreparedStatement pstat = conn.prepareStatement(INSERT);) {
			pstat.setInt(1, bean.getMovieId());
			pstat.setInt(2, bean.getGenreId());
			int result = pstat.executeUpdate();
			if (result == 1) {
				mgb = confirm(bean.getMovieId(), bean.getGenreId());
			}
			return mgb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mgb;
	}

	public boolean delete(MovieGenreBean bean) {
		try (Connection conn = CommonUtil.connectMysql(); PreparedStatement pstat = conn.prepareStatement(DELETE);) {
			pstat.setInt(1, bean.getMovieId());
			pstat.setInt(2, bean.getGenreId());
			int result = pstat.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
