package com.hzitxx.controller;
/**
 * 类目
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 类目
 * @author Shinelon
 *
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzitxx.entity.ShopFrontCategory;
import com.hzitxx.service.ShopFrontCategoryService;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
@Controller
@RequestMapping("/frontCat")
public class ShopFrontCategoryController {
	@Autowired
	private ShopFrontCategoryService service;
	/**
	 * 向前台返回查询类目结果
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping("/find")
	@ResponseBody
	public ServerResponse<Json<List<ShopFrontCategory>>> findFrontCat(int page,int limit){
		return  service.findAll(page, limit);
	}
	/**
	 * 向前台返回添加类目结果信息
	 */
	@PostMapping("/add")
	@ResponseBody
	public ServerResponse<Integer> addFrontCat(@RequestBody ShopFrontCategory shopFrontCategory){
		return  service.addFrontCat(shopFrontCategory);
	}
	/**
	 * 向前台返回修改类目结果信息
	 */
	@PostMapping("/update")
	@ResponseBody
	public ServerResponse<Integer> updateFrontCat(@RequestBody ShopFrontCategory shopFrontCategory){
		return service.updateFrontCat(shopFrontCategory);
	}
	/** 
	 * 向前台返回删除类目结果信息
	 */
	@GetMapping("/delete")
	@ResponseBody
	public ServerResponse<Integer> deleteFrontCat(Integer catId){
		return  service.deleteFrontCat(catId);
	}
}
