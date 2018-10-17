package com.hzitxx.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopGoodsContent;
/**
 * 商品内容信息
 * @author Shinelon
 *
 */
public interface ShopGoodsContentMapper {
	/**
	 * 查询所有内容/根据商品id回显内容信息
	 */
	List<ShopGoodsContent> findAll(Map<String, Object> map);
	/**
	 * 添加内容信息
	 */
	Integer addContent(ShopGoodsContent shopGoodsContent);
	/**
	 * 根据商品id修改内容信息
	 */
	Integer updateContent(ShopGoodsContent shopGoodsContent);
	/**
	 * 根据商品id真正意义上的删除内容信息(从数据库中删除)
	 */
	Integer deleteContent(Integer goodsId);
}
