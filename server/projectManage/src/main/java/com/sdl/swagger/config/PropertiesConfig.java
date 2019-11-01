package com.sdl.swagger.config;

import com.sdl.swagger.entity.UserDetail;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sundonglin
 * @date 2019/10/24 10:04
 */
public class PropertiesConfig {

    public static final  String APPID = "TrueLink";
    public static final String SERCRET = "12345678";
    public static final String TOACCOUNTTOKEN = "http://10.23.46.39/api5/accountToken?oauth_consumer_key=TrueLink&oauth_consumer_secret=12345678";
    public static final String LOGIN = "http://10.23.46.39/api5/login";
    public static final String GETACCOUNTS = "http://10.23.46.39/api5/ams/getAccountInfo";

    public static final String VALIDATIONTOKEN = "http://10.23.46.39/api5/sso/validationToken";

    public static final Map<String, String> userCookieMap = new HashMap<String,String>();

    public static String ACCOUNT_TOKEN = "";
}
