package com.hzitxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.entity.ShopGoodsCategory;
import com.hzitxx.service.ShopGoodsCategoryService;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

/**
 * 商品类目
 * @author Shinelon
 *
 */
//@Controller
@RestController  //替代@Controller和@ResponseBody
@RequestMapping("/goodsCategory")
public class ShopGoodsCategoryController {
	@Autowired
	private ShopGoodsCategoryService service;
	/**
	 * 向前台返回商品类目数据
	 */
	@GetMapping("/find")
	//@ResponseBody
	public ServerResponse<Json<List<ShopGoodsCategory>>> findGoodsCat(int page,int limit){
		return service.findAll(page,limit);
	}
	/**
	 * 向前台返回添加商品类目结果信息
	 */
	@PostMapping("/add")
	public ServerResponse<Integer> addGoodsCat(@RequestBody ShopGoodsCategory shopGoodsCategory){
		return service.addCategory(shopGoodsCategory);
	}
	/**
	 * 向前台返回修改商品类目结果信息
	 */
	@PostMapping("/update")
	public ServerResponse<Integer> updateGoodsCat(@RequestBody ShopGoodsCategory shopGoodsCategory){
		return service.updateCategory(shopGoodsCategory);
	}
	/**
	 * 向前台返回删除商品类目结果信息
	 */
	@GetMapping("/delete")
	public ServerResponse<Integer> deleteGoodsCat(Integer catId){
		return service.deleteCategory(catId);
	}
}
