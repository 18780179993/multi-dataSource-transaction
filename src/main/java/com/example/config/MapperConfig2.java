package com.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages="com.example.mapper2",sqlSessionFactoryRef="db2SqlSessionFactoryBean",sqlSessionTemplateRef="db2SqlSessionTemplate")
@Configuration
public class MapperConfig2 {

}
