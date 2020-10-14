package com.nithfour.shopper.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninthfour.shopper.entity.Area;
import com.ninthfour.shopper.service.AreaService;
import com.nithfour.shopper.BaseTest;

/**
 * 在这个结构中，control不直接和DAO联系， 需要操作数据的时候，通过service层访问DAO层来实现。
 * service层做的事情，不仅仅是调用DAO操作数据，还会包含了一定的业务逻辑。整个程序的设计，也变成了针对服务进行设计。 这样做的好处是： 1
 * control层中的action得以精简，因为action中的一些逻辑，被重构成一个个的服务。而不同的action也可以重用服务了。
 * 
 * 2
 * 只负责和数据打交道的DAO层，相比之前的model层，也得以精简（DAO层尽量只做最原子的数据操作，不同数据操作之间的联系，这边不考虑，那是service层的事情）。
 * 
 * 3 service层可以实现很大程度上的代码复用，程序的功能封装更清晰了。
 * 
 * 4
 * 由于service层更加清晰的定义了应用程序的边界，那么对于各个service函数（对应某个服务/应用），要做到自动化测试就方便多了。WEB程序如何做到能方便的进行单元测试，这是一直困扰我的难题，这样的设计似乎真的可行了~
 * 
 * 5 开发人员的工作分配，理论上真的可以按层次划分了。只是理论上~ 同时，这样的设计模式也是存在一定的缺点的：
 * 层次太多，刚接触的开发人员理解起来比简单的mvc结构费时；
 * service层的设计需要一定的功力，因为action中和model层的逻辑在很大程度上转移到这里了。 但整体上看，service
 * Layer的引入，更加清晰的定义了应用程序的边界，提供了一系列可以重用的操作集合。这对于网站的可扩展性和可维护性是非常有帮助的。
 * 当然，如果网站的业务逻辑并不复杂，完全没必要用这样的设计。过度设计是万恶之源~
 * 
 * @author Administrator
 *
 */

public class AreaServiceTest extends BaseTest {
	@Autowired
	AreaService areaService;

	@Test
	public void testGetAreaList() {
		List<Area> areaList = areaService.getAreaList();
		Assert.assertEquals("南门", areaList.get(0).getAreaName());
	}
}
