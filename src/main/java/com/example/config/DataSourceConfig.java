package com.example.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

@Configuration
public class DataSourceConfig {
	
	@Bean(name="db1Datasource")
	@Primary
	@Autowired
	public DataSource getDB1DataSource(Environment env) {
		AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
		Properties p=build(env, "spring.datasource.db1.");
		ds.setXaDataSourceClassName(MysqlXADataSource.class.getName());
		ds.setXaProperties(p);
		ds.setPoolSize(5);
		ds.setUniqueResourceName("db1");
		return ds;
	}

	@Bean(name="db2Datasource")
	@Autowired
	public DataSource getDB2DataSource(Environment env) {
		AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
		Properties p=build(env, "spring.datasource.db2.");
		ds.setXaDataSourceClassName(MysqlXADataSource.class.getName());
		ds.setXaProperties(p);
		ds.setPoolSize(5);
		ds.setUniqueResourceName("db2");
		return ds;
	}
	
	 private Properties build(Environment env, String prefix) {
	        Properties prop = new Properties();
	        prop.put("url", env.getProperty(prefix + "url"));
	        prop.put("user", env.getProperty(prefix + "username"));
	        prop.put("password", env.getProperty(prefix + "password"));
	        return prop;
	    }
}
