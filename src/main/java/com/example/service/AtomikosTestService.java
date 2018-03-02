package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.A;
import com.example.mapper.AMapper;
import com.example.mapper2.BMapper;

@Service
public class AtomikosTestService {
	@Autowired
	AMapper aMapper;
	@Autowired
	BMapper bMapper;
	
	@Transactional(value="springJTATransactionManager",rollbackFor=Exception.class)
	public void a(A a) {
		aMapper.insert(a);
		b(a);
		
	}
	
	@Transactional(value="springJTATransactionManager",rollbackFor=Exception.class)
	public void b(A a) {
		bMapper.insert(a);
		throw new RuntimeException();
	}

}
