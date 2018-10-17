package com.hzitxx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopFrontCategory;
import com.hzitxx.mapper.ShopFrontCategoryMapper;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

@Service
public class ShopFrontCategoryServerImpl implements ShopFrontCategoryService {
	//注入ShopFrontCategoryMapper对象
	@Autowired
	private ShopFrontCategoryMapper mapper;
    /**
     * 查询所有类目信息
     */
	@Override
	public ServerResponse<Json<List<ShopFrontCategory>>> findAll(int page, int limit) {
		Map<String, Object> map=new HashMap<>();
		PageHelper.startPage(page,limit);   //分页插件
		List<ShopFrontCategory> list=mapper.findAll(map);
		PageInfo<ShopFrontCategory> pageInfo=new PageInfo<>(list);  //让pageinfo去解析list集合
		Json<List<ShopFrontCategory>> json=new Json<>();
		json.setCode(0);
		json.setCount(pageInfo.getTotal());
		json.setMsg("类目数据");
		json.setData(pageInfo.getList());
		return ServerResponse.createBySuccess("类目数据",json);
	}
    /**
     * 添加类目信息
     */
	@Override
	public ServerResponse<Integer> addFrontCat(ShopFrontCategory shopFrontCategory) {
		Integer result=mapper.addFrontCat(shopFrontCategory);
		if(result==1) {
			return  ServerResponse.createBySuccessMessage("添加成功");
		}
		else {
			return  ServerResponse.createByErrorCodeMessage(1, "添加失败");
		}
	}
	/**
	 * 根据后台类目编号修改类目信息
	 */
	@Override
	public ServerResponse<Integer> updateFrontCat(ShopFrontCategory shopFrontCategory) {
		Integer result=mapper.updateFrontCat(shopFrontCategory);
		if(result==1) {
			return  ServerResponse.createBySuccessMessage("修改成功");
		}
		else {
			return  ServerResponse.createByErrorCodeMessage(1, "修改失败");
		}
	}
	/**
	 * 根据后台类目编号删除类目信息
	 */
	@Override
	public ServerResponse<Integer> deleteFrontCat(Integer catId) {
		Integer result=mapper.deleteFrontCat(catId);
		if(result==1) {
			return  ServerResponse.createBySuccessMessage("删除成功");
		}
		else {
			return  ServerResponse.createByErrorCodeMessage(1, "删除失败");
		}
	}

}
