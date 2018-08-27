package com.liucj.shiro.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
	
	@GetMapping(value = "/test")
	public String test() throws Exception{
	throw 	new SQLException("测试拦截异常");
		 
	}
}
