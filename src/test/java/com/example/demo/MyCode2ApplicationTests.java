package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.app.MyCode2Application;
import com.example.entity.A;
import com.example.service.AtomikosTestService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MyCode2Application.class)
public class MyCode2ApplicationTests {
	@Autowired
	AtomikosTestService service;
	@Test
	public void mytest() {
		A a=new A();
		a.setNumb(10);
		service.a(a);
	}
}