package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages= {"com.example.**"})
public class MyCode2Application {

	public static void main(String[] args) {
		SpringApplication.run(MyCode2Application.class, args);
	}
}
