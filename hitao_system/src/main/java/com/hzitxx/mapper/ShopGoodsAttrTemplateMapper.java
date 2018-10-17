package com.hzitxx.mapper;
/**
 * 商品属性模板表
 * @author Shinelon
 *
 */

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopGoodsAttrTemplate;

public interface ShopGoodsAttrTemplateMapper {
	/**
	 * 查询所有商品属性/根据类目id回显商品属性/分布显示
	 */
	List<ShopGoodsAttrTemplate> findAll();
	/**
	 * 添加商品属性
	 */
	Integer addAttrTemplate(ShopGoodsAttrTemplate shopGoodsAttrTemplate);
	/**
	 * 根据类目id修改商品属性
	 */
	Integer updateAttrTemplate(ShopGoodsAttrTemplate shopGoodsAttrTemplate);
	/**
	 * 根据类目id删除商品属性
	 */
	Integer deleteAttrTemplate(Integer catId);
}
