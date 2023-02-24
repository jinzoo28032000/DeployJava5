package com.example.ass.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ass.entities.Category;
import com.example.ass.entities.Order;
import com.example.ass.entities.OrderDetail;
import com.example.ass.repositories.OrderDetailsRepository;
import com.example.ass.repositories.OrderRepository;

@Controller
@RequestMapping("/admin/order")
public class OderController {
		@Autowired
		OrderRepository orderRepository;
		
		@GetMapping({ "", "/list" })
		public String index(Model model) {
			List<Order> list = orderRepository.findAll();
			model.addAttribute("list", list);
			return "admin/Order/index";
		}
}
