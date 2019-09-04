package com.bobo.senior1.week1.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bobo.senior1.week1.domain.Movie;
import com.bobo.senior1.week1.domain.Type;

public interface MovieMapper {
	/**
	 * 
	 * @Title: selects 
	 * @Description: TODO
	 * @param name
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selects(String name);
	/**
	 * 
	 * @Title: insert 
	 * @Description: TODO
	 * @param movie
	 * @return
	 * @return: int
	 */
	int insert(Movie movie);
	/**
	 * 
	 * @Title: deletePatch 
	 * @Description: 批量删
	 * @param ids
	 * @return
	 * @return: int
	 */
	int deletePatch(Integer[] ids);
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改
	 * @param movie
	 * @return
	 * @return: int
	 */
	int update(Movie movie);
	
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
	 * @Title: deleteMiddle 
	 * @Description: 删除中间表
	 * @param id
	 * @return
	 * @return: int
	 */
	int deleteMiddle(Integer id);
	
	/**
	 * 
	 * @Title: insertMiddle 
	 * @Description: 插入中间表
	 * @param mid
	 * @param tid
	 * @return
	 * @return: int
	 */
	int insertMiddle(@Param("mid")Integer mid,@Param("tid")Integer tid);
	
	
	/**
	 * 
	 * @Title: selectTypes 
	 * @Description: 电影分类
	 * @return
	 * @return: List<Type>
	 */
	List<Type> selectTypes();

}
