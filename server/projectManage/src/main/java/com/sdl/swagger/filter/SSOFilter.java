package com.sdl.swagger.filter;

import com.sdl.swagger.exception.BusinessException;
import com.sdl.swagger.service.SSOService;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sundonglin
 * @date 2019/10/30 10:54
 */

/*@WebFilter(filterName="/CodeFilter",urlPatterns="/*"
        ,initParams={@WebInitParam(name ="EXCLUDED_PAGES" , value = "/login")})
@Configuration*/
public class SSOFilter implements Filter {

    @Autowired
    private SSOService ssoService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String ssoToken = null;
        Cookie cookie = getCookie(httpRequest);
        if (cookie != null) {
            ssoToken = cookie.getValue();
        }
        if(null == ssoToken){
        }
        try {
            ssoService.validationToken(ssoToken);
            chain.doFilter(httpRequest, response);
        } catch (BusinessException e){
            e.printStackTrace();
            httpRequest.getRequestDispatcher("/login").forward(request,response);//跳转自己指定的url
        }

    }

    public static Cookie getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (ArrayUtils.isEmpty(cookies)) {
            return null;
        }
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if ("SSO_COOKIE_KEY".equals(c.getName())) {
                cookie = c;
                break;
            }
        }
        return cookie;
    }

    @Override
    public void destroy() {

    }
}
