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
import com.hzitxx.entity.ShopArea;
import com.hzitxx.service.Mmodoule.shopArea.ShopAreaService;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;

@RestController
@RequestMapping("/area")
public class ShopAreaController {
	@Autowired
	private ShopAreaService service;
	/**
	 * 返回数据
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping(value="page")
	public ServerResponse<PageUtil<List<ShopArea>>> page(@RequestParam(value="page",defaultValue="1")int page,
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
	public ServerResponse<Integer> add(@RequestBody ShopArea shop){
		return service.addArea(shop);
	}
	/**
	 * 处理编辑
	 * @param shop
	 * @return
	 */
	@PostMapping(value="update")
	public ServerResponse<Integer> update(@RequestBody ShopArea shop){
		return service.updateArea(shop);
	}
	/**
	 * 处理删除
	 * @param areaId
	 * @param isDel
	 * @return
	 */
	@PostMapping(value="delete")
	public ServerResponse<Integer> delete(@RequestBody Integer areaId,Integer isDel){
		return service.deleteArea(areaId, isDel); 
	}
	/**
	 * 处理根据id查询
	 * @param areaId
	 * @return
	 */
	@PostMapping(value="findOne")
	public ServerResponse<ShopArea> findOne(Integer areaId){
		return service.findOne(areaId);
	}	
	
}
