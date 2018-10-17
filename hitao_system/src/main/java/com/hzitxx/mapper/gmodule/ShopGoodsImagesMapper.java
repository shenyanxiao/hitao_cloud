package com.hzitxx.mapper;
/**
 * 商品图片
 * @author Shinelon
 *
 */

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopGoodsImages;

public interface ShopGoodsImagesMapper {
	/**
	 * 查询所有商品图片/根据商品id回显图片信息
	 */
	List<ShopGoodsImages> findAll(Map<String, Object> map);
	/**
	 * 添加商品图片信息
	 */
	Integer addImages(ShopGoodsImages shopGoodsImages);
	/**
	 * 根据商品id修改图片信息
	 */
	Integer updateImages(ShopGoodsImages shopGoodsImages);
	/**
	 * 根据商品id删除图片信息
	 */
	Integer deleteImages(Integer goodsId);
}
