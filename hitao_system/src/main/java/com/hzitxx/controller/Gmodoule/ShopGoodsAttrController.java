package com.hzitxx.controller;
/**
 * 商品属性
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 商品属性
 * @author Shinelon
 *
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.entity.ShopGoodsAttr;
import com.hzitxx.service.ShopGoodsAttrService;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
//@Controller
@RestController
@RequestMapping("/goodsAttr")
public class ShopGoodsAttrController {
	@Autowired
	private ShopGoodsAttrService service;
	/**
	 * 向前台返回查询商品属性数据
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping("/find")
	//@ResponseBody
	public ServerResponse<Json<List<ShopGoodsAttr>>> findAttr(int page,int limit){
		return  service.findAll(page, limit);
	}
	/**
	 * 向前台返回添加商品属性结果信息
	 */
	@PostMapping("/add")
	public ServerResponse<Integer> addAttr(@RequestBody ShopGoodsAttr shopGoodsAttr){
		return service.addAttr(shopGoodsAttr);
	}
	/**
	 * 向前台返回修改商品属性结果信息
	 */
	@PostMapping("/update")
	public ServerResponse<Integer> updateAttr(@RequestBody ShopGoodsAttr shopGoodsAttr){
		return service.updateAttr(shopGoodsAttr);
	}
	/**
	 * 向前台返回删除商品属性结果信息
	 */
	@GetMapping("/delete")
	public ServerResponse<Integer> deleteAttr(Integer goodsId){
		return service.deleteAttr(goodsId);
	}
}
