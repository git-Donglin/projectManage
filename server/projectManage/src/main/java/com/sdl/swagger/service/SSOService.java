package com.sdl.swagger.service;

import com.sdl.swagger.exception.BusinessException;

/**
 * @author sundonglin
 * @date 2019/10/29 19:55
 */
public interface SSOService {

    /**
     * 校验ssoToken
     * @param ssoToken
     */
    public void validationToken(String ssoToken) throws BusinessException;
}
