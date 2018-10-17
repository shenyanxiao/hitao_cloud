package com.hzitxx.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopRoleMenu;

public interface ShopRoleMenuMapper {
	/**
	 * 增加
	 * @param map
	 * @return
	 */
	List<ShopRoleMenu> findRM(Map<String, Object> map);
	/**
	 * 增加
	 * @param shop
	 * @return
	 */
	Integer addRM(ShopRoleMenu shop);
	/**
	 * 编辑
	 * @param shop
	 * @return
	 */
	Integer updateRM(ShopRoleMenu shop);
	/**
	 * 删除
	 * @param shop
	 * @return
	 */
	Integer deleteRM(Integer id);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	List<ShopRoleMenu> findOneRM(Integer id);
}
