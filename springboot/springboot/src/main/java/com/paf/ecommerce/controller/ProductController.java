package com.paf.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.ecommerce.dao.ProductDAO;
import com.paf.ecommerce.model.Product;

@RestController
@RequestMapping("/onlineShop")
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	
	//to save a product
	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product p) {
		
		 return productDAO.save(p);
	}
	
	
	
	
	//get all products
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		
		return productDAO.findAll();
	}
	
	//get product by id 
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value="id") Long productID){
		
		Product p = productDAO.findOne(productID);
		if(p==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(p);
	}
	
	
	//update product details by productID
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value="id") Long productID,@Valid @RequestBody Product productDetails){
		
		Product p = productDAO.findOne(productID);
		if(p==null) {
			return ResponseEntity.notFound().build();
		}
		
		p.setName(productDetails.getName());
		p.setBrand(productDetails.getBrand());
		p.setCode(productDetails.getCode());
		p.setUnitPrice(productDetails.getUnitPrice());
		p.setQuantity(productDetails.getQuantity());
		
		Product updateProduct = productDAO.save(p);
		return ResponseEntity.ok().body(updateProduct);
	}
	
	
	//Delete a product
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value="id") Long productID){
		
		Product p = productDAO.findOne(productID);
		if(p==null) {
			return ResponseEntity.notFound().build();
		}
		
		productDAO.delete(p);
		
		return ResponseEntity.ok().build();
	}
}
