package com.hzitxx.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopRoleMenu;
import com.hzitxx.mapper.ShopRoleMenuMapper;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

@Service
public class ShopRoleMenuServiceImpl implements ShopRoleMenuService{
	@Autowired
	private ShopRoleMenuMapper mapper;
	@Override
	public ServerResponse<PageUtil<List<ShopRoleMenu>>> page(int page, int limit, Map<String, Object> map) {
		PageHelper.startPage(page,limit);
		List<ShopRoleMenu> shop=mapper.findRM(map);
		System.out.println(shop);
		System.out.println(shop.getClass().getName());
		PageInfo<ShopRoleMenu> pageInfo=new PageInfo<ShopRoleMenu>(shop);
		PageUtil<List<ShopRoleMenu>> pageUtils=new PageUtil<List<ShopRoleMenu>>();
		pageUtils.setCode(0);
		pageUtils.setMsg("角色权限");
		pageUtils.setCount(pageInfo.getTotal());
		pageUtils.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(pageUtils);	
	}

	@Override
	public ServerResponse<Integer> add(ShopRoleMenu shop) {
		
		return null;
	}

	@Override
	public ServerResponse<Integer> updade(ShopRoleMenu shop) {
	
		return null;
	}

	@Override
	public ServerResponse<Integer> delete(Integer id) {
		
		return null;
	}

	@Override
	public ServerResponse<ShopRoleMenu> findOne(Integer id) {
	
		return null;
	}

}
