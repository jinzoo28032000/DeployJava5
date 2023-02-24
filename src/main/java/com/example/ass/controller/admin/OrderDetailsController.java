package com.example.ass.controller.admin;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ass.beans.OrderDetailBean;
import com.example.ass.beans.ProductBean;
import com.example.ass.entities.Order;
import com.example.ass.entities.OrderDetail;
import com.example.ass.entities.Product;
import com.example.ass.repositories.OrderDetailsRepository;

@Controller

public class OrderDetailsController {
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@GetMapping("/oderde/{id}")
	public String edit(Model model,
			@PathVariable("id") Order order) {
		List<OrderDetail> loadlist = orderDetailsRepository.findByOrder(order);
		
		model.addAttribute("loadlist", loadlist);
		return "admin/Orderde/index";
	}

}
