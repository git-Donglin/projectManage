package com.sdl.swagger.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdl.swagger.config.PropertiesConfig;
import com.sdl.swagger.exception.BusinessException;
import com.sdl.swagger.util.HttpClientUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.net.BindException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sundonglin
 * @date 2019/10/29 20:00
 */
@Service
public class SSOServiceImpl implements SSOService {
    @Override
    public void validationToken(String ssoToken) throws BusinessException{
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("ssoToken", ssoToken);
        try{

            String result = HttpClientUtils.doPost(PropertiesConfig.VALIDATIONTOKEN, paramMap);
            Object code = JSON.parseObject(result).get("code");
            if(null != code && StringUtils.isNotBlank(code.toString())){
                if("100011".equals(code.toString())){
                    throw  new BusinessException("100011", JSON.parseObject(result).get("message").toString());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        //paramMap.put("username", account);
        //result = HttpClientUtils.doPost(PropertiesConfig.GETACCOUNTS, paramMap, PropertiesConfig.userCookieMap.get(account));
       // 100011

    }
}
