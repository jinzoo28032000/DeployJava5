package com.example.ass.controller;

import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ass.entities.Account;
import com.example.ass.entities.Order;
import com.example.ass.entities.OrderDetail;
import com.example.ass.entities.Product;
import com.example.ass.repositories.OrderDetailsRepository;
import com.example.ass.repositories.OrderRepository;
import com.example.ass.service.AccountService;
import com.example.ass.util.CartUtil;

@Controller
public class CartController {
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	AccountService accountService;

	@Autowired
	OrderDetailsRepository detailsRepository;

	@GetMapping("/cart")
	public String cart(HttpServletRequest request, Model model) {
		Order order = CartUtil.getCartInSession(request);
		model.addAttribute("cart", order);
		return "cart";
	}

	@PostMapping("/cart/buy/{id}")
	public String buy(HttpServletRequest request, Model model, @PathVariable("id") Product product) {
		Order order = CartUtil.getCartInSession(request);
		order.addProduct(product, 1);
		return "redirect:/cart";
	}

	@GetMapping("/cart/remove/{id}")
	public String remove(HttpServletRequest request, Model model, @PathVariable("id") Product product) {
		Order order = CartUtil.getCartInSession(request);
		order.removeProduct(product);
		return "redirect:/cart";
	}

	@GetMapping("/cart/purchase")
	public String purchase(HttpServletRequest request, Model model) {
		Order order = CartUtil.getCartInSession(request);
		model.addAttribute("total", order.getTotal());
		model.addAttribute("cart", order);
		return "payment";
	}

	@PostMapping("/payment")
	public String payment(@RequestParam("address") String address, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountService.findByUsername(auth.getName());
		Order order = CartUtil.getCartInSession(request);
		order.setAccount(account);
		order.setAddress(address);
		order.setCreateDate(new Date());
		orderRepository.save(order);
		for (int i = 0; i < order.getOrderDetails().size(); i++) {
			order.getOrderDetails().get(i).setOrder(order);
			order.getOrderDetails().get(i).setPrice(order.getOrderDetails().get(i).getProduct().getPrice());
		}
		detailsRepository.saveAll(order.getOrderDetails());
		CartUtil.removeCartInSession(request);
		return "redirect:/cart";
	}
}
