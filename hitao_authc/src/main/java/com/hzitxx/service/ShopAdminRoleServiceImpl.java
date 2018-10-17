package com.hzitxx.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopAdminRole;
import com.hzitxx.mapper.ShopAdminRoleMapper;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

@Service
public class ShopAdminRoleServiceImpl implements ShopAdminRoleService{
	@Autowired
	private ShopAdminRoleMapper mapper;
	/**
	 * 分页
	 */
	@Override
	public ServerResponse<PageUtil<List<ShopAdminRole>>> page(int page, int limit, Map<String, Object> map) {
		PageHelper.startPage(page,limit);
		List<ShopAdminRole> shop=mapper.findAR(map);
		System.out.println(shop);
		System.out.println(shop.getClass().getName());
		PageInfo<ShopAdminRole> pageInfo=new PageInfo<ShopAdminRole>(shop);
		PageUtil<List<ShopAdminRole>> pageUtils=new PageUtil<List<ShopAdminRole>>();
		pageUtils.setCode(0);
		pageUtils.setMsg("登录角色权限");
		pageUtils.setCount(pageInfo.getTotal());
		pageUtils.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(pageUtils);
	}
	/**
	 * 增加
	 */
	@Override
	public ServerResponse<Integer> add(ShopAdminRole shop) {
		int result=mapper.addAR(shop);
		if(result!=1) {
			return ServerResponse.createBySuccessMessage("增加失败");
		}
		return ServerResponse.createBySuccessMessage("增加成功");
	}
	/**
	 * 编辑
	 */
	@Override
	public ServerResponse<Integer> updade(ShopAdminRole shop) {
		int result=mapper.updateAR(shop);
		if(result!=1) {
			return ServerResponse.createBySuccessMessage("编辑失败");
		}
		return ServerResponse.createBySuccessMessage("编辑成功");
	}
	/**
	 * 删除
	 */
	@Override
	public ServerResponse<Integer> delete(Integer id) {
		int result=mapper.deleteAR(id);
		if(result!=1) {
			return  ServerResponse.createBySuccessMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}
	/**
	 * 根据id查询
	 */
	@Override
	public ServerResponse<ShopAdminRole> findOne(Integer id) {
		List<ShopAdminRole> shop=mapper.findOneAR(id);
		if(shop==null) {
			return ServerResponse.createBySuccessMessage("查询失败");
		}
		return ServerResponse.createBySuccessMessage("查询成功");
	}
	
}
