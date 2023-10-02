package com.henrik.javarestfulapiwithspringboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class JavaRestfulApiWithSpringboot2Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaRestfulApiWithSpringboot2Application.class, args);
	}

}
