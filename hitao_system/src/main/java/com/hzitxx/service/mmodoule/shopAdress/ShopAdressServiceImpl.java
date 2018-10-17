package com.hzitxx.service.Mmodoule.shopAdress;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.entity.ShopAddress;
import com.hzitxx.mapper.mmodoule.ShopAdressMapper;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;
@Service
public class ShopAdressServiceImpl implements ShopAdressService {
	@Autowired
	private ShopAdressMapper mapper;
	/**
	 * status:0
	 * msg:"添加成功"
	 * datd:null
	 */
	@Override
	public ServerResponse<Integer> addAdress(ShopAddress shop) {
		int result=mapper.addAdress(shop);
		if(result!=1) {
			//添加失败  status的默认值为0
			return ServerResponse.createBySuccessMessage("添加失败!");
			//ServerResponse.createBySuccess();// 没有消息没有数据,status=0
			//ServerResponse.createBySuccess(data);// 只有数据没有消息
			//ServerResponse.createBySuccess(msg, data) // 有消息有数据
		}
		
		return ServerResponse.createBySuccessMessage("添加成功!");
	}
	/**
	 * 分页  PageHelper工具实现分页查询
	 */
	@Override
	public ServerResponse<PageUtil<List<ShopAddress>>> page(int page, int limit,Map<String, Object> map) {
		//PageHelper.offsetPage(1, 10);// limit 1 10 需要程序员获取浏览器传递的参数，进行换算
		PageHelper.startPage(page,limit);// 第一页，每页取5条数据 直接传递参数，PageHelper帮我们换算
		List<ShopAddress> shop=mapper.findAdress(map);
		System.out.println(shop);
		// shopAdminList 包含了分页后的数据和总记录数
		System.out.println(shop.getClass().getName());
		PageInfo<ShopAddress> pageInfo = new PageInfo<ShopAddress>(shop);// 让PageInfo对象去解析shopAdminList里面的数据
//		pageInfo.getTotal();
//		pageInfo.getList();
		PageUtil<List<ShopAddress>> pageUtils = new PageUtil<List<ShopAddress>>();
		pageUtils.setCode(0);
		pageUtils.setMsg("成员地址");
		pageUtils.setCount(pageInfo.getTotal());
		pageUtils.setData(pageInfo.getList());
		
		return ServerResponse.createBySuccess(pageUtils);
	}
	/**
	 * 编辑
	 */
	@Override
	public ServerResponse<Integer> updateAdress(ShopAddress shop) {
		int result=mapper.updateAdress(shop);
		if(result!=1) {
			//编辑成功
			return ServerResponse.createBySuccessMessage("编辑失败!");
		}
		return ServerResponse.createBySuccessMessage("编辑成功!");
	}
	/**
	 * 删除
	 */
	@Override
	public ServerResponse<Integer> deleteAdress(Integer id) {
		int result=mapper.deleteAdress(id);
		if(result!=1) {
			//删除失败
			return ServerResponse.createBySuccessMessage("删除失败!");
		}
		return ServerResponse.createBySuccessMessage("删除成功!");
	}
	/**
	 * 根据id查询
	 */
	@Override
	public ServerResponse<ShopAddress> findOne(Integer id) {
		List<ShopAddress> shop=mapper.findOne(id);
		if(shop==null) {
			//查询失败
			return ServerResponse.createBySuccessMessage("查询失败!");
		}
		return ServerResponse.createBySuccessMessage("查询成功!");
	}

}
