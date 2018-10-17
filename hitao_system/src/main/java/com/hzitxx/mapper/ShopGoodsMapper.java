package com.hzitxx.mapper;
import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopGoods;

/**
 * 商品信息  
 */
public interface ShopGoodsMapper {
	/**
	 * 查询所有商品信息/分页显示/根据id回显商品信息
	 */
	List<ShopGoods> findAll(Map<String, Object> map);
	/**
	 * 添加商品信息
	 */
	Integer addGoods(ShopGoods shopGoods);
	/**
	 * 根据id修改商品信息
	 */
	Integer updateGoods(ShopGoods shopGoods);
	/**
	 * 根据id删除商品信息，真正意义上的删除（从数据库中删除）
	 */
	Integer deleteGoods(Integer goodsId);
}
