package com.bobo.senior1.week1.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bobo.senior1.week1.domain.Movie;
import com.bobo.senior1.week1.domain.Type;
import com.bobo.senior1.week1.service.MovieService;
import com.bobo.senior1.week1.util.PageUtil;
import com.github.pagehelper.PageInfo;

@Controller
public class MovieController {
	@Resource
	private MovieService movieService;
	
	 /**
	  * 
	  * @Title: add 
	  * @Description: TODO
	  * @param model
	  * @param id
	  * @return
	  * @return: String
	  */
		@GetMapping("update")
		public String update(Model model,Integer id) {
		 Movie movie = movieService.select(id);
		model.addAttribute("movie", movie);
		//把类型查询出来
		List<Type> types = movieService.selectTypes();
		model.addAttribute("types", types);
			return  "update";
		}
		/**
		 * 
		 * @Title: update 
		 * @Description: TODO
		 * @param model
		 * @param moive
		 * @param tids
		 * @return
		 * @return: boolean
		 */
		@ResponseBody
		@PostMapping("update")
		public boolean update(Model model,Movie  movie ,Integer [] tids) {
			return  movieService.update(movie, tids);
		}
	/**
	 * 去增加
	 * @Title: add 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@GetMapping("add")
	public String add(Model model) {
		List<Type> types = movieService.selectTypes();
		model.addAttribute("types", types);
		return  "add";
	}
	/**
	 * 
	 * @Title: add 
	 * @Description: 执行增加
	 * @param movie
	 * @return
	 * @return: 
	 */
	@ResponseBody
	@PostMapping("add")
	public boolean add(Movie movie,Integer[] tids ) {
		
	  return movieService.insert(movie, tids);
		
	}
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 列表
	 * @param request
	 * @param name
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("selects")
	public String selects(HttpServletRequest request,String name ,@RequestParam(defaultValue = "1")Integer page ,@RequestParam(defaultValue ="3")Integer pageSize) {
		
		
		PageInfo<Map> info = movieService.selects(name, page, pageSize);
		//分页工具类.封装了.上下页信息
		PageUtil.page(request, "/selects", pageSize, info.getList(), info.getTotal(), page);
		
		//封装查询条件
		request.setAttribute("name", name);
		//封装的查询集合
		request.setAttribute("movies",info.getList());
		
		return "movies";
	}

}
