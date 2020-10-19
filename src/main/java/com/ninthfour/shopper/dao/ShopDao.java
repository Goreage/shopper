package com.ninthfour.shopper.dao;

import com.ninthfour.shopper.entity.Shop;

public interface ShopDao {
	/*
	 * 1即为成功， -1即为失败（mybits传的值）
	 */
	int insertShop(Shop shop);
}
