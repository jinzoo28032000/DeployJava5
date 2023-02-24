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

import com.example.ass.beans.CategoryBean;
import com.example.ass.entities.Category;
import com.example.ass.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@GetMapping({ "", "/list" })
	public String index(Model model) {
		List<Category> list = categoryService.findAll();
		model.addAttribute("list", list);
		return "admin/category/index";
	}

	@GetMapping("/create")
	public String create(Model model, @ModelAttribute("category") CategoryBean categoryBean) {
		return "admin/category/create";
	}

	@PostMapping("/store")
	public String store(Model model, @Validated @ModelAttribute("category") CategoryBean categoryBean,
			BindingResult result) {
		if (!result.hasErrors()) {
			Category category = new Category();
			category.setName(categoryBean.getName());
			categoryService.save(category);
			return "admin/category/createsuccess";
		}
		return "admin/category/create";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Category category) {
		categoryService.delete(category);
		return "redirect:/admin/category";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @ModelAttribute("category") CategoryBean categoryBean,
			@PathVariable("id") Category category) {
		model.addAttribute("category", category);
		return "admin/category/edit";
	}

	@PostMapping("edit/update/{id}")
	public String update(Model model, @Validated @ModelAttribute("category") CategoryBean categoryBean,
			@PathVariable("id") Category category, BindingResult result) {
		if (!result.hasErrors()) {
			category.setName(categoryBean.getName());
			categoryService.save(category);
			return "admin/category/editsuccess";
		}
		return "admin/category/edit";
	}
}
