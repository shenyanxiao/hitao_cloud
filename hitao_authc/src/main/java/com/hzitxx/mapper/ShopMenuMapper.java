package com.hzitxx.mapper;
/**
 * 后台菜单表
 * @author Shinelon
 *
 */

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopMenu;

public interface ShopMenuMapper {
	/**
	 * 查询所有菜单/根据id回显菜单信息
	 */
	List<ShopMenu> findAll(Map<String,Object> map);
	/**
	 * 添加菜单
	 */
	Integer addMenu(ShopMenu shopMenu);
	/**
	 * 根据id编辑菜单
	 */
	Integer updateMenu(ShopMenu shopMenu);
	/**
	 * 根据id删除菜单
	 */
	Integer deleteMenu(Integer id);
}
