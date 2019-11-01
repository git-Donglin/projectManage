/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:24:21
 */
package com.sdl.swagger.service;

import java.util.List;

import com.sdl.swagger.entity.User;
import com.sdl.swagger.entity.UserDetail;
import com.sdl.swagger.exception.BusinessException;


/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:24:21
 */
public interface UserService {

	/**
	 * 获取所有用户信息
	 * @return
	 */
	public List<UserDetail> queryAll();
	
	/**
	 * 根据用户Id获取用户信息
	 * @param account：用户Id
	 * @return
	 */
	public User getUserById(String account) throws BusinessException;
	
	/**
	 * 新增用户信息
	 * @param user:用户信息
	 * @throws BusinessException 
	 */
	public void saveUser(User user) throws BusinessException;
	
	/**
	 * 根据用户Id删除用户信息
	 * @param key:用户Id
	 * @throws BusinessException 
	 */
	public void delUser(String key) throws BusinessException;
	
	/**
	 * 修改用户信息
	 * @param key:用户Id
	 * @param detail：用户信息
	 * @throws BusinessException
	 */
	public void updateUser(String key, UserDetail detail) throws BusinessException;

	public void login(String account, String password) throws BusinessException;
}
