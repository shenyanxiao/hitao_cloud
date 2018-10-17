package com.hzitxx.service;
/**
 * 商品品牌信息
 * @author Shinelon
 */

import java.util.List;

import org.springframework.stereotype.Service;

import com.hzitxx.entity.ShopBrand;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

/**
 * 商品品牌
 * @author Shinelon
 *
 */
public interface ShopBrandService {
	/**
	 * 查询所有品牌/根据id回显品牌信息/实现分页
	 */
	ServerResponse<Json<List<ShopBrand>>>  findAll(int page,int limit);
	/**
	 * 添加品牌信息
	 */
	ServerResponse<Integer> addBrand(ShopBrand shopBrand);
	/**
	 * 根据id修改品牌信息
	 */
	ServerResponse<Integer> updateBrand(ShopBrand shopBrand);
	/**
	 * 根据id删除品牌信息
	 */
	ServerResponse<Integer> deleteBrand(Integer brandId);
}
