package com.sdl.swagger.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdl.swagger.api.FunctionApi;
import com.sdl.swagger.entity.Function;
import com.sdl.swagger.exception.BusinessException;
import com.sdl.swagger.service.FunctionService;
import com.sdl.swagger.util.ResponseResult;

import io.swagger.annotations.ApiParam;

@RestController
public class FunctionControlle implements FunctionApi{

	@Autowired
	private FunctionService FunctionService;

	public ResponseEntity<List<Function>> queryAll() {

		List<Function> list = FunctionService.queryAll();
		return new ResponseEntity<List<Function>>(list, HttpStatus.OK);

	}

	public ResponseEntity<Function> getFunctionById(
			@ApiParam(value = "项目Id", required = true) @PathVariable("moid") String moid) {

		Function data = FunctionService.getFunctionById(moid);
		return new ResponseEntity<Function>(data, HttpStatus.OK);
	}

	public ResponseEntity<Void> saveFunction(HttpServletResponse response,
			@ApiParam(value = "项目信息") @RequestBody Function function) {

		try {
			FunctionService.saveFunction(function);
		} catch (BusinessException e) {
			ResponseResult.makeResult(response, e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> delFunction(
			@ApiParam(value = "moid", required = true) @RequestParam("moid") String moid) {

		try {
			FunctionService.delFunction(moid);
		} catch (BusinessException e) {
			//ResponseResult.makeResult(response, e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

	public ResponseEntity<Void> updateFunction(HttpServletResponse response,@ApiParam(value = "项目信息") @RequestBody Function function) {

		try {
			FunctionService.updateFunction(function);
		} catch (BusinessException e) {
			ResponseResult.makeResult(response, e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Function>> getFunctionByItemMoid(HttpServletResponse response, @PathVariable("moid") String moid) {
		try {
			
			List<Function> list = FunctionService.getFunctionByItemMoid(moid);
			return new ResponseEntity<List<Function>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
