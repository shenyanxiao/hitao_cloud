package com.hzitxx.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.entity.ShopMenu;
import com.hzitxx.service.ShopMenuService;
import com.hzitxx.utils.ServerResponse;

/**
 * 后台菜单表
 * @author Shinelon
 *
 */




@RestController
@RequestMapping("/shopMenu")
public class ShopMenuController {
	@Autowired
	private ShopMenuService service;
    /**
     * 向前台返回菜单列表数据
     */
	@GetMapping("/find")
	public ServerResponse find(int page,int limit,Map<String, Object> map) {
		return service.findAll(map, page, limit);
	}
	/**
	 * 向前台返回添加结果
	 */
	@PostMapping("/add")
	public ServerResponse add(ShopMenu shopMenu) {
		return service.addMenu(shopMenu);
	}
	/**
	 * 向前台返回编辑结果 
	 */
	@PostMapping("/update")
	public ServerResponse update(ShopMenu shopMenu) {
		return service.updateMenu(shopMenu);
	}
	/**
	 * 向前台返回删除结果
	 */
	@GetMapping("/delete")
	public ServerResponse delete(Integer id) {
		return service.deleteMenu(id);
	}
}
