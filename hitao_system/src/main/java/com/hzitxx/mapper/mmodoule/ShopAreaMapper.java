package com.hzitxx.mapper.mmodoule;
/**
 * 会员模块  shop_area
 * @author Administrator
 *
 */

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopArea;

public interface ShopAreaMapper {
	/**
	 * 查询地区
	 * @param areaId
	 * @return
	 */
	List<ShopArea> findArea(Map<String, Object> map);
	/**
	 * 增加
	 * @param shop
	 * @return
	 */
	Integer addArea(ShopArea shop);
	/**
	 * 编辑
	 * @param shop
	 * @return
	 */
	Integer updateArea(ShopArea shop);
	/**
	 * 删除
	 * @param areaId
	 * @param isDel
	 * @return
	 */
	Integer delete(Integer areaId,Integer isDel);
	/**
	 * 根据id查询
	 * @param areaId
	 * @return
	 */
	List<ShopArea> findOne(Integer areaId);
}
