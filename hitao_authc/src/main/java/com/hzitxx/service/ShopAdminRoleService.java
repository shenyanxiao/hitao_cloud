package com.hzitxx.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopAdminRole;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

public interface ShopAdminRoleService {
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	ServerResponse<PageUtil<List<ShopAdminRole>>> page(int page,int limit,Map<String, Object> map);
	/**
	 * 增加
	 * @param shop
	 * @return
	 */
	ServerResponse<Integer> add(ShopAdminRole shop);
	/**
	 * 编辑
	 * @param shop
	 * @return
	 */
	ServerResponse<Integer> updade(ShopAdminRole shop);
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
	ServerResponse<ShopAdminRole> findOne(Integer id);
	}
