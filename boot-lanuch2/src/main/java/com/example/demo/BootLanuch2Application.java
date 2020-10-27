package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.demo.generator.testdb")
public class BootLanuch2Application {

	public static void main(String[] args) {
		SpringApplication.run(BootLanuch2Application.class, args);
	}

}
