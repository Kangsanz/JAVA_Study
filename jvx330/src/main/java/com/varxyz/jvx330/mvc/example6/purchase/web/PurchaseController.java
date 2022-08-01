package com.varxyz.jvx330.mvc.example6.purchase.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.jvx330.mvc.example6.product.domain.Product;

@Controller("example6.purchaseController")
@RequestMapping("/example6/purchase_page")
public class PurchaseController {

	@GetMapping
	public String purchaseForm(Model model) {
		model.addAttribute("product", new Product());
		return "example6/purchase_page";
	}

	@PostMapping
	public String addCustomer(@ModelAttribute("product") Product product, Model model) {

		// db처리
		// ... (가정)
		// customer = customerService.addCustomer(customer);

		model.addAttribute("product", product);
		return "example6/purchase_page";
	}
}
