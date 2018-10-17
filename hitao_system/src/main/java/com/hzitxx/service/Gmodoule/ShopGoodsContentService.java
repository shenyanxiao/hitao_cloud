package com.hzitxx.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopGoodsContent;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
/**
 * 商品内容
 * @author Shinelon
 *
 */
public interface ShopGoodsContentService {
	/**
	 * 查询所有内容/根据商品id回显内容信息
	 */
	ServerResponse<Json<List<ShopGoodsContent>>> findAll(int page,int limit);
	/**
	 * 添加内容信息
	 */
	ServerResponse<Integer> addContent(ShopGoodsContent shopGoodsContent);
	/**
	 * 根据商品id修改内容信息
	 */
	ServerResponse<Integer> updateContent(ShopGoodsContent shopGoodsContent);
	/**
	 * 根据商品id真正意义上的删除内容信息(从数据库中删除)
	 */
	ServerResponse<Integer> deleteContent(Integer goodsId);
}
