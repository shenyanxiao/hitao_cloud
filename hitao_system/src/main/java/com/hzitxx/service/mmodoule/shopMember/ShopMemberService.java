package com.hzitxx.service.Mmodoule.shopMember;

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopMember;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

public interface ShopMemberService {
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @return
	 */
	public ServerResponse<PageUtil<List<ShopMember>>> page(int page,int limit,Map<String, Object> map);
	/**
	 * 添加
	 * @param shop
	 * @return
	 */
	ServerResponse<Integer> addMember(ShopMember shop);
	/**
	 * 编辑
	 * @param shop
	 * @return
	 */
	ServerResponse<Integer> updateMember(ShopMember shop);
	/**
	 * 删除
	 * @param shop
	 * @return
	 */
	ServerResponse<Integer> deleteMember(Integer memberId,Integer isDel);
	/**
	 * 根据id查询
	 * @param memberId
	 * @return
	 */
	ServerResponse<ShopMember> findOne(Integer memberId);
}
