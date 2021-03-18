package com.example.redishotspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author zhaojh0912
 */
@EnableCaching
@SpringBootApplication
public class SpringbootRedisHotspotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisHotspotApplication.class, args);
	}

}
