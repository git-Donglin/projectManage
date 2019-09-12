package com.sdl.swagger.api;

import com.sdl.swagger.entity.Function;
import com.sdl.swagger.entity.ItemDemand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author sundonglin
 * @date 2019/9/3 15:08
 */
@Api(value = "项目需求服务", tags = {"项目需求服务接口"})
@RequestMapping("/itemDemandApi")
public interface ItemDemandApi {

    @ApiOperation(value = "获取项目所有的需求信息", notes = "需求信息服务接口")
    @GetMapping("/listItemDemandByMoid/{itemMoid}")
    public ResponseEntity<List<ItemDemand>> listItemDemandByMoid(@PathVariable("itemMoid") String itemMoid);

    @ApiOperation(value = "添加需求信息", notes = "添加需求服务接口")
    @PostMapping("/saveItemDemand")
    public ResponseEntity<Void> saveItemDemand( @ApiParam(value = "需求信息") ItemDemand itemDemand);

    @ApiOperation(value = "获取单个需求信息", notes = "需求信息服务接口")
    @GetMapping("/getItemDemandByMoid/{moid}")
    public ResponseEntity<ItemDemand> getItemDemandByMoid(@PathVariable("moid") String moid);
}
