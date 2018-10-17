package com.hzitxx.mapper;
/**
 * 类目信息
 * @author Shinelon
 *
 */

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopFrontCategory;

public interface ShopFrontCategoryMapper {
	/**
	 * 查询所有类目/根据后台类目编号回显类目信息
	 */
	List<ShopFrontCategory> findAll(Map<String, Object> map);
	/**
	 * 添加类目信息
	 */
	Integer addFrontCat(ShopFrontCategory shopFrontCategory);
	/**
	 * 根据后台类目编号修改类目信息
	 */
	Integer updateFrontCat(ShopFrontCategory shopFrontCategory);
	/**
	 * 根据后台类目编号删除类目信息
	 */
	Integer deleteFrontCat(Integer catId);
}
