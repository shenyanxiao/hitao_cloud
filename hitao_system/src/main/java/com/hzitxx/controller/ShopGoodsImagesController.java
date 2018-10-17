package com.hzitxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.entity.ShopGoodsImages;
import com.hzitxx.service.ShopGoodsImagesService;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

/**
 * 商品图片
 * @author Shinelon
 *
 */
@RestController
@RequestMapping("/goodsImages")
public class ShopGoodsImagesController {
	@Autowired
	private ShopGoodsImagesService service;
	/**
	 * 向前台返回查询商品图片数据
	 */
	@GetMapping("/find")
	public ServerResponse<Json<List<ShopGoodsImages>>> findImages(int page,int limit){
		return service.findAll(page, limit);
	}
	/**
	 * 向前台返回添加商品图片结果
	 */
	@PostMapping("/add")
	public ServerResponse<Integer> addImages(@RequestBody ShopGoodsImages shopGoodsImages ){
		return service.addImages(shopGoodsImages);
	}
	/**
	 * 向前台返回修改商品图片结果
	 */
	@PostMapping("/update")
	public ServerResponse<Integer> updateImages(@RequestBody ShopGoodsImages shopGoodsImages ){
		return service.updateImages(shopGoodsImages);
	}
	/**
	 * 向前台返回删除商品图片结果
	 */
	@GetMapping("/delete")
	public ServerResponse<Integer>  deleteImages(Integer goodsId){
		return service.deleteImages(goodsId);
	}
}
