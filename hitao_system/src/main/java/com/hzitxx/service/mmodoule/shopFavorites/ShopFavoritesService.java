package com.hzitxx.service.Mmodoule.shopFavorites;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopFavorites;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

public interface ShopFavoritesService {
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @return
	 */
	public ServerResponse<PageUtil<List<ShopFavorites>>> page(int page,int limit,Map<String, Object> map);
	/**
	 * 增加
	 */
	ServerResponse<Integer> addFavorites(ShopFavorites shop);
	/**
	 * 编辑
	 * @param shop
	 * @return
	 */
	ServerResponse<Integer> updateFavorites(ShopFavorites shop);
	/**
	 * 删除
	 * @param favId
	 * @return
	 */
	ServerResponse<Integer> delete(Integer favId);
	/**
	 * 根据id查询
	 * @param favId
	 * @return
	 */
	ServerResponse<ShopFavorites> findOne(Integer favId);
}
