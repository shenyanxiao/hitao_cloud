package com.hzitxx.mapper;
/**
 * 平台后台角色
 * @author Shinelon
 *
 */

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopRole;

public interface ShopRoleMapper {
	/**
	 * 查询所有角色信息/根据角色id回显角色信息/根据角色名称实现搜索功能
	 */
	List<ShopRole> findAll(Map<String, Object> map);
	/**
	 * 增加角色信息
	 */
	Integer addRole(ShopRole shopRole);
	/**
	 * 根据角色id编辑角色信息
	 */
	Integer updateRole(ShopRole shopRole);
	/**
	 * 批量删除角色信息
	 */
	Integer deleteRole(List<Integer> list);
}
