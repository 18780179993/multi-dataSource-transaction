package com.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages="com.example.mapper",sqlSessionFactoryRef="db1SqlSessionFactoryBean",sqlSessionTemplateRef="db1SqlSessionTemplate")
@Configuration
public class MapperConfig1 {

}
