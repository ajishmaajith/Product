package com.rank.product.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.rank.product.audit.Auditable;



@Entity
@EntityListeners(AuditingEntityListener.class)

public class Item extends Auditable<String>{
	
	@Id
	@GeneratedValue
	private long id;
	@NotNull
	@Size(min=2,message="ItemName should have atleast 2 characters")
	private String itemName;
	@Range(min = 0, max = 100,message="Amount should be in the range of 0-100")
    private float amount;
	public long getId() {
		return id;
	}
	public String getItemName() {
		return itemName;
	}
	public float getAmount() {
		return amount;
	}
	public Item(long id, String itemName, float amount) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.amount = amount;
	}
	public Item() {
		
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	

}
