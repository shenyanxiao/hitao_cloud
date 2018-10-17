package com.hzitxx.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopGoodsAttr;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

/**
 * 商品属性
 * @author Shinelon
 *
 */
public interface ShopGoodsAttrService {
	/**
	 *  查询所有商品属性/根据商品id回显商品属性
	 */
	ServerResponse<Json<List<ShopGoodsAttr>>> findAll(int page,int limit);
	/**
	 * 添加商品属性
	 */
	ServerResponse<Integer>  addAttr(ShopGoodsAttr shopGoodsAttr);
	/**
	 * 根据商品id修改商品属性
	 */
	ServerResponse<Integer>  updateAttr(ShopGoodsAttr shopGoodsAttr);
	/**
	 * 根据商品id删除商品属性
	 */
	ServerResponse<Integer>  deleteAttr(Integer goodsId);
}
