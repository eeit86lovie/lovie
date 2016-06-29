package com.kidscodetw.eeit.dao;

import java.util.List;

import com.kidscodetw.eeit.entity.TheaterBean;

public interface TheaterDAO {

	List<String> select_theaternames();

	TheaterBean select(Integer ID);
	
	TheaterBean select(String name);

	List<TheaterBean> select();

	boolean delete(Integer id);

	TheaterBean insert(TheaterBean bean);

	TheaterBean update(TheaterBean bean);

}