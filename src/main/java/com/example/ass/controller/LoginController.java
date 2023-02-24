package com.example.ass.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ass.entities.Account;
import com.example.ass.repositories.AccountRepository;

@Controller
public class LoginController {
	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/login")
	public String login(Model model) {
		return "/auth/login";
	}

	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin";
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		if (principal != null) {
			String message = "Hi " + principal.getName() //
					+ "<br>Ban khong the vao trang nay!";
			model.addAttribute("message", message);
		}
		return "/auth/403";
	}

	@GetMapping("/save")
	public String save() {
		accountRepository
				.save(new Account(1, "admin", "123", "long", "longvtph18869@fpt.edu.vn", "userdefault.png", 0, "ROLE_ADMIN"));
		accountRepository
				.save(new Account(2, "user", "123", "long", "longvtph18862@fpt.edu.vn", "user1.png", 0, "ROLE_USER"));
		accountRepository
				.save(new Account(3, "user1", "123", "long", "longvtph18861@fpt.edu.vn", "user2.png", 0, "ROLE_USER"));
		return "redirect:/login";
	}
}
