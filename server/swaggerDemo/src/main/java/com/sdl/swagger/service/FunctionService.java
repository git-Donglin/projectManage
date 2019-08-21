/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:24:21
 */
package com.sdl.swagger.service;

import java.util.List;

import com.sdl.swagger.entity.Function;
import com.sdl.swagger.exception.BusinessException;


/**
 * 功能Service
 * @author sundonglin
 * @date 2018年9月27日 下午3:24:21
 */
public interface FunctionService {

	/**
	 * 获取所有功能信息
	 * @return
	 */
	public List<Function> queryAll();
	
	/**
	 * 根据功能Id获取功能信息
	 * @param key：功能Id
	 * @return
	 */
	public Function getFunctionById(String moid);
	
	/**
	 * 新增功能信息
	 * @param detail:功能信息
	 * @throws BusinessException 
	 */
	public void saveFunction(Function function) throws BusinessException;
	
	/**
	 * 根据功能Id删除功能信息
	 * @param key:功能Id
	 * @throws BusinessException 
	 */
	public void delFunction(String moid) throws BusinessException;
	
	/**
	 * 修改功能信息
	 * @param key:功能Id
	 * @param detail：功能信息
	 * @throws BusinessException
	 */
	public void updateFunction(Function function) throws BusinessException;
	
	/**
	 * 根据项目Moid获取功能信息
	 * @return
	 * @throws BusinessException
	 */
	public List<Function> getFunctionByItemMoid(String itemMoid) throws BusinessException;
}
