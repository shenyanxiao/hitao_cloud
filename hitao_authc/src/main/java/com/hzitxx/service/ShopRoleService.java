package com.hzitxx.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopRole;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

/**
 * 平台后台角色
 * @author Shinelon
 *
 */
public interface ShopRoleService {
	/**
	 * 查询所有角色信息/根据角色id回显角色信息/根据角色名称实现搜索功能
	 */
	ServerResponse<Json<List<ShopRole>>> findAll(Map<String, Object> map,int page,int limit);
	/**
	 * 增加角色信息
	 */
	ServerResponse<Integer> addRole(ShopRole shopRole);
	/**
	 * 根据角色id编辑角色信息
	 */
	ServerResponse<Integer> updateRole(ShopRole shopRole);
	/**
	 * 批量删除角色信息
	 */
	ServerResponse<Integer> deleteRole(List<Integer> list);
}
