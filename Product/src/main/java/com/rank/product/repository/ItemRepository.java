package com.rank.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rank.product.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

   @Query("SELECT u FROM Item u WHERE u.itemName=:name")
	public Optional<Item> getItemByItemName(@Param("name") String name);
	
	
	

}
