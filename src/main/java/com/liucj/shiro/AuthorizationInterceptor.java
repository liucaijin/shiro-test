package com.liucj.shiro;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.liucj.shiro.common.JsonUtil;
import com.liucj.shiro.common.SystemConstants;
import com.liucj.shiro.http.ResponseObj;
import com.liucj.shiro.redis.MockRedis;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter{
	
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		int a = 1/0; 
		String token = request.getHeader(SystemConstants.TOKEN_HEADER);
		if(token == null){
			out(response, 1, "登录失败");
			return false;
		}
		String user = MockRedis.getKey(token);
		if(user == null){
			out(response, 1, "登录失败");
			return false;
		}
		return true;
	}
	
	
	private void out(HttpServletResponse response, int code, String msg) throws IOException{
		ResponseObj obj = new ResponseObj();
		obj.setStatus(code);
		obj.setMessage(msg);
		
		String json = JsonUtil.jsonObj2Sting(obj);
		response.setHeader("content-type", "application/json");
		 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;text/html;charset=utf-8");
		
		response.getWriter().print(json);
		response.getWriter().flush();
	}
}
