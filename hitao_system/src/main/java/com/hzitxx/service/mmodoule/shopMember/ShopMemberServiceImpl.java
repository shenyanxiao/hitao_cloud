package com.hzitxx.service.Mmodoule.shopMember;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopMember;
import com.hzitxx.mapper.mmodoule.ShopMemberMapper;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;
/**
 * 会员表
 * @author Administrator
 *
 */
@Service
public class ShopMemberServiceImpl implements ShopMemberService {
	@Autowired
	private ShopMemberMapper mapper;
	/**
	 * 分页查询
	 */
	@Override
	public ServerResponse<PageUtil<List<ShopMember>>> page(int page, int limit,Map<String, Object> map) {
		PageHelper.startPage(page,limit);
		List<ShopMember> shop=mapper.findMember(map);
		System.out.println(shop);
		System.out.println(shop.getClass().getName());
		PageInfo<ShopMember> pageInfo=new PageInfo<ShopMember>(shop);
		PageUtil<List<ShopMember>> pageUtils=new PageUtil<List<ShopMember>>();
		pageUtils.setCode(0);
		pageUtils.setMsg("成员");
		pageUtils.setCount(pageInfo.getTotal());
		pageUtils.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(pageUtils);
	}
	/**
	 * 添加
	 */
	@Override
	public ServerResponse<Integer> addMember(ShopMember shop) {
		int result=mapper.addMember(shop);
		if(result!=1) {
			return ServerResponse.createBySuccessMessage("添加失败");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}
	/**
	 * 编辑
	 */
	@Override
	public ServerResponse<Integer> updateMember(ShopMember shop) {
		int result=mapper.updateMember(shop);
		if(result!=1) {
			return ServerResponse.createBySuccessMessage("编辑失败");
		}
		return ServerResponse.createBySuccessMessage("编辑成功");
	}
	/**
	 * 删除
	 */
	@Override
	public ServerResponse<Integer> deleteMember(Integer memberId,Integer isDel) {
		int result=mapper.deleteMember(memberId, isDel);
		if(result!=1) {
			return ServerResponse.createBySuccessMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}
	/**
	 * 根据id查询
	 */
	@Override
	public ServerResponse<ShopMember> findOne(Integer memberId) {
		List<ShopMember> shop=mapper.findOne(memberId);
		if(shop==null) {
			return ServerResponse.createBySuccessMessage("查询失败");
		}
		return ServerResponse.createBySuccessMessage("查询成功");
	}
	
}
