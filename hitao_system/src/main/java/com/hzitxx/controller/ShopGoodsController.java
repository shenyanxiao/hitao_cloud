package com.hzitxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.entity.ShopGoods;
import com.hzitxx.service.ShopGoodsService;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;


/**
 * 商品信息
 * @author Shinelon
 *
 */
@RestController
@RequestMapping("/goods")
public class ShopGoodsController {
	@Autowired
	private  ShopGoodsService service;
	/**
	 * 向前台返回查询商品数据
	 */
	@GetMapping("/find")
	public ServerResponse<Json<List<ShopGoods>>> findGoods(int page,int limit){
		return service.findAll(page, limit);
	}
	/**
	 * 向前台返回添加商品结果
	 */
	@PostMapping("/add")
	public ServerResponse<Integer> addGoods(@RequestBody ShopGoods shopGoods){
		return service.addGoods(shopGoods);
	}
	/**
	 * 向前台返回修改商品结果
	 */
	@PostMapping("/update")
	public ServerResponse<Integer> updateGoods(@RequestBody ShopGoods shopGoods){
		return service.updateGoods(shopGoods);
	}
	/**
	 * 向前台返回删除商品结果
	 */
	@GetMapping("/delete")
	public ServerResponse<Integer> deleteGoods(Integer goodsId){
		return service.deleteGoods(goodsId);
	}
}
