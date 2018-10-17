package com.hzitxx.service.Mmodoule.shopAdress;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopAddress;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

public interface ShopAdressService {
	/**
	 * 添加
	 * @param shop
	 * @return
	 */
	public  ServerResponse<Integer> addAdress(ShopAddress shop);
	/**
	 * 编辑
	 * @param shop
	 * @return
	 */
	public ServerResponse<Integer> updateAdress(ShopAddress shop);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public ServerResponse<Integer> deleteAdress(Integer id);
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @return
	 */
	public ServerResponse<PageUtil<List<ShopAddress>>> page(int page,int limit,Map<String, Object> map);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public ServerResponse<ShopAddress> findOne(Integer id);
}
