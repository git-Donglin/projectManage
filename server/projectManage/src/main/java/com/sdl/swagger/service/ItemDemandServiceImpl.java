package com.sdl.swagger.service;

import com.sdl.swagger.dao.ItemDemandDao;
import com.sdl.swagger.entity.ItemDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sundonglin
 * @date 2019/9/3 14:47
 */
@Service
public class ItemDemandServiceImpl implements ItemDemandService {

    @Autowired
    private ItemDemandDao itemDemandDao;

    @Override
    public void putItemDemand(ItemDemand itemDemand) {
        itemDemandDao.updateItemDemand(itemDemand);
    }

    @Override
    public ItemDemand getItemDemandByMoid(String moid) {
        return itemDemandDao.getItemDemandByMoid(moid);
    }

    @Override
    public List<ItemDemand> listItemDemandByItemMoid(String itemMoid) {
        return itemDemandDao.listItemDemandByItemMoid(itemMoid);
    }

    @Override
    public void saveItemDemand(ItemDemand itemDemand) {
        itemDemandDao.saveItemDemand(itemDemand);
    }
}
