package com.hzitxx.mapper;
/**
 * 商品属性
 * @author Shinelon
 *
 */

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopGoodsAttr;

public interface ShopGoodsAttrMapper {
	/**
	 *  查询所有商品属性/根据商品id回显商品属性
	 */
	List<ShopGoodsAttr>  findAll(Map<String, Object> map);
	/**
	 * 添加商品属性
	 */
	Integer  addAttr(ShopGoodsAttr shopGoodsAttr);
	/**
	 * 根据商品id修改商品属性
	 */
	Integer  updateAttr(ShopGoodsAttr shopGoodsAttr);
	/**
	 * 根据商品id删除商品属性
	 */
	Integer  deleteAttr(Integer goodsId);
}
