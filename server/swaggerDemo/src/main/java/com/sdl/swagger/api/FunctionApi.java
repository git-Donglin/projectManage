/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:12:06
 */
package com.sdl.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sdl.swagger.entity.Function;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:12:06
 */
@Api(value = "功能服务", tags = {"功能服务接口"})
@RequestMapping("/functionApi")
public interface FunctionApi {
	

	@ApiOperation(value = "获取所有的功能信息", tags = {"功能接口"})
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@GetMapping("/queryAll")
	public ResponseEntity<List<Function>> queryAll();
	
	
	@ApiOperation("根据功能Id获取功能信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@GetMapping("/getFunctionById/{moid}")
	public ResponseEntity<Function> getFunctionById(
			@ApiParam(value = "功能moid", required = true) @PathVariable("moid") String moid);

	
	@ApiOperation("根据功能名和密码获取功能信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@PostMapping("/saveFunction")
	public ResponseEntity<Void> saveFunction(HttpServletResponse response,
			@ApiParam(value = "功能信息") @RequestBody Function function);

	
	@ApiOperation("删除功能信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@DeleteMapping("/delFunction/{moid}")
	public ResponseEntity<Void> delFunction(
			@ApiParam(value = "moid", required = true) @RequestParam("moid") String moid);
	

	@ApiOperation("修改功能信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@PutMapping("/putFunction")
	public ResponseEntity<Void> updateFunction(HttpServletResponse response,
			@ApiParam(value = "功能信息") @RequestBody Function function);
	
	@ApiOperation("修改功能信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@GetMapping("/getFunctionByItemMoid/{moid}")
	public ResponseEntity<List<Function>> getFunctionByItemMoid(HttpServletResponse response,
			@ApiParam(value = "moid", required = true) @RequestParam("moid") String moid);
	
}
