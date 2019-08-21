/**
 * @author sundonglin
 * @date 2018年9月13日 上午10:10:36
 */
package com.sdl.swagger.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sdl.swagger.api.DeptApi;
import com.sdl.swagger.entity.Dept;
import com.sdl.swagger.exception.BusinessException;
import com.sdl.swagger.service.DeptService;
import com.sdl.swagger.util.ResponseResult;

import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author sundonglin
 * @date 2018年9月13日 上午10:10:36
 */
//@ApiIgnore
@RestController
public class DeptController implements DeptApi {
	
	@Autowired
	private DeptService deptService;
	
	public ResponseEntity<List<Dept>> getAllDept() throws Exception {
		
		List<Dept> allDept = deptService.getAllDept();
		return new ResponseEntity<List<Dept>>(allDept, HttpStatus.OK);
	}
	
	public ResponseEntity<Void> saveDept(@ApiParam(name = "dept", value = "部门信息") @RequestBody Dept dept) {
		deptService.saveDept(dept);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	public ResponseEntity<Void> putDept(HttpServletResponse response, int index, Dept dept){
		
		try {
			
			deptService.putDept(index, dept);
		} catch (BusinessException e) {
			
			ResponseResult.makeResult(response, e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
