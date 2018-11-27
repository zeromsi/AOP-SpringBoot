package com.msi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msi.controller.specification.iDemoController;
import com.msi.service.demoService;

@CrossOrigin
@RestController
@RequestMapping("msg")
public class demoController implements iDemoController{
	@Autowired
	demoService demoService;

	@Override
	@GetMapping("{name}")
	public String getName(@PathVariable("name") Object name) {
		return (String) demoService.getMessage(name);
	}	
	
	@Override
	@GetMapping("")
	public String message() {
		return (String) demoService.message();
	}	
	
}
