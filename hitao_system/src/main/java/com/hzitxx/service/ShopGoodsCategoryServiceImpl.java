package com.hzitxx.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopGoodsCategory;
import com.hzitxx.mapper.ShopGoodsCategoryMapper;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

@Service
public class ShopGoodsCategoryServiceImpl implements ShopGoodsCategoryService {
    @Autowired
    private ShopGoodsCategoryMapper mapper;
    /**
	 * 查询所有的类目/根据id回显类目信息/分页显示 
	 */
	@Override
	public ServerResponse<Json<List<ShopGoodsCategory>>> findAll(int page, int limit) {
		Map<String, Object> map=new HashMap<>();
		PageHelper.startPage(page,limit);
		List<ShopGoodsCategory> list=mapper.findAll(map);
		PageInfo<ShopGoodsCategory> pageInfo=new PageInfo<>(list);
		Json<List<ShopGoodsCategory>> json=new Json<>();
		json.setCode(0);
		json.setCount(pageInfo.getTotal());
		json.setData(pageInfo.getList());
		json.setMsg("商品类目数据");
		return ServerResponse.createBySuccess("商品数目数据", json);
	}
	/**
	 * 添加类目信息
	 */
	@Override
	public ServerResponse<Integer> addCategory(ShopGoodsCategory shopGoodsCategory) {
		shopGoodsCategory.setCreatedTime(new Date());
		Integer result=mapper.addCategory(shopGoodsCategory);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("添加成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "添加失败");
		}
		
	}
	/**
	 * 修改类目信息
	 */
	@Override
	public ServerResponse<Integer> updateCategory(ShopGoodsCategory shopGoodsCategory) {
		shopGoodsCategory.setUpdatedTime(new Date());
		Integer result=mapper.updateCategory(shopGoodsCategory);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("修改成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "修改失败");
		}
	}
	/**
	 * 删除类目信息
	 */
	@Override
	public ServerResponse<Integer> deleteCategory(Integer catId) {
		Integer result=mapper.deleteCategory(catId);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("删除成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "删除失败");
		}
	}

}
