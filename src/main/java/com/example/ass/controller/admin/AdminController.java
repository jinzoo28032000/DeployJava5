package com.example.ass.controller.admin;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ass.entities.Account;
import com.example.ass.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AccountRepository accountRepository;

	@GetMapping("")
	public String admin(Model model, Principal principal) {
		return "admin/index";
	}

}
