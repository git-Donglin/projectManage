package com.sdl.swagger.service;

import com.sdl.swagger.entity.ItemDemand;

import java.util.List;

/**
 * @author sundonglin
 * @date 2019/9/3 14:47
 */
public interface ItemDemandService {

    /**
     * 根据项目moid获取需求
     * @param itemMoid
     * @return
     */
    public List<ItemDemand> listItemDemandByItemMoid(String itemMoid);

    public void saveItemDemand(ItemDemand itemDemand);

    public void putItemDemand(ItemDemand itemDemand);

    public ItemDemand getItemDemandByMoid(String moid);
}
