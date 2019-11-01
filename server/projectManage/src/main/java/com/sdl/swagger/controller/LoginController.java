package com.sdl.swagger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdl.swagger.config.PropertiesConfig;
import com.sdl.swagger.entity.User;
import com.sdl.swagger.exception.BusinessException;
import com.sdl.swagger.meeting.entity.EmployeeDepartment;
import com.sdl.swagger.meeting.entity.UserVO;
import com.sdl.swagger.service.UserService;
import com.sdl.swagger.util.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import com.thoughtworks.xstream.XStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author sundonglin
 * @date 2019/10/24 10:00
 */
@Api(value = "登录服务", tags = { "用户登录接口"})
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    public static final Map<String, String> userMap = new HashMap<String,String>();

    @ApiOperation(value = "登录", tags = {"用户登录接口"})
    @ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
            @ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
            @ApiResponse(code = 404, message = "无效的请求路径") })
    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response, String account, String password) {
        AjaxMessage<String> message = new AjaxMessage<String>(Boolean.TRUE, "");

        try {
            User user = userService.getUserById(account);
            if(null == user){
                userService.login(account, password);
            }
            if(user.getPassword().equals(DigestUtils.md5Hex(password))){
                message.setDescription("登录成功");
            }

        } catch (BusinessException e){
            if(e.getCode().equals(UserErrorCode.USERNULL.getCode())){
                try {
                    userService.login(account, password);
                } catch (BusinessException e1){
                    message.setDescription(e1.getMessage());
                }
            }
        }
        Cookie namecookie = new Cookie("SSO_COOKIE_KEY",UUID.randomUUID().toString());
        namecookie.setMaxAge(60*60*24*30);
        namecookie.setPath("/");
        namecookie.setSecure(false);
        Cookie mouseCookie = new Cookie("mouse", "leishe");
        mouseCookie.setMaxAge(60*60*24*30);//如果不设置使用时间，那么将取不到Cookie的值
        Cookie cookie = new Cookie("testCookie", "test");
        cookie.setDomain("test.com");
        cookie.setPath("/");
        cookie.setMaxAge(36000);
        response.addCookie(cookie);
        response.addCookie(namecookie);
        response.addCookie(mouseCookie);
        //message.setData(PropertiesConfig.userCookieMap.get(account).split("SSO_COOKIE_KEY=")[1].split(";")[0]);
        message.setData(UUID.randomUUID().toString());
        ResponseResult.makeResult(response,message);
    }
}
