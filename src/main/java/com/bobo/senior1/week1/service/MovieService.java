package com.bobo.senior1.week1.service;

import java.util.List;
import java.util.Map;

import com.bobo.senior1.week1.domain.Movie;
import com.bobo.senior1.week1.domain.Type;
import com.github.pagehelper.PageInfo;

public interface MovieService {
	/**
	 * 
	 * @Title: selects 
	 * @Description: TODO
	 * @param name
	 * @return
	 * @return: List<Map>
	 */
	PageInfo<Map> selects(String name,Integer page,Integer pageSize);
	/**
	 * 
	 * @Title: insert 
	 * @Description: TODO
	 * @param movie
	 * @return
	 * @return: int
	 */
	boolean  insert(Movie movie,Integer[] tids);
	/**
	 * 
	 * @Title: deletePatch 
	 * @Description: 批量删
	 * @param ids
	 * @return
	 * @return: boolean
	 */
	boolean deletePatch(Integer[] ids);
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改
	 * @param movie
	 * @return
	 * @return: int
	 */
	boolean update(Movie movie,Integer[] tids);
	
	/**
	 * 
	 * @Title: select 
	 * @Description: 单个查询
	 * @param id
	 * @return
	 * @return: Movie
	 */
	Movie select(Integer id);
	
	
	
	
	/**
	 * 
	 * @Title: selectTypes 
	 * @Description: 电影分类
	 * @return
	 * @return: List<Type>
	 */
	List<Type> selectTypes();

}
