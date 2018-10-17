package com.hzitxx.controller.mmodoule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hzitxx.entity.ShopAddress;
import com.hzitxx.service.Mmodoule.shopAdress.ShopAdressService;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

@RestController
@RequestMapping("/adress")
public class ShopAdressController {
	@Autowired
	private ShopAdressService service;
	/**
	 * 跳转到shopadresss
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping(value="page")
	public ServerResponse<PageUtil<List<ShopAddress>>> page(@RequestParam(value="page",defaultValue="1")int page,
			@RequestParam(value="limit",defaultValue="20")int limit,String value){
		Map<String, Object> map=new HashMap<String, Object>();
		return service.page(page, limit,map);
	}
	/**
	 * 处理添加
	 * @param shop
	 * @return
	 */
	@PostMapping(value="add")
	public ServerResponse<Integer> add(@RequestBody ShopAddress shop){
		return service.addAdress(shop);
	}
	/**
	 * 处理编辑
	 * @param shop
	 * @return
	 */
	@PostMapping(value="update")
	public ServerResponse<Integer> update(@RequestBody ShopAddress shop){
		return service.updateAdress(shop);
	}
	/**
	 * 处理删除
	 * @param id
	 * @return
	 */
	@PostMapping(value="delete")
	public ServerResponse<Integer> delete(@RequestBody Integer id){
		return service.deleteAdress(id);
	}
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@PostMapping(value="findOne")
	public ServerResponse<ShopAddress> findOne(@RequestBody Integer id){
		return service.findOne(id);
	}
}
