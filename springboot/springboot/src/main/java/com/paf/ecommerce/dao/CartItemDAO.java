package com.paf.ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.ecommerce.model.CartItem;
import com.paf.ecommerce.repository.CartItemRepository;

@Service
public class CartItemDAO {

	@Autowired
	CartItemRepository cartItemRepository;
	
	// to save a cartItem
	public CartItem save(CartItem ci) {
		
		return cartItemRepository.save(ci);
	}
	
	//to search all cartItems
	public List<CartItem> findAll(){
		
		return cartItemRepository.findAll();
		
	}
	
	//get a cartItem by id
	public CartItem findOne(Long cartItemID) {
		
		return cartItemRepository.findOne(cartItemID);
	}
	
	//delete cartItem
	public void delete(CartItem ci) {
		
		cartItemRepository.delete(ci);
	}
	
	
}
