package com.bobo.senior1.week1.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bobo.senior1.week1.dao.MovieMapper;
import com.bobo.senior1.week1.domain.Movie;
import com.bobo.senior1.week1.domain.Type;
import com.bobo.senior1.week1.service.MovieService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MovieServiceImpl implements MovieService {
	@Resource
	private MovieMapper movieMapper;

	@Override
	public PageInfo<Map> selects(String name,Integer page,Integer pageSize) {
	
	PageHelper.startPage(page, pageSize);
	 List<Map> list = movieMapper.selects(name);

	 return  new PageInfo<Map>(list);
		
	}

	@Override
	public boolean insert(Movie movie, Integer[] tids) {

		try {
			// 1.插入电影表
			movieMapper.insert(movie);
			// 2.中间表
			for (Integer tid : tids) {
				movieMapper.insertMiddle(movie.getId(), tid);
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常,事务回滚
			throw new RuntimeException("增加失败" + e.getMessage());
		}
	}

	@Override
	public boolean deletePatch(Integer[] ids) {

		try {
			// 1删除电影表
			movieMapper.deletePatch(ids);
			// 2删除中间表
			for (Integer id : ids) {
				movieMapper.deleteMiddle(id);
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常,事务回滚
			throw new RuntimeException("增加失败" + e.getMessage());
		}

	}

	@Override
	public boolean update(Movie movie, Integer[] tids) {

		try {

			// 1.先删除中间表.
			movieMapper.deleteMiddle(movie.getId());
			// 2在增加电影
			movieMapper.insert(movie);
			// 3增加中间表
			
			for (Integer tid : tids) {
				movieMapper.insertMiddle(movie.getId(), tid);
			}
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常,事务回滚
			throw new RuntimeException("增加失败" + e.getMessage());
		}

	}

	@Override
	public Movie select(Integer id) {
		return movieMapper.select(id);
	}

	@Override
	public List<Type> selectTypes() {
		return movieMapper.selectTypes();
	}

}
