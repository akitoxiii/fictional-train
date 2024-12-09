package com.example.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController05 {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/db01")
	public String db01(Model m) {
		List<Product> products = productRepository.findAll();

		m.addAttribute("products", products);

		return "db01";
	}

	@GetMapping("/db02")
	public String db02(Model m) {
		Product p = null;
	
		Optional<Product> record = productRepository.findById("0102");
		if (!record.isEmpty()) {
			p = record.get();
		}
	}
}