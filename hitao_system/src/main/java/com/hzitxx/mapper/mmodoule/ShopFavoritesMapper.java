package com.hzitxx.mapper.mmodoule;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopFavorites;

/**
 * 会员模块  shop_favorities
 * @author Administrator
 *
 */
public interface ShopFavoritesMapper {
	/**
	 * 增加
	 * @param shopFavorites
	 * @return
	 */
	Integer addFavotity(ShopFavorites shopFavorites);
	/**
	 * 编辑
	 * @param favId
	 * @return
	 */
	Integer updateFavotity(ShopFavorites shop);
	/**
	 * 查询
	 * @param favId
	 * @return
	 */
	List<ShopFavorites> findFavority(Map<String, Object> map);
	/**
	 * 删除
	 * @param favId
	 * @return
	 */
	Integer deleteFavority(Integer favId);
	/**
	 * 根据id查询
	 * @param favId
	 * @return
	 */
	List<ShopFavorites> findOne(Integer favId);
}
