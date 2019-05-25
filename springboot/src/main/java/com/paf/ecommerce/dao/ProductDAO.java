package com.paf.ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.ecommerce.model.Product;
import com.paf.ecommerce.repository.ProductRepository;

@Service
public class ProductDAO {

	@Autowired
	ProductRepository productRepository;
	
	// to save a product
	public Product save(Product p) {
		
		return productRepository.save(p);
	}
	
	//to search all products
	public List<Product> findAll(){
		
		return productRepository.findAll();
	}
	
	//get a product by id
	public Product findOne(Long productID) {
		
		return productRepository.findOne(productID);
	}
	
	//delete product
	public void delete(Product p) {
		
		productRepository.delete(p);
	}
	
	
}
