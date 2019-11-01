package com.sdl.swagger.service;

import com.sdl.swagger.dao.ItemDemandDao;
import com.sdl.swagger.entity.ItemDemand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public void deleteItemDemand(String itemDemandMoid) {
        itemDemandDao.delItemDemand(itemDemandMoid);
    }

    @Override
    public ItemDemand getItemDemandByMoid(String moid) {

        ItemDemand itemDemand = itemDemandDao.getItemDemandByMoid(moid);
        String userStr = "";
        if(StringUtils.isNotBlank(itemDemand.getPrincipal())){

            for (String s : itemDemand.getPrincipal().split(",")) {
                userStr +=  UserServiceImpl.userMap.get(s).getName();
            }
            itemDemand.setPrincipalStr(userStr.substring(0, userStr.length()-1));
        }

        return itemDemand;
    }

    @Override
    public List<ItemDemand> listItemDemandByItemMoid(String itemMoid) {
        return itemDemandDao.listItemDemandByItemMoid(itemMoid);
    }

    @Override
    public void saveItemDemand(ItemDemand itemDemand) {
        itemDemand.setMoid(UUID.randomUUID().toString());
        itemDemand.setCreateDate(new Date());
        itemDemandDao.saveItemDemand(itemDemand);
    }
}
