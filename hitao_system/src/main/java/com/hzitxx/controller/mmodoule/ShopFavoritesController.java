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

import com.hzitxx.entity.ShopFavorites;
import com.hzitxx.service.Mmodoule.shopFavorites.ShopFavoritesService;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;
/**
 * 喜爱
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/favorites")
public class ShopFavoritesController {
	@Autowired
	private ShopFavoritesService service;
	/**
	 * 返回数据
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping(value="page")
	public ServerResponse<PageUtil<List<ShopFavorites>>>  page(@RequestParam(value="page",defaultValue="1")int page,
			@RequestParam(value="limit",defaultValue="20")int limit,String value){
		Map<String, Object> map=new HashMap<String, Object>();
		return service.page(page, limit,map);
	}
	/**
	 * 处理添加表单
	 * @param shop
	 * @return
	 */
	@PostMapping(value="add")
	public ServerResponse<Integer> add(@RequestBody ShopFavorites shop){
		return service.addFavorites(shop);
	}
	/**
	 * 处理编辑
	 * @param shop
	 * @return
	 */
	@PostMapping(value="update")
	public ServerResponse<Integer> update(@RequestBody ShopFavorites shop){
		return service.updateFavorites(shop);
	}
	/**
	 * 处理删除
	 * @param favId
	 * @return
	 */
	@PostMapping(value="delete")
	public ServerResponse<Integer> delete(@RequestBody Integer favId){
		return service.delete(favId);
	}
	/**
	 * 处理根据id查询
	 * @param favId
	 * @return
	 */
	@PostMapping(value="findOne")
	public ServerResponse<ShopFavorites> findOne(@RequestBody Integer favId){
		return service.findOne(favId);
	}
}
