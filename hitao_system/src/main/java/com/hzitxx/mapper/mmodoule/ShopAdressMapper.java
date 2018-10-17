package com.hzitxx.mapper.mmodoule;
/**
 * 会员模块 shop_adress
 * @author Administrator
 *
 */

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopAddress;

public interface ShopAdressMapper {
	/**
	 * 查询信息
	 */
	List<ShopAddress> findAdress(Map<String, Object> map);
	/**
	 * 增加
	 * @param shop
	 * @return
	 */
	Integer addAdress(ShopAddress shop);
	/**
	 * 编辑
	 * @param shop
	 * @return
	 */
	Integer updateAdress(ShopAddress shop);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Integer deleteAdress(Integer id);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	List<ShopAddress> findOne(Integer id);
}
