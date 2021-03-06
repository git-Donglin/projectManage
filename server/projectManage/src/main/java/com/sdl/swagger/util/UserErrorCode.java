package com.sdl.swagger.util;

/**
 * @author sundonglin
 * @date 2019/10/28 11:17
 */
public enum  UserErrorCode {

    USERNULL("U0001", "用户不存在");


    private String code;
    private String name;
    private UserErrorCode(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
