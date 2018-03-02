package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DBSessionConfig {

	@Bean(name="db1SqlSessionFactoryBean")
	@Autowired
	public SqlSessionFactory sqlSessionFactoryBean1(@Qualifier("db1Datasource")DataSource db1Datasource) throws Exception{
		SqlSessionFactoryBean s=new SqlSessionFactoryBean();
		s.setDataSource(db1Datasource);
		return s.getObject();
	}
	@Bean(name = "db1SqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactoryBean")SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	
	@Bean(name="db2SqlSessionFactoryBean")
	@Autowired
	public SqlSessionFactory sqlSessionFactoryBean2(@Qualifier("db2Datasource")DataSource db2Datasource) throws Exception{
		SqlSessionFactoryBean s=new SqlSessionFactoryBean();
		s.setDataSource(db2Datasource);
		return s.getObject();
	}
	
	@Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate db2SqlSessionTemplate(@Qualifier("db2SqlSessionFactoryBean")SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
