/**
 * @author sundonglin
 * @date 2019年6月10日 下午2:46:59
 */
package com.sdl.swagger.service;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdl.swagger.dao.FunctionDao;
import com.sdl.swagger.entity.Function;
import com.sdl.swagger.exception.BusinessException;

/**
 * @author sundonglin
 * @date 2019年6月10日 下午2:46:59
 */
@Service
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	private FunctionDao FunctionDao;
	
	
	@Override
	public List<Function> queryAll() {
		List<Function> allFunction = FunctionDao.allFunction();
		return allFunction;
	}

	@Override
	public Function getFunctionById(String moid) {
		return FunctionDao.getFunctionById(moid);
	}

	@Override
	public void saveFunction(Function function) throws BusinessException {
		function.setMoid(UUID.randomUUID().toString());
		function.setCreateTime(new Date());
		FunctionDao.saveFunction(function);

	}

	@Override
	public void delFunction(String moid) throws BusinessException {
		FunctionDao.delFunction(moid);

	}

	@Override
	public void updateFunction(Function function) throws BusinessException {
		FunctionDao.updateFunction(function);

	}

	@Override
	public List<Function> getFunctionByItemMoid(String itemMoid) throws BusinessException {
		return FunctionDao.getFunctionByItemMoid(itemMoid);
	}

}
