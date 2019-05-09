package com.Andrew.persistence.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	private String productCode;
	
	private String description;
	
	private BigDecimal price;
	
	String[] temp;
	
	public Product() {
		
	}
	
	public Product(String object) {
		for(int i = 0; i < object.length(); i++) {
			if(object.charAt(i) == '	') {
				temp = object.split("	");
				continue;
			}
		}
		this.productCode = temp[0];
		this.description = temp[1];
		this.price = new BigDecimal(temp[2]);
	}
	
	public String getProductCode() {
		return this.productCode;
	}
	
	public String getDescription() {
		return this.description;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return this.productCode + "	" + this.description + "	" + this.price;
	}

	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
