package com.hzitxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.entity.ShopGoodsAttrTemplate;
import com.hzitxx.service.ShopGoodsAttrTemplateService;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

/**
 * 商品属性模块
 * @author Shinelon
 *
 */
@RestController
@RequestMapping("/goodsAttrTemplate")
public class ShopGoodsAttrTemplateController {
	@Autowired
	private ShopGoodsAttrTemplateService service;
    /**
     * 向前台返回查询商品属性数据
     */
	@GetMapping("/find")
	public ServerResponse<Json<List<ShopGoodsAttrTemplate>>> findAttrTemplate(int page,int limit){
		return service.findAll(page, limit);
	}
	/**
	 * 向前台返回添加结果
	 */
	@PostMapping("/add")
	public ServerResponse<Integer> addAttrTemplate(@RequestBody ShopGoodsAttrTemplate shopGoodsAttrTemplate){
		return service.addAttrTemplate(shopGoodsAttrTemplate);
	}
	/**
	 * 向前台返回修改结果
	 */
	@PostMapping("/update")
	public ServerResponse<Integer>  updateAttrTemplate (@RequestBody ShopGoodsAttrTemplate shopGoodsAttrTemplate){
		return service.updateAttrTemplate(shopGoodsAttrTemplate);
	}
	/**
	 * 向前台返回删除结果
	 */
	@GetMapping("/delete")
	public ServerResponse<Integer> deleteAttrTemplate(Integer catId){
		return service.deleteAttrTemplate(catId);
	}
}
