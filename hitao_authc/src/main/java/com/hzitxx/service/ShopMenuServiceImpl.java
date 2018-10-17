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
import com.hzitxx.mapper.ShopMenuMapper;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
/**
 * 后台菜单表
 * @author Shinelon
 *
 */
@Service
public class ShopMenuServiceImpl implements ShopMenuService {
	@Autowired
	private ShopMenuMapper mapper;
	/**
	 * 查询所有菜单/根据id回显菜单信息
	 */
	@Override
	public ServerResponse<Json<List<ShopMenu>>> findAll(Map<String, Object> map, int page, int limit) {
		PageHelper.startPage(page,limit); //分页
		List<ShopMenu> list=mapper.findAll(map);
		PageInfo<ShopMenu> pageInfo=new PageInfo<>(list); //解析list
		Json<List<ShopMenu>> json=new Json<>();
		json.setCode(0);
		json.setCount(pageInfo.getTotal());
		json.setData(pageInfo.getList());
		json.setMsg("后台菜单数据");
		return ServerResponse.createBySuccess("后台菜单数据", json);
	}
	/**
	 * 添加菜单
	 */
	@Override
	public ServerResponse<Integer> addMenu(ShopMenu shopMenu) {
		shopMenu.setCreatedTime(new Date());
		Integer result=mapper.addMenu(shopMenu);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("添加成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "添加失败");
		}
	}
	/**
	 * 根据id编辑菜单
	 */
	@Override
	public ServerResponse<Integer> updateMenu(ShopMenu shopMenu) {
		shopMenu.setUpdatedTime(new Date());
		Integer result=mapper.updateMenu(shopMenu);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("编辑成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "编辑失败");
		}
	}
	/**
	 * 根据id删除菜单
	 */
	@Override
	public ServerResponse<Integer> deleteMenu(Integer id) {
		Integer result=mapper.deleteMenu(id);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("删除成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "删除失败");
		}
	}

}
