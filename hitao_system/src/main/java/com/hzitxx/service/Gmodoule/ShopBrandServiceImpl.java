package com.hzitxx.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopBrand;
import com.hzitxx.mapper.ShopBrandMapper;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;
@Service
public class ShopBrandServiceImpl implements ShopBrandService {
	@Autowired
	private ShopBrandMapper mapper;
	/**
	 * 查询所有品牌/根据id回显品牌信息/实现分页功能
	 */
	@Override
	public ServerResponse<Json<List<ShopBrand>>> findAll(int page,int limit) {
		Map<String, Object> map=new HashMap<>();
		//PageHelper.offsetPage(page, limit);
		PageHelper.startPage(page,limit);
		List<ShopBrand> list=mapper.findAll(map);
		//System.out.println(list);
		//Page{count=true, pageNum=1, pageSize=5, startRow=0, endRow=5, 
		//total=14, pages=3, reasonable=false, pageSizeZero=false}
        //list包含分页和总数
		//System.out.println(list.getClass().getName());
		PageInfo<ShopBrand> pageInfo=new PageInfo<>(list);//让PageInfo去解析list里面的数据
		//pageInfo.getTotal();//获取总数
		//pageInfo.getList();
		//System.out.println(pageInfo.getTotal());
		//System.out.println(pageInfo.getList());
		Json<List<ShopBrand>> json=new Json<>();
		json.setCode(0);
		json.setCount(pageInfo.getTotal());
		json.setMsg("商品品牌数据");
		json.setData(pageInfo.getList());
		//ServerResponse.create
		return ServerResponse.createBySuccess("商品品牌数据",json);
	}
	/**
	 * 添加品牌信息
	 */
	@Override
	public ServerResponse<Integer> addBrand(ShopBrand shopBrand) {
		    shopBrand.setCreatedTime(new Date());
			Integer result=mapper.addBrand(shopBrand);
			if(result==1) {
				//添加成功    status默认为0 表示成功          非0表示失败     
				return ServerResponse.createBySuccessMessage("添加成功");
			}
			else {
				// 1表示失败
			    return ServerResponse.createByErrorCodeMessage(1,"添加失败");
			}
	}
    /**
     * 根据id修改品牌信息
     */
	@Override
	public ServerResponse<Integer> updateBrand(ShopBrand shopBrand) {
		shopBrand.setUpdatedTime(new Date());
		Integer result=mapper.updateBrand(shopBrand);
		if(result==1) {
			return  ServerResponse.createBySuccessMessage("修改成功");
		}
		else {
			return  ServerResponse.createByErrorCodeMessage(1,"修改失败");
		}
	}
	/**
	 * 根据id删除品牌信息
	 */
	@Override
	public ServerResponse<Integer> deleteBrand(Integer brandId) {
		Integer result=mapper.deleteBrand(brandId);
		if(result==1) {
			return ServerResponse.createBySuccessMessage("删除成功");
		}
		else {
			return  ServerResponse.createByErrorCodeMessage(1, "删除失败");
		}
	}
	
}
