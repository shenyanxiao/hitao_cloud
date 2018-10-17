package com.hzitxx.service.Mmodoule.shopArea;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopArea;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

public interface ShopAreaService {
	/**
	 * 添加
	 * @param shop
	 * @return
	 */
	public  ServerResponse<Integer> addArea(ShopArea shop);
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @return
	 */
	public ServerResponse<PageUtil<List<ShopArea>>> page(int page,int limit,Map<String, Object> map);
	/**
	 * 编辑
	 * @param shop
	 * @return
	 */
	public ServerResponse<Integer> updateArea(ShopArea shop);
	/**
	 * 删除
	 * @param areaId
	 * @return
	 */
	public ServerResponse<Integer> deleteArea(Integer areaId,Integer isDel);
	/**
	 * 根据id查询
	 * @param areaId
	 * @return
	 */
	public ServerResponse<ShopArea> findOne(Integer areaId);
}
