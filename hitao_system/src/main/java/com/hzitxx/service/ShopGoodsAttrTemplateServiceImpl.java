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
import com.hzitxx.entity.ShopGoodsAttrTemplate;
import com.hzitxx.mapper.ShopGoodsAttrTemplateMapper;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
import com.thoughtworks.xstream.mapper.Mapper;
/**
 * 商品属性模块
 * @author Shinelon
 *
 */
@Service
public class ShopGoodsAttrTemplateServiceImpl implements ShopGoodsAttrTemplateService {
	@Autowired
	private  ShopGoodsAttrTemplateMapper mapper;
	/**
	 * 查询所有商品属性/根据类目id回显商品属性/分布显示
	 */
	@Override
	public ServerResponse<Json<List<ShopGoodsAttrTemplate>>> findAll(int page,int limit) {
		Map<String, Object> map=new HashMap<>();
		PageHelper.startPage(page,limit);
		List<ShopGoodsAttrTemplate> list=mapper.findAll();
		PageInfo<ShopGoodsAttrTemplate> pageInfo=new PageInfo<>(list);
		Json<List<ShopGoodsAttrTemplate>> json=new Json<>();
		json.setCode(0);
		json.setCount(pageInfo.getTotal());
		json.setMsg("商品属性模块数据");
		json.setData(pageInfo.getList());
		return ServerResponse.createBySuccess("商品属性模块数据",json);
	}
	/**
	 * 添加商品属性
	 */
	@Override
	public ServerResponse<Integer> addAttrTemplate(ShopGoodsAttrTemplate shopGoodsAttrTemplate) {
		shopGoodsAttrTemplate.setCreatedTime(new Date());
		Integer result=mapper.addAttrTemplate(shopGoodsAttrTemplate);
		if(result==1) {
			return  ServerResponse.createBySuccessMessage("添加成功");
		}
		else {
			return  ServerResponse.createByErrorCodeMessage(1, "添加失败");
		}
	}
	/**
	 * 根据类目id修改商品属性
	 */
	@Override
	public ServerResponse<Integer> updateAttrTemplate(ShopGoodsAttrTemplate shopGoodsAttrTemplate) {
		shopGoodsAttrTemplate.setUpdatedTime(new Date());
		Integer result=mapper.updateAttrTemplate(shopGoodsAttrTemplate);
		if(result==1) {
			return  ServerResponse.createBySuccessMessage("修改成功");
		}
		else {
			return  ServerResponse.createByErrorCodeMessage(1, "修改失败");
		}
	}
	/**
	 * 根据类目id删除商品属性
	 */
	@Override
	public ServerResponse<Integer> deleteAttrTemplate(Integer catId) {
		Integer result=mapper.deleteAttrTemplate(catId);
		if(result==1) {
			return  ServerResponse.createBySuccessMessage("删除成功");
		}
		else {
			return  ServerResponse.createByErrorCodeMessage(1, "删除失败");
		}
	}

}
