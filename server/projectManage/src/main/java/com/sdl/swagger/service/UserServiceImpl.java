/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:26:13
 */
package com.sdl.swagger.service;

import com.alibaba.fastjson.JSONObject;
import com.sdl.swagger.config.PropertiesConfig;
import com.sdl.swagger.dao.UserDao;
import com.sdl.swagger.entity.User;
import com.sdl.swagger.entity.UserDetail;
import com.sdl.swagger.exception.BusinessException;
import com.sdl.swagger.meeting.entity.EmployeeDepartment;
import com.sdl.swagger.meeting.entity.UserVO;
import com.sdl.swagger.util.HttpClientUtils;
import com.sdl.swagger.util.UserErrorCode;
import com.sdl.swagger.util.XmlUtil;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:26:13
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

   public static Map<String, UserDetail> userMap = new HashMap<String, UserDetail>();
	private static Integer userId = 4;
	static {
		userMap.put("s1", new UserDetail(1, "admin1", "123", "123456", "宝山", "13565656326", "111@qq.com", "2018-11-11", "web","s1"));
		userMap.put("s2", new UserDetail(2, "admin2", "123", "123456", "徐汇", "13465654565", "222@qq.com", "2018-11-12", "平台","s2"));
		userMap.put("s3", new UserDetail(3, "admin3", "123", "123456", "长宁", "17612458548", "333@qq.com", "2018-11-13", "视讯","s3"));
		userMap.put("s4", new UserDetail(4, "admin4", "123", "123456", "松江", "18132256545", "444@qq.com", "2018-11-14", "测试","s4"));
		userMap.put("s5", new UserDetail(5, "孙东林", "123", "123456", "松江", "18132256545", "444@qq.com", "2018-11-14", "测试","s5"));
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
	public void login(String account, String password) throws BusinessException {
		try {
			String result = HttpClientUtils.doGet(PropertiesConfig.TOACCOUNTTOKEN);
			String accountToken = XmlUtil.getContentFromXml(result, "accountToken", 0);
			PropertiesConfig.ACCOUNT_TOKEN = accountToken;
			System.out.println(accountToken);
			Map<String, String> map = new HashMap<String, String>();
			map.put("account_token", accountToken);
			map.put("username",
					account);
			map.put("password", password);
			result = HttpClientUtils.login(PropertiesConfig.LOGIN, map, account);
			if (result.indexOf("errorCode") != -1) {
				System.out.println("错误的接口返回的xml===" + result);
				throw new BusinessException();
			} else {
				System.out.println("接口返回的xml===" + result);
			}
			map.clear();
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("account_token", accountToken);
			paramMap.put("username", account);
			result = HttpClientUtils.doPost(PropertiesConfig.GETACCOUNTS, paramMap, PropertiesConfig.userCookieMap.get(account));
			if (result.indexOf("errorCode") != -1) {
				System.out.println("错误的接口返回的xml===" + result);
				throw new BusinessException();
			} else {
				System.out.println("接口返回的xml===" + result);
			}
			XStream xStream = new XStream();
			if (result != null && result.indexOf("user") > -1) {
				xStream.alias("user", UserVO.class);
				xStream.alias("dept", EmployeeDepartment.class);
				xStream.alias("depts", List.class);
				UserVO userVO = (UserVO) xStream.fromXML(result);
				userVO.setPassword(DigestUtils.md5Hex(password));
				this.saveUser(User.toUser(userVO));
				System.out.println(JSONObject.toJSON(userVO).toString());
			}
		} catch (Exception e){

		}
	}

	@Override
	public User getUserById(String account) throws BusinessException{
		User userByAccount = null;
		try {

			userByAccount = userDao.getUserByAccount(account);
			if(null == userByAccount){
				throw new BusinessException(UserErrorCode.USERNULL.getCode(),UserErrorCode.USERNULL.getName());
			}
		} catch (DataAccessException e){
			throw new BusinessException(UserErrorCode.USERNULL.getCode(),UserErrorCode.USERNULL.getName());
		}
		return userByAccount;
	}

	@Override
	public void saveUser(User user) throws BusinessException {
		if(null != user) {
			try {
				userId++;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				user.setCreateTime(sdf.format(new Date()));
				user.setUserId(userId);
				userDao.insterUser(user);
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException("U0002", e.getMessage());
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
