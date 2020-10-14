package com.ninthfour.shopper.web.superadimn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ninthfour.shopper.entity.Area;
import com.ninthfour.shopper.service.AreaService;
/**
 * 
 * @author 	Question1
 * JSON:JSON是当前行业内使用最为广泛的数据传输格式之一
 * JSON(JavaScript Object Notation, JS 对象标记) 是一种轻量级的数据交换格式,
 * 采用完全独立于编程语言的文本格式来存储和表示数据
 * JSON的优点：
	易于阅读和编写，也易于机器解析和生成
	JSON语法格式：
		方括号：保存数组
		花括号：保存对象
		逗号：分割数据
		键值对（key -- value）：标识对象
	其中，key必须为string类型，value可以是任何基本类型、对象或者数据
	所以，JSON的数据结构有：
		Object   ---   对象
		Array     ---   数组
		string、number、true、false、null     ---   基本数据类型
 *
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {
	
	@Autowired
	AreaService areaService;
	
	@RequestMapping(value = "/listArea", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAreas(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Area> areaList = new ArrayList<Area>();
		try {
			areaList = areaService.getAreaList();
			map.put("total", areaList.size());
			map.put("rows", areaList);
			
			for(Area area : areaList) {
				System.out.println("区域:" + area);
			}
		}catch(Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("errMsg", e.getMessage().toString());
		}
		return map;
	}
}
