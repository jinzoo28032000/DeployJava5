package com.example.ass.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ass.entities.Account;
import com.example.ass.entities.Category;
import com.example.ass.repositories.AccountRepository;
import com.example.ass.repositories.CategoryRepository;
import com.example.ass.repositories.ProductRepository;

@Controller
@RequestMapping({ "", "/home" })
public class HomeController {
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	@GetMapping("")
	public String home(Model model, Principal principal) {
		model.addAttribute("category", categoryRepository.findAll());
		model.addAttribute("product", productRepository.findAll());
		return "index";
	}

	@GetMapping("/category/{id}")
	public String findByCategory(Model model, Principal principal, @PathVariable("id") Category category) {
		model.addAttribute("category", categoryRepository.findAll());
		model.addAttribute("product", productRepository.findByCategory(category));
		return "index";
	}
}
