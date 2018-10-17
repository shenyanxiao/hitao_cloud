package com.hzit.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.SystemMicroService8080;
import com.hzitxx.entity.ShopBrand;
import com.hzitxx.service.ShopBrandService;
import com.hzitxx.utils.Json;
import com.hzitxx.utils.ServerResponse;

/**
 * Service层测试
 * @author Shinelon
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SystemMicroService8080.class)
public class ServiceTest {
	@Autowired
	private ShopBrandService shopBrandService;
	/**
	 * 测试ShopBrandService中查询所有品牌/根据id回显品牌信息/实现分页
	 */
	@Test
	public void findAll() {
		ServerResponse<Json<List<ShopBrand>>> sResponse=shopBrandService.findAll(1,5);
		System.out.println(sResponse.getData().getData().size());
		System.out.println(sResponse.getData().getCount()); 
	}
}
