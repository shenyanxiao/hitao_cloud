package com.hzit.test.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.AuthcMicroService8082;
import com.hzitxx.entity.ShopMenu;
import com.hzitxx.entity.ShopRole;
import com.hzitxx.mapper.ShopMenuMapper;
import com.hzitxx.mapper.ShopRoleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=AuthcMicroService8082.class)
public class MapperTest {
	@Autowired
	private ShopRoleMapper mapper;
	@Autowired
	private ShopMenuMapper shopMenuMapper;
	private ShopRole shopRole=new ShopRole();
	/**
	 * 测试ShopRoleMapper中查询方法
	 */
	@Test
	public void findAllRole() {
		Map<String, Object> map=new HashMap<>();
		map.put("roleId", 13);
		List<ShopRole> list=mapper.findAll(map);
		System.out.println(list);
	}
	/**
	 * 测试ShopRoleMapper中的添加方法
	 */
	@Test
	public void addRole() {
		shopRole.setRoleName("测试2");
		shopRole.setCreatedTime(new Date());
		shopRole.setIsDel(1);
		mapper.addRole(shopRole);
	}
	/*
	 * 测试ShopRoleMapper中编辑方法
	 */
	@Test
	public void updateRole() {
		shopRole.setRoleId(32);
		shopRole.setRoleName("测试");
		shopRole.setUpdatedTime(new Date());
		mapper.updateRole(shopRole);
	}
	/**
	 * 测试ShopRoleMapper中的批量删除方法
	 */
	@Test
	public void deleteRole() {
		List<Integer> list=new ArrayList<>();
		list.add(42);list.add(43);list.add(45);
		mapper.deleteRole(list);
	}
	
	
	/**
	 * 测试ShopMenuMapper中的查询方法
	 */
	@Test
	public void findAllMenu() {
		Map<String,Object> map=new HashMap<>();
		List<ShopMenu> list=shopMenuMapper.findAll(map);
		System.out.println(list);
	}
	/**
	 * 测试ShopMenuMapper中的删除方法
	 */
	@Test
	public void deleteMenu() {
		shopMenuMapper.deleteMenu(25);
	}
}
