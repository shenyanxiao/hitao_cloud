package com.hzitxx.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopMenu;
import com.hzitxx.entity.ShopRole;
import com.hzitxx.mapper.ShopRoleMapper;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
/**
 *  平台后台角色
 * @author Shinelon
 *
 */
@Service
public class ShopRoleServiceImpl implements ShopRoleService {
	@Autowired
	private ShopRoleMapper mapper;
	/**
	 * 查询所有角色信息/根据角色id回显角色信息/根据角色名称实现搜索功能
	 */
	@Override
	public ServerResponse<Json<List<ShopRole>>> findAll(Map<String, Object> map, int page, int limit) {
		PageHelper.startPage(page,limit); //分页
		List<ShopRole> list=mapper.findAll(map);
		PageInfo<ShopRole> pageInfo=new PageInfo<>(list); //解析list
		Json<List<ShopRole>> json=new Json<>();
		json.setCode(0);
		json.setCount(pageInfo.getTotal());
		json.setData(pageInfo.getList());
		json.setMsg("后台角色数据");
		return ServerResponse.createBySuccess("后台角色数据", json);
	}
	/**
	 * 增加角色信息
	 */
	@Override
	public ServerResponse<Integer> addRole(ShopRole shopRole) {
		shopRole.setCreatedTime(new Date());
		Integer result=mapper.addRole(shopRole);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("添加成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "添加失败");
		}
	}
	/**
	 * 根据角色id编辑角色信息
	 */
	@Override
	public ServerResponse<Integer> updateRole(ShopRole shopRole) {
		shopRole.setUpdatedTime(new Date());
		Integer result=mapper.updateRole(shopRole);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("编辑成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "编辑失败");
		}
	}
	/**
	 * 批量删除角色信息
	 */
	@Override
	public ServerResponse<Integer> deleteRole(List<Integer> list) {
		Integer result=mapper.deleteRole(list);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("删除成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "删除失败");
		}
	}

}
