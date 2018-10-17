package com.hzitxx.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopMenu;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

/**
 *  后台菜单表
 * @author Shinelon
 *
 */
public interface ShopMenuService {
	/**
	 * 查询所有菜单/根据id回显菜单信息
	 */
	ServerResponse<Json<List<ShopMenu>>> findAll(Map<String,Object> map,int page,int limit);
	/**
	 * 添加菜单
	 */
	ServerResponse<Integer> addMenu(ShopMenu shopMenu);
	/**
	 * 根据id编辑菜单
	 */
	ServerResponse<Integer> updateMenu(ShopMenu shopMenu);
	/**
	 * 根据id删除菜单
	 */
	ServerResponse<Integer> deleteMenu(Integer id);
}
