package com.hzitxx.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopAdminRole;

public interface ShopAdminRoleMapper {
	/**
	 * 查询信息
	 */
	List<ShopAdminRole> findAR(Map<String, Object> map);
	/**
	 * 增加
	 * @param shop
	 * @return
	 */
	Integer addAR(ShopAdminRole shop);
	/**
	 * 编辑
	 * @param shop
	 * @return
	 */
	Integer updateAR(ShopAdminRole shop);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Integer deleteAR(Integer id);
	/**
	 * 根据id查询
	 * @param shop
	 * @return
	 */
	List<ShopAdminRole> findOneAR(Integer id);
}
