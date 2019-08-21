/**
 * @author sundonglin
 * @date 2018年9月20日 下午1:40:20
 */
package com.sdl.swagger.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;

/**
 * @author sundonglin
 * @date 2018年9月20日 下午1:40:20
 */
public class ResponseResult {
	
	

	public static void makeResult(HttpServletResponse response, Object object) {
		
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			
			response.getWriter().append(JSON.toJSONString(object));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
