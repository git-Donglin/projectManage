/**
 * @author sundonglin
 * @date 2018年9月27日 下午4:47:32
 */
package com.sdl.swagger.service;

import java.util.List;

import com.sdl.swagger.entity.Dept;
import com.sdl.swagger.exception.BusinessException;

/**
 * @author sundonglin
 * @date 2018年9月27日 下午4:47:32
 */
public interface DeptService {
	
	/**
	 * 获取所有的部门信息
	 * @return
	 */
	public List<Dept> getAllDept();
	
	
	/**
	 * 新增部门信息
	 * @param dept
	 */
	public void saveDept(Dept dept);
	
	/**
	 * 修改部门信息
	 * @param dept
	 * @throws BusinessException 
	 */
	public void putDept(int index, Dept dept) throws BusinessException;

}
