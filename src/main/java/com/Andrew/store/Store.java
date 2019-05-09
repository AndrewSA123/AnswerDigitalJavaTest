package com.Andrew.store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Andrew.persistence.domain.Product;

public class Store {

	private List<Product> productsList = new ArrayList<Product>();
	
	public Store() {
		
	}
	
	public void addProduct(Product product) {
		productsList.add(product);
	}
	
	public List<Product> getProducts() {
		return productsList;
	}
	
	public String printProductsToFile(String fileName) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
			writer.write("Product Code    Description     Price");
			writer.newLine();
			for (Product product : productsList) {
				writer.write(product.toString());
				writer.newLine();
			}
			writer.close();
			return fileName + ".txt";
			
		} catch (IOException e) {
			e.printStackTrace();
			return "Failed";
		}
	}
	
}
