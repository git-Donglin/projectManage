/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:12:06
 */
package com.sdl.swagger.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdl.swagger.entity.Dept;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:12:06
 */
@Api(value = "部门服务", tags = {"部门服务接口"})
@RequestMapping("/dept")
public interface DeptApi {

	@ApiOperation(value = "获取所有的部门信息", notes = "部门信息服务接口")
	@GetMapping("/getAllDept")
	public ResponseEntity<List<Dept>> getAllDept() throws Exception;
	
	@ApiOperation(value = "添加部门信息", tags = {"用户接口"}, notes = "添加部门信息服务接口", response = Void.class)
	@PostMapping("/saveDept")
	public ResponseEntity<Void> saveDept(@ApiParam(name = "dept", value = "部门信息")  Dept dept);
	
}
