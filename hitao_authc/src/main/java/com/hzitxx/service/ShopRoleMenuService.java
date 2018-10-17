package com.hzitxx.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopRoleMenu;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

public interface ShopRoleMenuService {
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	ServerResponse<PageUtil<List<ShopRoleMenu>>> page(int page,int limit,Map<String, Object> map);
	/**
	 * 增加
	 * @param shop
	 * @return
	 */
	ServerResponse<Integer> add(ShopRoleMenu shop);
	/**
	 * 编辑
	 * @param shop
	 * @return
	 */
	ServerResponse<Integer> updade(ShopRoleMenu shop);
	/**
	 * 删除
	 * @param shop
	 * @return
	 */
	ServerResponse<Integer> delete(Integer id);
	/**
	 * 根据id查询
	 * @param shop
	 * @return
	 */
	ServerResponse<ShopRoleMenu> findOne(Integer id);
}


