/**
 * @author sundonglin
 * @date 2018年9月27日 下午4:47:51
 */
package com.sdl.swagger.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sdl.swagger.entity.Dept;
import com.sdl.swagger.entity.User;
import com.sdl.swagger.exception.BusinessException;

/**
 * @author sundonglin
 * @date 2018年9月27日 下午4:47:51
 */
@Service
public class DeptServiceImpl implements DeptService {
	
	private static List<Dept> depeList = new ArrayList<Dept>();
	private static Integer num = 4;
	static {
		depeList.add(new Dept(1, "web"));
		depeList.add(new Dept(2, "平台"));
		depeList.add(new Dept(3, "视讯"));
		depeList.add(new Dept(4, "测试"));
		
	}
	
	public List<Dept> getAllDept(){
		
		return depeList;
	}
	
	public void saveDept(Dept dept) {
		num++;
		dept.setId(num);
		depeList.add(dept);
	}

	@Override
	public void putDept(int index, Dept dept) throws BusinessException {
		
		Dept getDept = depeList.get(index);
		if(null == getDept) {
			getDept.toDept(dept);
			depeList.add(getDept);
		}else {
			
			throw new BusinessException("4100", "该部门不存在！");
		}
	}
}
