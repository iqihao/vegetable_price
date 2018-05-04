package net.ioage.vegetable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("net.ioage.vegetable.core.orm.mapper")
public class VegetableApplication {

	public static void main(String[] args) {
		SpringApplication.run(VegetableApplication.class, args);
	}
}
