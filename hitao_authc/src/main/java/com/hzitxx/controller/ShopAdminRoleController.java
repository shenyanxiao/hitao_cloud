package com.hzitxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.entity.ShopAdminRole;
import com.hzitxx.service.ShopAdminRoleService;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

@RestController
@RequestMapping("/shopAR")
public class ShopAdminRoleController {
	@Autowired
	private ShopAdminRoleService service;
	/**
	 * 分页
	 * @param page
	 * @param limit
	 * @param value
	 * @return
	 */
	@GetMapping(value="page")
	public ServerResponse<PageUtil<List<ShopAdminRole>>> page(@RequestParam(value="page",defaultValue="1")int page,
			@RequestParam(value="limit",defaultValue="20")int limit,String value){
		Map<String, Object> map=new HashMap<String, Object>();
		return service.page(page, limit,map);
	}
	/**
	 * 增加
	 * @param shop
	 * @return
	 */
	@GetMapping(value="add")
	public ServerResponse<Integer> add(@RequestBody ShopAdminRole shop){
		return service.add(shop);
	}
	/**
	 * 编辑
	 * @param shop
	 * @return
	 */
	@GetMapping(value="update")
	public ServerResponse<Integer> update(@RequestBody ShopAdminRole shop){
		return service.updade(shop);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@GetMapping(value="delete")
	public ServerResponse<Integer> delete(@RequestBody Integer id){
		return service.delete(id);
	}
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@GetMapping(value="findOne")
	public ServerResponse<ShopAdminRole> findOne(@RequestBody Integer id){
		return service.findOne(id);
	}
}
