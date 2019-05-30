package com.paf.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("/addProduct")
	public String home() {
		return "addProduct";
	}

}