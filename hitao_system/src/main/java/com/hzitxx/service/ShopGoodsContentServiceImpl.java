package com.hzitxx.service;

import static org.mockito.Matchers.matches;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopGoodsContent;
import com.hzitxx.mapper.ShopGoodsContentMapper;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
import com.thoughtworks.xstream.mapper.Mapper;
/**
 * 商品内容
 * @author Shinelon
 *
 */
@Service
public class ShopGoodsContentServiceImpl implements ShopGoodsContentService {
	@Autowired
	private ShopGoodsContentMapper mapper;
	/**
	 * 查询所有内容/根据商品id回显内容信息
	 */
	@Override
	public ServerResponse<Json<List<ShopGoodsContent>>> findAll(int page, int limit) {
		Map<String, Object> map=new HashMap<>();
		PageHelper.startPage(page,limit);
		List<ShopGoodsContent> list=mapper.findAll(map);
		PageInfo<ShopGoodsContent> pageInfo=new PageInfo<>(list);
		Json<List<ShopGoodsContent>> json=new Json<>();
		json.setCode(0);
		json.setCount(pageInfo.getTotal());
		json.setData(pageInfo.getList());
		json.setMsg("商品内容数据");
		return ServerResponse.createBySuccess("商品内容数据", json);
	}
	/**
	 * 添加内容信息
	 */
	@Override
	public ServerResponse<Integer> addContent(ShopGoodsContent shopGoodsContent) {
		shopGoodsContent.setCreatedTime(new Date());
		Integer result=mapper.addContent(shopGoodsContent);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("添加成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "添加失败");
		}
	}
	/**
	 * 根据商品id修改内容信息
	 */
	@Override
	public ServerResponse<Integer> updateContent(ShopGoodsContent shopGoodsContent) {
		shopGoodsContent.setUpdatedTime(new Date());
		Integer result=mapper.updateContent(shopGoodsContent);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("修改成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "修改失败");
		}
	}
	/**
	 * 根据商品id真正意义上的删除内容信息(从数据库中删除)
	 */
	@Override
	public ServerResponse<Integer> deleteContent(Integer goodsId) {
		Integer result=mapper.deleteContent(goodsId);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("删除成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "删除失败");
		}
	}

}
