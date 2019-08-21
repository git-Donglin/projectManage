package com.sdl.swagger.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sdl.swagger.entity.UserDetail;
import com.sdl.swagger.exception.BusinessException;
import com.sdl.swagger.service.UserService;
import com.sdl.swagger.util.ResponseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "登录服务", tags = { "用户操作接口"})
@RestController
public class UserControlle {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "获取所有的用户信息", tags = {"用户接口"})
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@GetMapping("/queryAll")
	public ResponseEntity<List<UserDetail>> queryAll() {

		List<UserDetail> list = userService.queryAll();
		return new ResponseEntity<List<UserDetail>>(list, HttpStatus.OK);

	}

	@ApiOperation("根据用户Id获取用户信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@GetMapping("/getUserById/{Id}")
	public ResponseEntity<UserDetail> getUserById(
			@ApiParam(value = "用户Id", required = true) @PathVariable("Id") String id) {

		UserDetail data = userService.getUserById(id);
		return new ResponseEntity<UserDetail>(data, HttpStatus.OK);
	}

	@ApiOperation("根据用户名和密码获取用户信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@PostMapping("/saveUser")
	public ResponseEntity<Void> saveUser(HttpServletResponse response,
			@ApiParam(value = "用户信息") @RequestBody UserDetail detail) {

		try {
			userService.saveUser(detail);
		} catch (BusinessException e) {
			ResponseResult.makeResult(response, e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation("文件上传")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@PostMapping("/saveFile")
	public ResponseEntity<Void> importCustomer(HttpServletResponse response, @ApiParam(value = "文件") MultipartFile importFile) {

		String fileName = importFile.getOriginalFilename();
		ResponseResult.makeResult(response, fileName);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation("删除用户信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@DeleteMapping("/delUser/{Id}")
	public ResponseEntity<Void> delUser(
			@ApiParam(value = "Id", required = true) @RequestParam("Id") String id) {

		try {
			userService.delUser(id);
		} catch (BusinessException e) {
			//ResponseResult.makeResult(response, e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

	@ApiOperation("修改用户信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 201, message = "资源被正确的创建"),
			@ApiResponse(code = 401, message = "没有提供认证信息"), @ApiResponse(code = 403, message = "无权访问"),
			@ApiResponse(code = 404, message = "无效的请求路径") })
	@PutMapping("/putUser")
	public ResponseEntity<Void> updateUser(HttpServletResponse response,
			@ApiParam(name = "Id", value = "用户Id", required = true) @RequestParam("Id") String key,
			@ApiParam(value = "用户信息") @RequestBody UserDetail detail) {

		try {
			userService.updateUser(key, detail);
		} catch (BusinessException e) {
			ResponseResult.makeResult(response, e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
