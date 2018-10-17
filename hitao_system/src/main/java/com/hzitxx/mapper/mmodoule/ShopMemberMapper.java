package com.hzitxx.mapper.mmodoule;

/**
 * 会员模块  商店人员
 * @author Administrator
 *
 */

import java.util.List;
import java.util.Map;

import com.hzitxx.entity.ShopMember;

public interface ShopMemberMapper {
	/**
	 * 增加
	 * @return
	 */
	Integer addMember(ShopMember shopMember);
	/**
	 * 删除
	 * @param memberId
	 * @return
	 */
	Integer deleteMember(Integer memberId,Integer isDel);
	/**
	 * 编辑
	 * @param shopMember
	 * @return
	 */
	Integer updateMember(ShopMember shopMember );
	/**
	 * 查询
	 */
	List<ShopMember> findMember(Map<String, Object> map);
	/**
	 * 根据id查询
	 * @param memberId
	 * @return
	 */
	List<ShopMember> findOne(Integer memberId);
}
