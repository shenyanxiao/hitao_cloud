package com.hzitxx.service;

import java.util.List;

import com.hzitxx.entity.ShopGoodsAttrTemplate;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

/**
 * 商品属性模块表
 * @author Shinelon
 *
 */
public interface ShopGoodsAttrTemplateService {
	/**
	 * 查询所有商品属性/根据类目id回显商品属性/分布显示
	 */
	ServerResponse<Json<List<ShopGoodsAttrTemplate>>> findAll(int page,int limit);
	/**
	 * 添加商品属性
	 */
	ServerResponse<Integer> addAttrTemplate(ShopGoodsAttrTemplate shopGoodsAttrTemplate);
	/**
	 * 根据类目id修改商品属性
	 */
	ServerResponse<Integer> updateAttrTemplate(ShopGoodsAttrTemplate shopGoodsAttrTemplate);
	/**
	 * 根据类目id删除商品属性
	 */
	ServerResponse<Integer> deleteAttrTemplate(Integer catId);
}
