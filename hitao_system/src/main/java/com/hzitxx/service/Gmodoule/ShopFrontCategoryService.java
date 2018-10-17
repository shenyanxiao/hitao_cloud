package com.hzitxx.service;

import java.util.List;

import com.hzitxx.entity.ShopFrontCategory;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

/**
 * 类目信息
 * @author Shinelon
 *
 */
public interface ShopFrontCategoryService {
	/**
	 * 查询所有类目
	 */
	ServerResponse<Json<List<ShopFrontCategory>>> findAll(int page,int limit);
	/**
	 * 添加类目信息
	 */
	ServerResponse<Integer> addFrontCat(ShopFrontCategory shopFrontCategory);
	/**
	 * 根据后台类目编号修改类目信息
	 */
	ServerResponse<Integer> updateFrontCat(ShopFrontCategory shopFrontCategory);
	/**
	 * 根据后台类目编号删除类目信息
	 */
	ServerResponse<Integer> deleteFrontCat(Integer catId);
}
