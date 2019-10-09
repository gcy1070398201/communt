package com.exampl.communt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = "com.exampl.communt.mapper")
public class CommuntApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommuntApplication.class, args);
	}

}
