/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:26:13
 */
package com.sdl.swagger.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sdl.swagger.entity.UserDetail;
import com.sdl.swagger.exception.BusinessException;

/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:26:13
 */

@Service
public class UserServiceImpl implements UserService {
	
	private static Map<String, UserDetail> userMap = new HashMap<String, UserDetail>();
	private static Integer userId = 4;
	static {
		userMap.put("1", new UserDetail(1, "admin1", "123", "123456", "宝山", "13565656326", "111@qq.com", "2018-11-11", "web"));
		userMap.put("2", new UserDetail(2, "admin2", "123", "123456", "徐汇", "13465654565", "222@qq.com", "2018-11-12", "平台"));
		userMap.put("3", new UserDetail(3, "admin3", "123", "123456", "长宁", "17612458548", "333@qq.com", "2018-11-13", "视讯"));
		userMap.put("4", new UserDetail(4, "admin4", "123", "123456", "松江", "18132256545", "444@qq.com", "2018-11-14", "测试"));
	}

	@Override
	public List<UserDetail> queryAll() {
		
		List<UserDetail> list = new ArrayList<UserDetail>();
		for (Object obj : userMap.keySet()) {
			list.add(userMap.get(obj));
		}
		return list;
	}

	@Override
	public UserDetail getUserById(String key) {
		
		return userMap.get(key);
	}

	@Override
	public void saveUser(UserDetail detail) throws BusinessException {
		if(null != detail) {
			try {
				userId++;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				detail.setCreate(sdf.format(new Date()));
				detail.setUserId(userId);
				userMap.put(userId.toString(), detail);
			} catch (Exception e) {
				
				throw new BusinessException("4100", "您修改的用户不存在！！！");
			}
			
		}
	}

	@Override
	public void delUser(String key) throws BusinessException {
		
		try {
			
			userMap.remove(key);
		} catch (Exception e) {
			throw new BusinessException("4100", "删除失败！！！");
		}
	}

	@Override
	public void updateUser(String key, UserDetail detail) throws BusinessException {
		
		UserDetail userDetail = userMap.get(key);
		if(null != userDetail) {
			userMap.put(key, detail.updateNullFromBean(userDetail));
		}else {
			
			throw new BusinessException("4100", "您修改的用户不存在！！！");
		}

	}
}
