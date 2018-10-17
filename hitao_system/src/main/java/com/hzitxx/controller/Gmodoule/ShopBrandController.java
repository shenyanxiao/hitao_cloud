package com.hzitxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzitxx.entity.ShopBrand;
import com.hzitxx.service.ShopBrandService;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
/**
 * 商品品牌
 * @author Shinelon
 *
 */
@Controller
@RequestMapping("/brand")
public class ShopBrandController {
	@Autowired
	private ShopBrandService shopBrandService;
	/**
	 * 向前台返回品牌数据,分页显示 
	 * @param page  页数
	 * @param limit  条数
	 * @return
	 */
	@GetMapping("/find")
	@ResponseBody
	public ServerResponse<Json<List<ShopBrand>>>  shopBrand(int page,int limit){
		return shopBrandService.findAll(page, limit);
	}
	/**
	 * 向前台返回添加品牌结果信息
	 */
	@PostMapping("/add")
	@ResponseBody
	public ServerResponse<Integer> addBrand(@RequestBody ShopBrand shopBrand){
		return  shopBrandService.addBrand(shopBrand);
	}
	/**
	 * 向前台返回修改品牌结果信息
	 */
	@PostMapping("/update")
	@ResponseBody
	public ServerResponse<Integer> updateBrand(@RequestBody ShopBrand shopBrand){
		return  shopBrandService.updateBrand(shopBrand);
	}
	/**
	 * 向前台返回删除品牌结果信息
	 */
	@GetMapping("/delete")
	@ResponseBody
	public ServerResponse<Integer> deleteBrand(Integer brandId){
		return shopBrandService.deleteBrand(brandId);
	}
}
