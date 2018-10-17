package com.hzitxx.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopGoodsCategory;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

/**
 * 商品类目
 * @author Shinelon
 *
 */
public interface ShopGoodsCategoryService {
	/**
	 * 查询所有的类目/根据id回显类目信息/分页显示 
	 */
	ServerResponse<Json<List<ShopGoodsCategory>>> findAll(int page,int limit);
	/**
	 * 添加类目信息
	 */
	ServerResponse<Integer> addCategory(ShopGoodsCategory shopGoodsCategory);
	/**
	 * 修改类目信息
	 */
	ServerResponse<Integer> updateCategory(ShopGoodsCategory shopGoodsCategory);
	/**
	 * 删除类目信息
	 */
	ServerResponse<Integer> deleteCategory(Integer catId);
}
