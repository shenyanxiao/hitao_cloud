package com.hzitxx.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopGoodsImages;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
/**
 * 商品图片
 * @author Shinelon
 *
 */
public interface ShopGoodsImagesService {
	/**
	 * 查询所有商品图片/根据商品id回显图片信息
	 */
	ServerResponse<Json<List<ShopGoodsImages>>> findAll(int page,int limit);
	/**
	 * 添加商品图片信息
	 */
	ServerResponse<Integer> addImages(ShopGoodsImages shopGoodsImages);
	/**
	 * 根据商品id修改图片信息
	 */
	ServerResponse<Integer> updateImages(ShopGoodsImages shopGoodsImages);
	/**
	 * 根据商品id删除图片信息
	 */
	ServerResponse<Integer> deleteImages(Integer goodsId);
}
