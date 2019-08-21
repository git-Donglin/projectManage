/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:24:21
 */
package com.sdl.swagger.service;

import java.util.List;

import com.sdl.swagger.entity.Item;
import com.sdl.swagger.exception.BusinessException;


/**
 * 项目Service
 * @author sundonglin
 * @date 2018年9月27日 下午3:24:21
 */
public interface ItemService {

	/**
	 * 获取所有项目信息
	 * @return
	 */
	public List<Item> queryAll();
	
	/**
	 * 根据项目Id获取项目信息
	 * @param key：项目Id
	 * @return
	 */
	public Item getItemById(String moid);
	
	/**
	 * 新增项目信息
	 * @param detail:项目信息
	 * @throws BusinessException 
	 */
	public void saveItem(Item item) throws BusinessException;
	
	/**
	 * 根据项目Id删除项目信息
	 * @param key:项目Id
	 * @throws BusinessException 
	 */
	public void delItem(String moid) throws BusinessException;
	
	/**
	 * 修改项目信息
	 * @param key:项目Id
	 * @param detail：项目信息
	 * @throws BusinessException
	 */
	public void updateItem(Item item) throws BusinessException;
}
