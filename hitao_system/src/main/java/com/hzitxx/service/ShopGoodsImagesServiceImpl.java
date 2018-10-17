package com.hzitxx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopGoodsImages;
import com.hzitxx.mapper.ShopGoodsImagesMapper;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
import com.thoughtworks.xstream.mapper.Mapper;
/**
 * 商品图片
 * @author Shinelon
 *
 */
@Service
public class ShopGoodsImagesServiceImpl implements ShopGoodsImagesService {
	@Autowired
	private ShopGoodsImagesMapper mapper;
	/**
	 * 查询所有商品图片/根据商品id回显图片信息
	 */
	@Override
	public ServerResponse<Json<List<ShopGoodsImages>>> findAll(int page, int limit) {
		Map<String, Object> map=new HashMap<>();
		PageHelper.startPage(page,limit);
		List<ShopGoodsImages> list=mapper.findAll(map);
		PageInfo<ShopGoodsImages> pageInfo=new PageInfo<>(list);
		Json<List<ShopGoodsImages>> json=new Json<>();
		json.setCode(0);
		json.setCount(pageInfo.getTotal());
		json.setData(pageInfo.getList());
		json.setMsg("商品图片数据");
		return ServerResponse.createBySuccess("商品图片数据", json);
	}
	/**
	 * 添加商品图片信息
	 */
	@Override
	public ServerResponse<Integer> addImages(ShopGoodsImages shopGoodsImages) {
		Integer result=mapper.addImages(shopGoodsImages);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("添加成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "添加失败");
		}
	}
	/**
	 * 根据商品id修改图片信息
	 */
	@Override
	public ServerResponse<Integer> updateImages(ShopGoodsImages shopGoodsImages) {
		Integer result=mapper.updateImages(shopGoodsImages);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("修改成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "修改失败");
		}
	}
	/**
	 * 根据商品id删除图片信息
	 */
	@Override
	public ServerResponse<Integer> deleteImages(Integer goodsId) {
		Integer result=mapper.deleteImages(goodsId);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("删除成功");
		}
		else {
			return ServerResponse.createByErrorCodeMessage(1, "删除失败");
		}
	}

}
