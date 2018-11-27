package com.msi.service;

import org.springframework.stereotype.Service;

import com.msi.service.specification.iDemoService;

@Service
public class demoService implements iDemoService{

	@Override
	public Object getMessage(Object object) {
		return "This is "+object;
	}

	@Override
	public Object message() {
		return "Hello From AOP practice Session";
	}


}
