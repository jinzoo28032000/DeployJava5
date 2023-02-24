package com.example.ass.controller.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ass.beans.AccountBean;
import com.example.ass.entities.Account;
import com.example.ass.service.AccountService;

@Controller
@RequestMapping("/admin/account")
public class AccountController {
	@Autowired
	AccountService accountService;

	@GetMapping({ "", "/list" })
	public String index(Model model) {
		List<Account> list = accountService.findAll();
		model.addAttribute("list", list);
		return "admin/account/index";
	}

	@GetMapping("/create")
	public String create(Model model, @ModelAttribute("account") AccountBean accountBean) {
		return "admin/account/create";
	}

	@PostMapping("/store")
	public String store(Model model, @Validated @ModelAttribute("account") AccountBean accountBean,
			BindingResult result) {
		if (!result.hasErrors()) {
			if (!accountBean.getPhoto().isEmpty()) {
				try {
					byte[] bytes = accountBean.getPhoto().getBytes();
					Path path = Paths.get(
							"src/main/resources/static/images/account/" + accountBean.getPhoto().getOriginalFilename());
					Files.write(path, bytes);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Account account = new Account();
			account.setFullname(accountBean.getFullname());
			account.setEmail(accountBean.getEmail());
			account.setPassword(accountBean.getPassword());
			account.setPhoto(accountBean.getPhoto().getOriginalFilename());
			account.setActivated(accountBean.getActivated());
			account.setAdmin(accountBean.getAdmin());
			account.setUsername(accountBean.getUsername());
			accountService.save(account);
			return "admin/account/createsuccess";
		}
		return "admin/account/create";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Account account) {
		accountService.delete(account);
		return "redirect:/admin/account";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @ModelAttribute("account") AccountBean accountBean,
			@PathVariable("id") Account account) {
		model.addAttribute("account", account);
		return "admin/account/edit";
	}

	@PostMapping("/edit/update/{id}")
	public String update(Model model, @Validated @ModelAttribute("account") AccountBean accountBean,
			BindingResult result, @PathVariable("id") Account account) {
		if (!result.hasErrors()) {
			if (!accountBean.getPhoto().isEmpty()) {
				try {
					byte[] bytes = accountBean.getPhoto().getBytes();
					Path path = Paths.get(
							"src/main/resources/static/images/account/" + accountBean.getPhoto().getOriginalFilename());
					Files.write(path, bytes);
					account.setPhoto(accountBean.getPhoto().getOriginalFilename());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			account.setFullname(accountBean.getFullname());
			account.setEmail(accountBean.getEmail());
			account.setActivated(accountBean.getActivated());
			account.setAdmin(accountBean.getAdmin());
			account.setUsername(accountBean.getUsername());
			accountService.save(account);
			return "admin/account/editsuccess";
		}
		return "admin/account/edit";
	}
}
