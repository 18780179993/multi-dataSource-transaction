package com.example.config;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class TransactionConfig {

	@Bean(name="userTransactionManager")
	public UserTransactionManager userTransactionManager() {
		UserTransactionManager tm=new UserTransactionManager();
		tm.setForceShutdown(true);
		return tm;
	}
	
	@Bean(name="userTransactionImp")
	public UserTransactionImp userTransactionImp() {
		UserTransactionImp uti=new UserTransactionImp();
		try {
			uti.setTransactionTimeout(300);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return uti;
	}
	
	@Bean(name="springJTATransactionManager")
	@Autowired
	public JtaTransactionManager jtaTransactionManager(UserTransactionManager utm,UserTransactionImp ut) {
		JtaTransactionManager jta=new JtaTransactionManager(ut, utm);
		return jta;
	}
}
