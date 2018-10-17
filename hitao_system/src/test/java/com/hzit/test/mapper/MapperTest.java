package com.hzit.test.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.SystemMicroService8080;
import com.hzitxx.entity.ShopBrand;
import com.hzitxx.entity.ShopFrontCategory;
import com.hzitxx.entity.ShopGoods;
import com.hzitxx.entity.ShopGoodsAttr;
import com.hzitxx.entity.ShopGoodsCategory;
import com.hzitxx.entity.ShopGoodsContent;
import com.hzitxx.entity.ShopGoodsImages;
import com.hzitxx.mapper.ShopBrandMapper;
import com.hzitxx.mapper.ShopFrontCategoryMapper;
import com.hzitxx.mapper.ShopGoodsAttrMapper;
import com.hzitxx.mapper.ShopGoodsCategoryMapper;
import com.hzitxx.mapper.ShopGoodsContentMapper;
import com.hzitxx.mapper.ShopGoodsImagesMapper;
import com.hzitxx.mapper.ShopGoodsMapper;

/**
 * 测试mapper层
 * @author Shinelon
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SystemMicroService8080.class)
public class MapperTest {
	//注入ShopGoodsMapper
	@Autowired
	private ShopGoodsMapper shopGoodsMapper;
	@Autowired
	private ShopBrandMapper shopBrandMapper;
	@Autowired
	private ShopGoodsCategoryMapper shopGoodsCategoryMapper;
	@Autowired
	private ShopGoodsContentMapper shopGoodsContentMapper;
	@Autowired
	private ShopGoodsImagesMapper shopGoodsImagesMapper;
	@Autowired
	private ShopGoodsAttrMapper shopGoodsAttrMapper;
	@Autowired
	private ShopFrontCategoryMapper shopFrontCategoryMapper;
	private ShopGoods shopGoods=new ShopGoods();
	private ShopBrand shopBrand=new ShopBrand();
	private ShopGoodsCategory shopGoodsCategory=new ShopGoodsCategory();
	private ShopGoodsContent shopGoodsContent=new ShopGoodsContent();
	private ShopGoodsImages shopGoodsImages=new ShopGoodsImages();
	private ShopGoodsAttr shopGoodsAttr=new ShopGoodsAttr();
	private ShopFrontCategory shopFrontCategory=new ShopFrontCategory();
	/**
	 * 测试ShopGoodsMapper中的查询所有商品功能   findAll()  
	 * 分页显示
	 * 根据id回显商品信息
	 */
	@Test
	public void findAllTest() {
		Map<String,  Object> map=new HashMap<>();
		map.put("goodsId",2);
		map.put("offset", 0);
		map.put("limit",2);
		List<ShopGoods> list=shopGoodsMapper.findAll(map);
		System.out.println(list);
	}
	/**
	 * 测试ShopGoodsMapper中的添加商品功能   addGoods()
	 */
	@Test
	public void addGoodsTest() {
		shopGoods.setGoodsName("脉动");
		shopGoods.setGoodsJingle("500一次");
		shopGoods.setCreatedTime(new Date());
		Integer result=shopGoodsMapper.addGoods(shopGoods);
		System.out.println(result);
	}
	/**
	 * 测试ShopGoodsMapper中的修改商品功能     updateGoods()
	 */
	@Test
	public void updateGoodsTest() {
		shopGoods.setGoodsId(25);
		shopGoods.setGoodsName("LOL皮肤");
		shopGoods.setIsDel(0);
		shopGoods.setGoodsJingle("全场6拍，老马都亏哭了!");
		shopGoods.setUpdatedTime(new Date());
		Integer result=shopGoodsMapper.updateGoods(shopGoods);
		System.out.println(result);
	}
	/**
	 * 测试ShopGoodsMapper中的删除商品功能    deleteGoods()
	 */
	@Test
	public void deleteGoodsTest() {
		Integer result=shopGoodsMapper.deleteGoods(22);
		System.out.println(result);
	}
	
	
	/**
	 * 测试ShopBrandMapper中的查询所有品牌功能   findAll()
	 */
	@Test
	public void findAllBrandTest() {
		Map<String,Object> map=new HashMap<>();
		map.put("brandId",1 );
		List<ShopBrand> list=shopBrandMapper.findAll(map);
		System.out.println(list);
	}
	/**
	 * 测试ShopBrandMapper中的添加品牌功能   addBrand()
	 */
	@Test
	public void addBrand() {
		//shopBrand.setBrandName("黑蜘蛛");
		//shopBrand.setCreatedTime(new Date());
		Integer result=shopBrandMapper.addBrand(shopBrand);
		System.out.println(result);
	}
	/**
	 * 测试ShopBrandMapper中的修改品牌功能   updateBrand()
	 */
	@Test
	public void updateBrand() {
		shopBrand.setBrandId(17);
		shopBrand.setBrandName("耐克");
		shopBrand.setUpdatedTime(new Date());
		Integer result=shopBrandMapper.updateBrand(shopBrand);
		System.out.println(result);
	}
	/**
	 * 测试ShopBrAandMapper中的删除品牌功能   deleteBrand()
	 */
	@Test
	public void deleteBrand() {
		Integer result=shopBrandMapper.deleteBrand(30);
		System.out.println(result);
	}
	
	/**
	 * 测试ShopGoodsCategoryMapper中的查询所有类目功能   findAll()
	 */
	@Test
	public void findAllCat() {
		Map<String, Object> map=new HashMap<>();
		map.put("catId", 21);
		List<ShopGoodsCategory> list=shopGoodsCategoryMapper.findAll(map);
		System.out.println(list);
	}
	/**
	 * 测试ShopGoodsCategoryMapper中的添加类目功能    addCategory()
	 */
	@Test
	public void addCateGory() {
		shopGoodsCategory.setCatName("床上用品");
		shopGoodsCategory.setIsDel(0);
		shopGoodsCategory.setCreatedTime(new Date());
		Integer result=shopGoodsCategoryMapper.addCategory(shopGoodsCategory);
		System.out.println(result);
	}
	/**
	 * 测试ShopGoodsCategoryMapper中的修改类目功能  updateCategory()
	 */
	@Test
	public void updateCateGory() {
		shopGoodsCategory.setCatId(24);
		shopGoodsCategory.setIsDel(1);
		shopGoodsCategory.setUpdatedTime(new Date());
		Integer result=shopGoodsCategoryMapper.updateCategory(shopGoodsCategory);
		System.out.println(result);
	}
	
	/**
	 * 测试ShopGoodsCategoryMapper中的删除类目功能  deleteCategory()
	 */
	@Test
	public void deleteCategory() {
		Integer result=shopGoodsCategoryMapper.deleteCategory(19);
		System.out.println(result);
	}
	
	
	/**
	 * 测试ShopGoodsContentMapper中的查询内容功能   findAll()
	 */
	@Test
	public void findAllContent() {
		Map<String, Object> map=new HashMap<>();
		map.put("goodsId",4);
		List<ShopGoodsContent> list=shopGoodsContentMapper.findAll(map);
		System.out.println(list);
	}
	/**
	 * 测试ShopGoodsContentMapper中的添加内容功能   addContent()
	 */
	@Test
	public void addContentTest() {
		shopGoodsContent.setGoodsId(27);
		shopGoodsContent.setContent("fuck you");
		shopGoodsContent.setCreatedTime(new Date());
		Integer result=shopGoodsContentMapper.addContent(shopGoodsContent);
		System.out.println(result);
	}
	/**
	 * 测试ShopGoodsContentMapper中的修改功能   updateContent()
	 */
	@Test
	public void updateContentTest() {
		shopGoodsContent.setGoodsId(28);
		shopGoodsContent.setContent("测试2");
		shopGoodsContent.setUpdatedTime(new Date());
		shopGoodsContentMapper.updateContent(shopGoodsContent);
	}
    /**
     * 测试ShopGoodsContentMapper中删除功能   deleteContent()
     */
	@Test
	public void deleteContentTest() {
		shopGoodsContentMapper.deleteContent(28);
	}
	
	
	/**
	 * 测试ShopGoodsImagesMapper中的查询功能   findAll()
	 */
	@Test
	public void findAllImages() {
		Map<String, Object> map=new HashMap<>();
		map.put("goodsId",28);
		List<ShopGoodsImages> list=shopGoodsImagesMapper.findAll(map);
		System.out.println(list);
	}
	/**
	 * 测试ShopGoodsImagesMapper中添加功能  addImages()
	 */
	@Test
	public void addImages()	{
		shopGoodsImages.setGoodsId(29);
		shopGoodsImages.setColorId(null);
		shopGoodsImages.setIsDefault(0);
		shopGoodsImagesMapper.addImages(shopGoodsImages);
	}
	/**
	 * 测试ShopGoodsImagesMapper中修改功能   updateImages()
	 */
	@Test
	public void updateImages() {
		shopGoodsImages.setGoodsId(29);
		shopGoodsImages.setGoodsImage("3");
		shopGoodsImagesMapper.updateImages(shopGoodsImages);
	}
	/**
	 * 测试ShopGoodsImagesMapper中删除功能   deleteImages()
	 */
	@Test
	public void deleteImages() {
		shopGoodsImagesMapper.deleteImages(29);
	}
	
	
	/**
	 * 测试ShopGoodsAttrMapper中的查询功能   findAttr();
	 */
	@Test
	public void findAllAttr() {
		Map<String, Object> map=new HashMap<>();
		map.put("goodsId", 25);
		List<ShopGoodsAttr> list=shopGoodsAttrMapper.findAll(map);
		System.out.println(list);
	}
	/**
	 *  测试ShopGoodsAttrMapper中的添加功能   addAttr()
	 */
	@Test
	public void addAttrTest() {
		shopGoodsAttr.setGoodsId(30);
		shopGoodsAttr.setCreatedTime(new Date());
		shopGoodsAttr.setIsDel(0);
		shopGoodsAttrMapper.addAttr(shopGoodsAttr);
	}
	/**
	 * 测试ShopGoodsAttrMapper中的修改功能   updateAttr()
	 */
	@Test
	public void updateAttrTest() {
		shopGoodsAttr.setGoodsId(29);
		shopGoodsAttr.setUpdatedTiime(new Date());
		shopGoodsAttrMapper.updateAttr(shopGoodsAttr);
	}
	/**
	 *  测试ShopGoodsAttrMapper中的删除功能   deleteAttr()
	 */
	@Test
	public void deleteAttrTest() {
		shopGoodsAttrMapper.deleteAttr(30);
	}
	/**
	 * 测试ShopFrontCategoryMapper中的查询功能  findAll()
	 */
	@Test
	public void findFrontCat() {
		Map<String, Object> map=new HashMap<>();
		List<ShopFrontCategory> list=shopFrontCategoryMapper.findAll(map);
		System.out.println(list);
	}
	/**
	 * 测试ShopFrontCategoryMapper中的删除功能  deleteFrontCat()
	 */
	@Test
	public void deleteFrontCat() {
		shopFrontCategoryMapper.deleteFrontCat(10);
	}
	/**
	 * 测试ShopFrontCategoryMapper中的添加功能  addFrontCat()
	 */
	@Test
	public void addFrontCat() {
		shopFrontCategory.setCatId(12);
		shopFrontCategory.setCatName("电疗");
		shopFrontCategoryMapper.addFrontCat(shopFrontCategory);
	}
	/**
	 * 测试ShopFrontCategoryMapper中的修改功能  addFrontCat()
	 */
	@Test
	public void updateFrontCat() {
		shopFrontCategory.setCatId(12);
		shopFrontCategory.setCatName("杨永信");
		shopFrontCategoryMapper.updateFrontCat(shopFrontCategory);
	}
}
