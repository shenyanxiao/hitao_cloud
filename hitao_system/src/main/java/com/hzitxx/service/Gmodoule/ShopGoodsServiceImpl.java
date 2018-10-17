package com.hzitxx.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopGoods;
import com.hzitxx.entity.ShopGoodsImages;
import com.hzitxx.mapper.ShopGoodsMapper;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
/**
 * 商品信息
 * @author Shinelon
 *
 */
@Service
public class ShopGoodsServiceImpl implements ShopGoodsService {
	@Autowired
	private ShopGoodsMapper mapper;
	/**
	 * 查询所有商品信息/分页显示/根据id回显商品信息
	 */
	@Override
	public ServerResponse<Json<List<ShopGoods>>> findAll(int page, int limit) {
		Map<String, Object> map=new HashMap<>();
		PageHelper.startPage(page,limit);
		List<ShopGoods> list=mapper.findAll(map);
		PageInfo<ShopGoods> pageInfo=new PageInfo<>(list);
		Json<List<ShopGoods>> json=new Json<>();
		json.setCode(0);
		json.setCount(pageInfo.getTotal());
		json.setData(pageInfo.getList());
		json.setMsg("商品数据");
		return ServerResponse.createBySuccess("商品数据", json);
	}
	/**
	 * 添加商品信息
	 */
	@Override
	public ServerResponse<Integer> addGoods(ShopGoods shopGoods) {
		shopGoods.setCreatedTime(new Date());
		Integer result=mapper.addGoods(shopGoods);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("添加成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "添加失败");
		}
	}
	/**
	 * 根据id修改商品信息
	 */
	@Override
	public ServerResponse<Integer> updateGoods(ShopGoods shopGoods) {
		shopGoods.setUpdatedTime(new Date());
		Integer result=mapper.updateGoods(shopGoods);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("修改成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "修改失败");
		}
	}
	/**
	 * 根据id删除商品信息，真正意义上的删除（从数据库中删除）
	 */
	@Override
	public ServerResponse<Integer> deleteGoods(Integer goodsId) {
		Integer result=mapper.deleteGoods(goodsId);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("删除成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "删除失败");
		}
	}

}
