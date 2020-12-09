package com.example.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.example.sharding.mapper")
@SpringBootApplication
public class SpringbootShardingJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootShardingJdbcApplication.class, args);
	}

}
