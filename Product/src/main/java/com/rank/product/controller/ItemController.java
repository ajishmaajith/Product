package com.rank.product.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rank.product.model.Item;
import com.rank.product.service.ItemService;

@RestController
public class ItemController {
	
	
	@Autowired
	ItemService service;

	
	@GetMapping("ListItems")
	
	public List<Item> getAllItems(){
		return service.listAllItems();
	}
	
	@PostMapping("additems")
	public ResponseEntity<Item> addItems(@Valid @RequestBody Item item){
		return new ResponseEntity<>(service.addItems(item), HttpStatus.OK);
	}
	
	@PutMapping("updateitem/{id}")
	public ResponseEntity<Item> updateItems(@Valid @RequestBody Item item,@PathVariable long id){
		return new ResponseEntity<>(service.updateItem(item,id), HttpStatus.OK);
	}
	@GetMapping("getbyid/{id}")
	public Item getById(@PathVariable long id) {
		return service.getById(id);
	}
	@DeleteMapping("deleteItem/{id}")
	public Map<String,Boolean> deleteItem(@PathVariable long id)
	{
		return service.deleteById(id);
	}
	@GetMapping("GetByName/{name}")
	public Item getByName(@PathVariable String name) {
		return service.getItemByName(name);
	}
}
