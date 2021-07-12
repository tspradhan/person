package com.marsindia.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author tumbeswar
 *
 */
@SpringBootApplication
@EnableSwagger2
public class SpringBootTestWithH2DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestWithH2DatabaseApplication.class, args);
	}

}
