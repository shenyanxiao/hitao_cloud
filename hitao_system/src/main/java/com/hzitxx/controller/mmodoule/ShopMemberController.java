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

import com.hzitxx.entity.ShopMember;
import com.hzitxx.service.Mmodoule.shopMember.ShopMemberService;
import com.hzitxx.utils.PageUtil;
import com.hzitxx.utils.ServerResponse;
/**
 * 会员表  前端控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/member")
public class ShopMemberController {
	@Autowired
	private ShopMemberService service;
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param value
	 * @return
	 */
	@GetMapping(value="page")
	public ServerResponse<PageUtil<List<ShopMember>>> page(@RequestParam(value="page",defaultValue="1")int page,
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
	public ServerResponse<Integer> add(@RequestBody ShopMember shop) {
		return service.addMember(shop);
	}
	/**
	 * 处理编辑
	 * @param shop
	 * @return
	 */
	@PostMapping(value="update")
	public ServerResponse<Integer> update(@RequestBody ShopMember shop) {
		return service.updateMember(shop);
	}
	/**
	 * 处理删除
	 * @param memberId
	 * @param isDel
	 * @return
	 */
	@PostMapping(value="delete")
	public ServerResponse<Integer> delete(@RequestBody Integer memberId,Integer isDel){
		return service.deleteMember(memberId, isDel);
	}
	/**
	 * 处理根据id查询
	 * @param memberId
	 * @return
	 */
	@PostMapping(value="findOne")
	public ServerResponse<ShopMember> findOne(@RequestBody Integer memberId){
		return service.findOne(memberId);
	}
 }
