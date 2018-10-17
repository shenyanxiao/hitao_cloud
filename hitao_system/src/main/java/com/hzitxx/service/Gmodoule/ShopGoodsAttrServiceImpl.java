package com.hzitxx.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopGoodsAttr;
import com.hzitxx.mapper.ShopGoodsAttrMapper;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

@Service
public class ShopGoodsAttrServiceImpl implements ShopGoodsAttrService {
	@Autowired
	private ShopGoodsAttrMapper mapper;
	/**
	 *  查询所有商品属性/根据商品id回显商品属性
	 */
	@Override
	public ServerResponse<Json<List<ShopGoodsAttr>>> findAll(int page,int limit) {
		Map<String, Object> map=new HashMap<>();
		PageHelper.startPage(page,limit);
		List<ShopGoodsAttr> list=mapper.findAll(map);
		PageInfo<ShopGoodsAttr> pageInfo=new PageInfo<>(list);
		Json<List<ShopGoodsAttr>> json=new Json<>();
		json.setCode(0);
		json.setCount(pageInfo.getTotal());
		json.setMsg("商品属性数据");
		json.setData(pageInfo.getList());
		return ServerResponse.createBySuccess("商品属性数据",json);
	}
	/**
	 * 添加商品属性
	 */
	@Override
	public ServerResponse<Integer> addAttr(ShopGoodsAttr shopGoodsAttr) {
		shopGoodsAttr.setCreatedTime(new Date());
		Integer result=mapper.addAttr(shopGoodsAttr);
		if(result==1) {
			return  ServerResponse.createBySuccessMessage("添加成功");
		}
		else {
			return  ServerResponse.createByErrorCodeMessage(1, "添加失败");
		}
	}
	/**
	 * 根据商品id修改商品属性
	 */
	@Override
	public ServerResponse<Integer> updateAttr(ShopGoodsAttr shopGoodsAttr) {
		shopGoodsAttr.setUpdatedTiime(new Date());
		Integer result=mapper.updateAttr(shopGoodsAttr);
		if(result==1) {
			return  ServerResponse.createBySuccessMessage("修改成功");
		}
		else {
			return  ServerResponse.createByErrorCodeMessage(1, "修改失败");
		}
	}
	/**
	 * 根据商品id删除商品属性
	 */
	@Override
	public ServerResponse<Integer> deleteAttr(Integer goodsId) {
		Integer result=mapper.deleteAttr(goodsId);
		if(result==1) {
			return  ServerResponse.createBySuccessMessage("删除成功");
		}
		else {
			return  ServerResponse.createByErrorCodeMessage(1, "删除失败");
		}
	}

}
