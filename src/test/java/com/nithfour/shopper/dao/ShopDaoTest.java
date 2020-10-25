package com.nithfour.shopper.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninthfour.shopper.dao.ShopDao;
import com.ninthfour.shopper.entity.Area;
import com.ninthfour.shopper.entity.PersonInfo;
import com.ninthfour.shopper.entity.Shop;
import com.ninthfour.shopper.entity.ShopCategory;
import com.nithfour.shopper.BaseTest;


public class ShopDaoTest extends BaseTest{
	
	private static final Logger logger = LoggerFactory.getLogger(ShopDaoTest.class);
			
	@Autowired
	ShopDao shopDao;
	
	@Test
	public void testQueryArea() {
		Shop shop = new Shop();
		PersonInfo personInfo = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		
		personInfo.setUserId(1L);
		area.setAreaId(1);
		shopCategory.setShopCategoryId(1L);
		
		shop.setOwner(personInfo);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("小黑子炸鸡店");
		shop.setShopDesc("大份鸡胸肉");
		shop.setShopAddr("正大公园旁米处");
		shop.setPhone("12315");
		shop.setShopImg("xxxx/xxx");
		shop.setPriority(99);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("多放香菜");
		
		int effectNum = shopDao.insertShop(shop);
		
		Assert.assertEquals(effectNum, 1);
		logger.debug("insert successfully");
	}
}
