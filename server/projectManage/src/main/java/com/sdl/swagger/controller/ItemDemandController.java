package com.sdl.swagger.controller;

import com.sdl.swagger.entity.Item;
import com.sdl.swagger.entity.ItemDemand;
import com.sdl.swagger.service.ItemDemandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sdl.swagger.api.ItemDemandApi;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author sundonglin
 * @date 2019/9/3 14:54
 */
@RestController
public class ItemDemandController implements ItemDemandApi{
    @Autowired
    private ItemDemandService itemDemandService;

    @Override
    public ResponseEntity<Void> saveItemDemand(@RequestBody ItemDemand itemDemand) {
        if(StringUtils.isNotBlank(itemDemand.getMoid())){
            itemDemandService.putItemDemand(itemDemand);
        }else{
            itemDemandService.saveItemDemand(itemDemand);
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteItemDemand(@PathVariable("demandMoid") String demandMoid) {
        itemDemandService.deleteItemDemand(demandMoid);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ItemDemand>> listItemDemandByMoid(@PathVariable("itemMoid") String itemMoid){
        List<ItemDemand> list = itemDemandService.listItemDemandByItemMoid(itemMoid);
        return new ResponseEntity<List<ItemDemand>>(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ItemDemand> getItemDemandByMoid(@PathVariable("demandMoid") String demandMoid) {
        ItemDemand itemDemand = new ItemDemand();
        itemDemand = itemDemandService.getItemDemandByMoid(demandMoid);
        return new ResponseEntity<ItemDemand>(itemDemand, HttpStatus.OK);
    }
}
