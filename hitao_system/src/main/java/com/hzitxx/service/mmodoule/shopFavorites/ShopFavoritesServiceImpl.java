package com.hzitxx.service.Mmodoule.shopFavorites;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopFavorites;
import com.hzitxx.mapper.mmodoule.ShopFavoritesMapper;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;
@Service
public class ShopFavoritesServiceImpl implements ShopFavoritesService{
	@Autowired
	private ShopFavoritesMapper mapper;
	/**
	 * 分页查询
	 */
	@Override
	public ServerResponse<PageUtil<List<ShopFavorites>>> page(int page, int limit,Map<String, Object> map) {
		PageHelper.startPage(page,limit);
		List<ShopFavorites> shop=mapper.findFavority(map);
		System.out.println(shop);
		System.out.println(shop.getClass().getName());
		PageInfo<ShopFavorites> pageInfo=new PageInfo<ShopFavorites>(shop);
		PageUtil<List<ShopFavorites>> pageUtil=new PageUtil<List<ShopFavorites>>();
		pageUtil.setCode(0);
		pageUtil.setMsg("喜欢的商品");
		//获取总记录  pageInfo.getTotal()
		pageUtil.setCount(pageInfo.getTotal());
		//获取数据  pageInfo.getList()
		pageUtil.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(pageUtil);
	}
	/**
	 * 增加
	 */
	@Override
	public ServerResponse<Integer> addFavorites(ShopFavorites shop) {
		int result=mapper.addFavotity(shop);
		if(result!=1) {
			return  ServerResponse.createBySuccessMessage("添加失败");	
		}
		return  ServerResponse.createBySuccessMessage("添加成功");
	}
	/**
	 * 编辑
	 */
	@Override
	public ServerResponse<Integer> updateFavorites(ShopFavorites shop) {
		int result=mapper.updateFavotity(shop);
		if(result!=1) {
			return  ServerResponse.createBySuccessMessage("编辑失败");
		}
		return ServerResponse.createBySuccessMessage("编辑成功");
	}
	/**
	 * 删除
	 */
	@Override
	public ServerResponse<Integer> delete(Integer favId) {
		int result=mapper.deleteFavority(favId);
		if(result!=1) {
			return  ServerResponse.createBySuccessMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}
	/**
	 * 根据id查询
	 */
	@Override
	public ServerResponse<ShopFavorites> findOne(Integer favId) {
		List<ShopFavorites> shop=mapper.findOne(favId);
		if(shop==null) {
			return ServerResponse.createBySuccessMessage("查询失败");
		}
		return ServerResponse.createBySuccessMessage("查询成功");
	}

}
