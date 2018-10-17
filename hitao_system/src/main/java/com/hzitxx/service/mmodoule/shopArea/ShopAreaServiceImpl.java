package com.hzitxx.service.Mmodoule.shopArea;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopArea;
import com.hzitxx.mapper.mmodoule.ShopAreaMapper;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

@Service
public class ShopAreaServiceImpl implements ShopAreaService {
	@Autowired
	private ShopAreaMapper mapper;
	/**
	 * 添加
	 */
	@Override
	public ServerResponse<Integer> addArea(ShopArea shop) {
		int result=mapper.addArea(shop);
		if(result!=1) {
			return ServerResponse.createBySuccessMessage("添加失败!");
		}
		return ServerResponse.createBySuccessMessage("添加成功!");
	}
	/**
	 * 分页查询
	 */
	@Override
	public ServerResponse<PageUtil<List<ShopArea>>> page(int page, int limit,Map<String, Object> map) {
		PageHelper.startPage(page,limit);// 第一页，每页取5条数据 直接传递参数，PageHelper帮我们换算
		List<ShopArea> shop=mapper.findArea(map);
		System.out.println(shop);		
		System.out.println(shop.getClass().getName());
		PageInfo<ShopArea> pageInfo = new PageInfo<ShopArea>(shop);// 让PageInfo对象去解析shopAdminList里面的数据
		PageUtil<List<ShopArea>> pageUtils = new PageUtil<List<ShopArea>>();
		pageUtils.setCode(0);
		pageUtils.setMsg("地区");
		pageUtils.setCount(pageInfo.getTotal());
		pageUtils.setData(pageInfo.getList());
		
		return ServerResponse.createBySuccess(pageUtils);
		
	}
	/**
	 * 编辑
	 */
	@Override
	public ServerResponse<Integer> updateArea(ShopArea shop) {
	   int  result=mapper.updateArea(shop);
	   if(result!=1) {
		   return ServerResponse.createBySuccessMessage("编辑失败");
	   }
		return ServerResponse.createBySuccessMessage("编辑成功");
	}
	/**
	 * 删除
	 */
	@Override
	public ServerResponse<Integer> deleteArea(Integer areaId,Integer isDel) {
		int result=mapper.delete(areaId, isDel);
		if(result!=1) {
			return ServerResponse.createBySuccessMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}
	
	@Override
	public ServerResponse<ShopArea> findOne(Integer areaId) {
		List<ShopArea> shop=mapper.findOne(areaId);
		if(shop==null) {
			//查询失败
			return ServerResponse.createBySuccessMessage("查询失败");
		}
		return ServerResponse.createBySuccessMessage("查询成功");
	}

}
