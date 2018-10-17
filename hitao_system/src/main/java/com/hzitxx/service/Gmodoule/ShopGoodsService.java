package com.hzitxx.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopGoods;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
/**
 * 商品信息
 * @author Shinelon
 *
 */
public interface ShopGoodsService {
	/**
	 * 查询所有商品信息/分页显示/根据id回显商品信息
	 */
	ServerResponse<Json<List<ShopGoods>>> findAll(int page,int limit);
	/**
	 * 添加商品信息
	 */
	ServerResponse<Integer> addGoods(ShopGoods shopGoods);
	/**
	 * 根据id修改商品信息
	 */
	ServerResponse<Integer> updateGoods(ShopGoods shopGoods);
	/**
	 * 根据id删除商品信息，真正意义上的删除（从数据库中删除）
	 */
	ServerResponse<Integer> deleteGoods(Integer goodsId);
}
