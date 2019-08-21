/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:12:06
 */
package com.sdl.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sdl.swagger.entity.Item;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:12:06
 */
@Api(value = "项目服务", tags = {"项目服务接口"})
@RequestMapping("/itemApi")
public interface ItemApi {
	

	@ApiOperation(value = "获取所有的项目信息", tags = {"项目接口"})
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@GetMapping("/queryAll")
	public ResponseEntity<List<Item>> queryAll();
	
	
	@ApiOperation("根据项目Id获取项目信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@GetMapping("/getItemById/{moid}")
	public ResponseEntity<Item> getItemById(
			@ApiParam(value = "项目moid", required = true) @PathVariable("moid") String moid);

	
	@ApiOperation("根据项目名和密码获取项目信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@PostMapping("/saveItem")
	public ResponseEntity<Void> saveItem(HttpServletResponse response,
			@ApiParam(value = "项目信息") @RequestBody Item item);

	
	@ApiOperation("删除项目信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@DeleteMapping("/delItem/{moid}")
	public ResponseEntity<Void> delItem(
			@ApiParam(value = "moid", required = true) @RequestParam("moid") String moid);
	

	@ApiOperation("修改项目信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@PutMapping("/putItem")
	public ResponseEntity<Void> updateItem(HttpServletResponse response, @ApiParam(value = "项目信息") @RequestBody Item item);
	
}
