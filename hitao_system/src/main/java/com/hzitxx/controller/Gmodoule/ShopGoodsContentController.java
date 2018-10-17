package com.hzitxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.entity.ShopGoodsContent;
import com.hzitxx.service.ShopGoodsContentService;
import com.hzitxx.utils.Json;


/**
 * 商品内容
 * @author Shinelon
 *
 */
import com.hzitxx.utils.ServerResponse;
@RestController
@RequestMapping("/goodsContent")
public class ShopGoodsContentController {
	@Autowired
	private ShopGoodsContentService service;
	/**
	 * 向前台返回查询商品内容数据
	 */
	@GetMapping("/find")
	public ServerResponse<Json<List<ShopGoodsContent>>> findContent(int page,int limit){
		return service.findAll(page, limit);
	}
	/**
	 * 向前台返回添加商品内容结果
	 */
	@PostMapping("/add")
	public ServerResponse<Integer> addContent(@RequestBody ShopGoodsContent shopGoodsContent){
		return service.addContent(shopGoodsContent);
	}
	/**
	 * 向前台返回修改商品内容结果
	 */
	@PostMapping("/update")
	public ServerResponse<Integer> updateContent(@RequestBody ShopGoodsContent shopGoodsContent){
		return service.updateContent(shopGoodsContent);
	}
	/**
	 * 向前台返回删除商品内容结果
	 */
	@GetMapping("/delete")
	public ServerResponse<Integer> deleteContent(@RequestBody Integer goodsId){
		return service.deleteContent(goodsId);
	}
}
