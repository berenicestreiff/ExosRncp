package com.berenice.Qualimetrie1;

import org.junit.Test;
import static org.junit.Assert.*;

import metier.InvalidIdException;
import metier.ProductNameException;
import metier.ProductPoidsException;
import metier.ProductPriceProduct;
import metier.ProductStockException;
import metier.Produit;

public class ProduitTest {
	
	// test sur l'ensemble du produit
	@Test 
	public void TestProductOk (){
		Produit p = new Produit(1,"chou", 1.59, 2.7, 100);
		String expected ="chou";
		String actual= p.getNom();
		assertEquals(expected, actual);
	
		
		
	}
	@Test(expected=InvalidIdException.class)
	public void TestProductId (){
		Produit p = new Produit(-1,"chou", 1.59, 2.7, 100);
	
	}
	
	
	@Test(expected=ProductNameException.class)
	public void TestProductNameLength (){
		Produit p = new Produit(-1,"ch", 1.59, 2.7, 100);
	
	}
	
	@Test(expected=ProductPriceProduct.class)
	public void TestProductPriceProduct (){
		Produit p = new Produit(-1,"ch", 1200.7, 2.7, 100);

}
	@Test(expected=ProductPoidsException.class)
	public void TestProductPoidsProduct (){
		Produit p = new Produit(-1,"ch", 1200.7, 60.0, 100);

}
	
	@Test(expected=ProductStockException.class)
	public void TestProductStockProduct (){
		Produit p = new Produit(-1,"ch", 1200.7, 60.0, -100);

}
}
