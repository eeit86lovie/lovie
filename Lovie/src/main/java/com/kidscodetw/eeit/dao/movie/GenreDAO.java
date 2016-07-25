package com.kidscodetw.eeit.dao.movie;

import java.util.List;

import com.kidscodetw.eeit.entity.movie.GenreBean;

public interface GenreDAO {

	List<GenreBean> select();

	GenreBean select(Integer id);

	GenreBean select(String name);

}