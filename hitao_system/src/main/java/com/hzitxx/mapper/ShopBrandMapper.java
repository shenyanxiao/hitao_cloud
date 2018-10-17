package com.hzitxx.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopBrand;
/**
 * 品牌信息
 */
public interface ShopBrandMapper {
	/**
	 * 查询所有品牌/根据id回显品牌信息
	 */
	List<ShopBrand> findAll(Map<String, Object> map);
	/**
	 * 添加品牌信息
	 */
	Integer addBrand(ShopBrand shopBrand);
	/**
	 * 根据id修改品牌信息
	 */
	Integer updateBrand(ShopBrand shopBrand);
	/**
	 * 根据id真正意义上的删除品牌信息(从数据库中删除)
	 */
	Integer deleteBrand(Integer brandId);
}
