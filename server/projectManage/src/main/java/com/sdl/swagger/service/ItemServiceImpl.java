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
import com.sdl.swagger.dao.ItemDao;
import com.sdl.swagger.entity.Function;
import com.sdl.swagger.entity.Item;
import com.sdl.swagger.exception.BusinessException;

/**
 * @author sundonglin
 * @date 2019年6月10日 下午2:46:59
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao ItemDao;
	@Autowired
	private FunctionDao functionDao;
	
	
	@Override
	public List<Item> queryAll() {
		List<Item> allItem = ItemDao.allItem();
		return allItem;
	}

	@Override
	public Item getItemById(String moid) {
		return ItemDao.getItemById(moid);
	}

	@Override
	public void saveItem(Item item) throws BusinessException {
		item.setMoid(UUID.randomUUID().toString());
		item.setCreateTime(new Date());
		ItemDao.saveItem(item);

	}

	@Override
	public void delItem(String moid) throws BusinessException {
		ItemDao.delItem(moid);
	}

	@Override
	public void updateItem(Item item) throws BusinessException {
		ItemDao.updateItem(item);
	}

}
