package com.liucj.shiro.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.liucj.shiro.http.ResponseObj;
import com.liucj.shiro.redis.MockRedis;

@RestController
@RequestMapping(value = "/accountLogin")
public class AccountLoginController {
	
	@PostMapping(value = "/login")
	public ResponseObj login(@RequestBody JSONObject json){
		String name = json.getString("name");
		String password = json.getString("password");
		String token = UUID.randomUUID().toString();
		MockRedis.setKey(token, name + " " + password);
		ResponseObj responseObj = new ResponseObj();
		Map<String,Object> map = new HashMap<>();
		responseObj.setStatus(0);
		responseObj.setMessage("当路成功");
		map.put("token", token);
		responseObj.setData(map);
		return responseObj;
	}
}
