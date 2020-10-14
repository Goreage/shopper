package com.nithfour.shopper.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninthfour.shopper.dao.AreaDao;
import com.ninthfour.shopper.entity.Area;
import com.nithfour.shopper.BaseTest;

public class AreaDaoTest extends BaseTest{
	
	@Autowired
	AreaDao areaDao;
	
	@Test
	public void testQueryArea() {
		List<Area> areaList = areaDao.queryArea();
		
		assertEquals(2, areaList.size());
		
		System.out.println(areaList.get(0));
		
		
	}
}
