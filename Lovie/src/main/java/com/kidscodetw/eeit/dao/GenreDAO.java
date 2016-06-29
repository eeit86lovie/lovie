package com.kidscodetw.eeit.dao;

import java.util.List;

import com.kidscodetw.eeit.entity.GenreBean;

public interface GenreDAO {

	List<GenreBean> select();

	GenreBean select(Integer id);

	GenreBean select(String name);

}