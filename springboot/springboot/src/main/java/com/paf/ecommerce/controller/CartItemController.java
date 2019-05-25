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

import com.paf.ecommerce.dao.CartItemDAO;
import com.paf.ecommerce.model.CartItem;

@RestController
@RequestMapping("/onlineShop")
public class CartItemController {
	
	@Autowired
	CartItemDAO cartItemDAO;
	
	//to save a cartItem
	@PostMapping("/cartitems")
	public CartItem createCartItem(@Valid @RequestBody CartItem ci) {
		
		 return cartItemDAO.save(ci);
	}
	
	
	
	
	//get all cartItem
	@GetMapping("/cartitems")
	public List<CartItem> getAllCartItems(){
		
		return cartItemDAO.findAll();
	}
	
	//get cartItem by id 
	@GetMapping("/cartitems/{id}")
	public ResponseEntity<CartItem> getCartItemById(@PathVariable(value="id") Long cartItemID){
		
		CartItem ci = cartItemDAO.findOne(cartItemID);
		if(ci==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ci);
	}
	
	
	//update CartItem details by cartItemID
	@PutMapping("/cartitems/{id}")
	public ResponseEntity<CartItem> updateCartItem(@PathVariable(value="id") Long cartItemID,@Valid @RequestBody CartItem cartItemDetails){
		
		CartItem ci = cartItemDAO.findOne(cartItemID);
		if(ci==null) {
			return ResponseEntity.notFound().build();
		}
		
		ci.setMemberId(cartItemDetails.getMemberId());
		ci.setProductCode(cartItemDetails.getProductCode());
		ci.setBrand(cartItemDetails.getBrand());
		ci.setUnitPrice(cartItemDetails.getUnitPrice());
		ci.setQty(cartItemDetails.getQty());
		ci.setTotalAmount(cartItemDetails.getTotalAmount());
		
		CartItem updateCartItem = cartItemDAO.save(ci);
		return ResponseEntity.ok().body(updateCartItem);
	}
	
	
	//Delete a cartItem
	@DeleteMapping("/cartitems/{id}")
	public ResponseEntity<CartItem> deleteCartItem(@PathVariable(value="id") Long cartItemID){
		
		CartItem ci = cartItemDAO.findOne(cartItemID);
		if(ci==null) {
			return ResponseEntity.notFound().build();
		}
		
		cartItemDAO.delete(ci);
		
		return ResponseEntity.ok().build();
	}

}
