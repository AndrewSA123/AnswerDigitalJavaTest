package com.Andrew.store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.Andrew.persistence.domain.Product;

public class Till {
	
	
	private String receipt = "";
	
	private List<String> Basket = new ArrayList<String>();
	
	private boolean waitingOnUser = true;
	
	private String temp;
	
	private Store store;
	
	private boolean stocked = false;
	
	public Till(Store store) {
		
		this.store = store;
		
	}
	
	public String scanProduct(String productCode) {
		Basket.add(productCode);
		return "Scanned " + productCode;
	}
	
	public String getReceipt(){
		for(String a : Basket) {
			receipt += (a + " ");
		}
		return this.receipt;
	}
	
	public String enterNumbers() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(waitingOnUser) {
			try {
					temp = reader.readLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			if(temp.equals("*"))
			{
				waitingOnUser = false;
			}else {
				for(Product a : store.getProducts()) {
					if(a.getProductCode().equals(temp)) {
						scanProduct(temp);
						stocked = true;
						break;
					}
				}
				if(stocked == false) {
					return "Store does not stock this item.";
				}
				stocked = false;
				
			}
		}
		return getReceipt();
	}

}
