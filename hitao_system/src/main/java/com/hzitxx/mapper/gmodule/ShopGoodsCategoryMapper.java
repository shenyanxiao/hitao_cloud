package com.hzitxx.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopGoodsCategory;

/**
 * 类目信息
 * @author Shinelon
 */
public interface ShopGoodsCategoryMapper {
	/**
	 * 查询所有的类目/根据id回显类目信息
	 */
	List<ShopGoodsCategory> findAll(Map<String, Object> map);
	/**
	 * 添加类目信息
	 */
	Integer addCategory(ShopGoodsCategory shopGoodsCategory);
	/**
	 * 修改类目信息
	 */
	Integer updateCategory(ShopGoodsCategory shopGoodsCategory);
	/**
	 * 删除类目信息
	 */
	Integer deleteCategory(Integer catId);
}
