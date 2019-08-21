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

import com.sdl.swagger.api.ItemApi;
import com.sdl.swagger.entity.Item;
import com.sdl.swagger.exception.BusinessException;
import com.sdl.swagger.service.ItemService;
import com.sdl.swagger.util.ResponseResult;

import io.swagger.annotations.ApiParam;

@RestController
public class ItemControlle implements ItemApi{

	@Autowired
	private ItemService itemService;

	public ResponseEntity<List<Item>> queryAll() {


		List<Item> list = itemService.queryAll();
		return new ResponseEntity<List<Item>>(list, HttpStatus.OK);

	}

	public ResponseEntity<Item> getItemById(
			@ApiParam(value = "项目moid", required = true) @PathVariable("moid") String moid) {

		Item data = itemService.getItemById(moid);
		return new ResponseEntity<Item>(data, HttpStatus.OK);
	}

	public ResponseEntity<Void> saveItem(HttpServletResponse response,
			@ApiParam(value = "项目信息") @RequestBody Item item) {

		try {
			itemService.saveItem(item);
		} catch (BusinessException e) {
			ResponseResult.makeResult(response, e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> delItem(
			@ApiParam(value = "moidmoid", required = true) @RequestParam("moid") String moid) {

		try {
			itemService.delItem(moid);
		} catch (BusinessException e) {
			//ResponseResult.makeResult(response, e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

	public ResponseEntity<Void> updateItem(HttpServletResponse response, @ApiParam(value = "项目信息") @RequestBody Item item) {

		try {
			itemService.updateItem(item);
		} catch (BusinessException e) {
			ResponseResult.makeResult(response, e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
