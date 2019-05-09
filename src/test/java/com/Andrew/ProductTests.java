package com.Andrew;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Andrew.persistence.domain.Product;
import com.Andrew.store.Store;
import com.Andrew.store.Till;


public class ProductTests {
	
	public Product testProduct1;
	public Product testProduct2;
	
	public Store testStore1;
	public Store testStore2;
	
	public Till testTill;
	
	@Before
	public void setup() {
		testProduct1 = new Product("ProductCode1	Description1	34789375"); 
		testProduct2 = new Product("ProductCode2	fgnjefgnbviref	5437895734956"); 
		testStore1 = new Store();
		testStore2 = new Store();
		testStore1.addProduct(testProduct1);
		testStore1.addProduct(testProduct2);
		testStore2.addProduct(testProduct1);
		testTill = new Till(testStore1);
	}
	
	@After
	public void teardown() {
		
	}
	
	@Test
	public void parsingTest() {
		assertEquals("ProductCode1", testProduct1.getProductCode());
		assertEquals("Description1", testProduct1.getDescription());
		assertEquals(34789375, testProduct1.getPrice().intValue());
	}
	
	@Test
	public void hashCodeTest() {
		assertNotSame(testProduct1.hashCode(), testProduct2.hashCode());
		assertNotSame(testStore1.hashCode(), testProduct2.hashCode());
	}
	
	@Test
	public void equalsTest() {
		assertEquals(false, testProduct1.equals(testProduct2));
		assertEquals(false, testProduct2.equals(testProduct1));
		assertEquals(false, testStore1.equals(testStore2));
		assertEquals(false, testStore2.equals(testStore1));
	}
	
	@Test
	public void printingToFileTest() {
		assertEquals("filename.txt", testStore1.printProductsToFile("filename"));
		assertEquals("places.txt", testStore2.printProductsToFile("places"));
	}
	
	@Test
	public void receiptTests() {
		assertEquals("Scanned ProductCode1", testTill.scanProduct(testProduct1.getProductCode()));
		assertEquals("Scanned ProductCode2", testTill.scanProduct(testProduct2.getProductCode()));
		
		assertEquals("ProductCode1 ProductCode2 ", testTill.getReceipt());
	}
	
	
	//Enter "ProductCode1" Hit enter "ProductCode2" hit enter "*" to get the test to pass
	//To get it to pass with anything edit the AssertEquals+
	@Test
	public void productCodeTest() {
		System.out.println("Input ProductCode1 then ProductCode2 then type *");
		assertEquals("ProductCode1 ProductCode2 ",testTill.enterNumbers());
	}
	@Test
	public void errorTest() {
		System.out.println("Enter a random string then type *");
		assertEquals("Store does not stock this item.", testTill.enterNumbers());
	}
	
	

}
