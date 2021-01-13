package com.rank.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rank.product.exception.ResourceNotFoundException;
import com.rank.product.model.Item;
import com.rank.product.repository.ItemRepository;

@Service
public class ItemService {
	
	private static final Logger logger=LoggerFactory.getLogger(ItemService.class);
	@Autowired
	ItemRepository repo;

	public List<Item> listAllItems() {
		logger.info("Inside list method");
		
		
		return repo.findAll();
	}

	public Item addItems(Item item) {
		return repo.save(item);
	}

	public Item updateItem(Item item, long id) {
		Optional<Item> o=repo.findById(id);
		if(o.isPresent()) {
			o.get().setItemName(item.getItemName());
			o.get().setAmount(item.getAmount());
			return repo.save(o.get());

		}else {
			throw new ResourceNotFoundException("No details found for this id:"+id);
		}
	}

	public Item getById(long id) {
		logger.info("Inside get by id method !");
		Optional<Item> o=repo.findById(id);
		if(o.isPresent()) {
			
			return o.get();

		}else {
			throw new ResourceNotFoundException("No details found for this id:"+id);
		}
	}

	public Map<String, Boolean> deleteById(long id) {
		Optional<Item> o=repo.findById(id);
		if(o.isPresent()) {
			
			repo.delete(o.get());
			Map<String,Boolean> m=new HashMap<>();
			m.put("Deleted!!", true);
			return m;

		}else {
			throw new ResourceNotFoundException("No details found for this id:"+id);
		}
	}

	public Item getItemByName(String name) {
		Optional<Item> o=repo.getItemByItemName(name);
		if(o.isPresent()) {
		
		return o.get();
		}else {
			throw new ResourceNotFoundException("No details found for this name:"+name);
		}
	}
	
	
	

}
