package com.hzitxx.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.entity.ShopRole;
import com.hzitxx.service.ShopRoleService;
import com.hzitxx.utils.ServerResponse;

/**
 * 后台角色列表
 * @author Shinelon
 *
 */
@RestController
@RequestMapping("/shopRole")
public class ShopRoleController {
	@Autowired
	private ShopRoleService service;
    /**
     * 向前台返回角色数据
     */
	@GetMapping("/find")
	public ServerResponse find(int page,int limit,Map<String, Object> map) {
		return service.findAll(map, page, limit);
	}
	/**
	 * 向前台返回添加结果
	 */
	@PostMapping("/add")
	public ServerResponse add(@RequestBody ShopRole shopRole) {
		return service.addRole(shopRole);
	}
	/**
	 * 向前台返回编辑结果
	 */
	@PostMapping("update")
	public ServerResponse update(@RequestBody ShopRole shopRole) {
		return service.updateRole(shopRole);
	}
	/**
	 * 向前台返回删除结果
	 */
	@GetMapping("delete")
	public ServerResponse delete(@RequestBody List<Integer> list) {
		return service.deleteRole(list);
	}
}
