package net.ioage.vegetable;

import net.ioage.vegetable.modules.gather.service.GatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VegetableApplicationTests {

	@Resource
	GatherService gatherService;

	@Test
	public void contextLoads() {
		gatherService.test();
	}

}
