package com.ninthfour.shopper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninthfour.shopper.dao.AreaDao;
import com.ninthfour.shopper.entity.Area;
import com.ninthfour.shopper.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	AreaDao areaDao;

	@Override
	public List<Area> getAreaList() {		
		return areaDao.queryArea();
	}
}
