package com.apirest.demo.Practice;

import com.apirest.demo.Practice.entity.ArticuloEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		ArticuloEntity art = new ArticuloEntity();
	}

}
